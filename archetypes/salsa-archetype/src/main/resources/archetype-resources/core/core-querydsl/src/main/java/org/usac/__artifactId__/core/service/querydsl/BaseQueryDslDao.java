package org.usac.${artifactId}.core.service.querydsl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.usac.${artifactId}.core.model.BaseEntity;
import org.usac.${artifactId}.core.model.Unique;
import org.usac.${artifactId}.core.service.base.dao.BaseDao;
import org.usac.${artifactId}.core.service.search.SearchCriteria;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.EntityPath;

public abstract class BaseQueryDslDao<T extends BaseEntity> extends BaseDao<T> {

	protected BaseQueryDslDao(Class<T> entityClass) {
		super(entityClass);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<T> search(SearchCriteria<? super T> searchCriteria) {
		List<T> entityList = new ArrayList<>();

		for (T entity : getEntities(getEntityPathBase(),
				generateSearchQuery(searchCriteria))) {
			entityList.add(entity);
		}
		return Collections.unmodifiableList(entityList);
	}

	protected List<T> getEntities(EntityPath<T> entityPath, JPAQuery query) {
		return query.list(entityPath);
	}

	protected JPAQuery generateSearchQuery(
			SearchCriteria<? super T> searchCriteria) {
		JPAQuery query = new JPAQuery(getEntityManager())
				.from(getEntityPathBase());
		addSearchCriteria(query, searchCriteria);

		// // Limit the rows to the range requested
		// configureRange(query, searchCriteria.getOffset(),
		// searchCriteria.getMaxItems());
		//
		// // Add an order by clause to sort the results
		// configureSorting(query, getEntityPathBase(),
		// searchCriteria.getSortOrderList());

		return query;
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
	protected abstract EntityPath<T> getEntityPathBase();

}
