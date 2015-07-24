package ${topPackage}.${subPackage}.${artifactId}.core.service.querydsl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;

import ${topPackage}.${subPackage}.${artifactId}.core.model.BaseEntity;
import ${topPackage}.${subPackage}.${artifactId}.core.model.Unique;
import ${topPackage}.${subPackage}.${artifactId}.core.service.base.dao.BaseDao;
import ${topPackage}.${subPackage}.${artifactId}.core.service.search.Search;
import ${topPackage}.${subPackage}.${artifactId}.core.service.search.SearchCriteria;
import ${topPackage}.${subPackage}.${artifactId}.core.service.search.SortOrderList;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.EntityPath;
import com.mysema.query.types.path.BeanPath;

/**
 * Search base class implementation which uses QueryDsl.
 * 
 * @author gtassone
 *
 * @param <T>
 */
public abstract class BaseQueryDslSearch<T extends BaseEntity> implements Search<T> {

	private BaseDao<T> dao;

	/**
	 * setter and injection point for DAO.
	 * 
	 * A BaseDao handle is required to access the EntityManager when performing
	 * Search.
	 * 
	 * @param dao
	 */
	protected void setDao(BaseDao<T> dao) {
		this.dao = dao;
	}

	protected EntityManager getEntityManager() {
		return dao.getEntityManager();
	}

	@Override
	public int count(SearchCriteria<? super T> criteria) {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<T> search(SearchCriteria<? super T> searchCriteria) {
		List<T> entityList = new ArrayList<>();

		 for (T entity : getEntities(getEntityPath(),
		 generateSearchQuery(searchCriteria))) {
		 entityList.add(entity);
		 }
		return Collections.unmodifiableList(entityList);
	}
	
	protected List<T> getEntities(EntityPath<T> entityPath, JPAQuery query) {
		return query.list(entityPath);
	}

	protected JPAQuery generateSearchQuery(SearchCriteria<? super T> searchCriteria) {
		JPAQuery query = new JPAQuery(getEntityManager()).from(getEntityPath());

		addSearchCriteria(query, searchCriteria);

		 // Limit the rows to the range requested
		 configureRange(query, searchCriteria.getOffset(),
		 searchCriteria.getMaxItems());
		
		 // Add an order by clause to sort the results
		 configureSorting(query, getEntityPath(),
		 searchCriteria.getSortOrderList());

		return query;
	}

	protected void configureSorting(JPAQuery query,
			EntityPath<T> entityPathBase, SortOrderList sortOrderList) {
		QueryDslDaoUtils.configureOrderBy(query, entityPathBase,
				filterSortOrderList(sortOrderList));
	}

	protected void configureRange(JPAQuery query, long offset, long maxItems) {
		// offset
		if (offset > 0) {
			query.offset(offset);
		} else {
			query.offset(0L);
		}

		// max items
		if (maxItems > 0) {
			query.limit(maxItems);
		} else {
		}
	}

	/**
	 * This method may be overridden by sub-classes to add entity-specific
	 * search criteria.
	 * 
	 * @param query
	 *            JPAQuery object to add criteria to
	 * @param searchCriteria
	 *            the search criteria to use while searching
	 */
	protected abstract void addSearchCriteria(JPAQuery query,
			SearchCriteria<? super T> searchCriteria);

	/**
	 * Used by the abstract implementation to get the correct QueryDSL Entity
	 * object.
	 * 
	 * @return QueryDSL Entity Path Base
	 */
	protected abstract EntityPath<T> getEntityPath();

    /**
     * Subclasses should override as needed. Provides ability to filter sort order prior to application.
     *
     * @param sortOrderList Sort Order List
     * @return filtered Sort Order List
     */
    protected abstract SortOrderList filterSortOrderList(SortOrderList sortOrderList);
}
