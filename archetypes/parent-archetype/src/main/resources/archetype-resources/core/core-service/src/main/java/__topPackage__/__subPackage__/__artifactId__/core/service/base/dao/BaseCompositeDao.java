package ${topPackage}.${subPackage}.${artifactId}.core.service.base.dao;

import java.util.List;

import ${topPackage}.${subPackage}.${artifactId}.core.model.BaseEntity;
import ${topPackage}.${subPackage}.${artifactId}.core.service.search.Search;
import ${topPackage}.${subPackage}.${artifactId}.core.service.search.SearchCriteria;

/**
 * Abstract base class for DAOs which delegate search operations to a Search
 * object.
 * 
 * @author gtassone
 * 
 * @param <T>
 */
public abstract class BaseCompositeDao<T extends BaseEntity> extends BaseDao<T> {

	private Search<T> search;

	protected BaseCompositeDao(Class<T> entityClass) {
		super(entityClass);
	}

	protected BaseCompositeDao(Class<T> entityClass, Search<T> search) {
		super(entityClass);
		this.search = search;
	}

	public List<T> search(SearchCriteria<? super T> criteria) {
		return search.search(criteria);
	}

	protected void setSearch(Search<T> search) {
		this.search = search;
	}
}
