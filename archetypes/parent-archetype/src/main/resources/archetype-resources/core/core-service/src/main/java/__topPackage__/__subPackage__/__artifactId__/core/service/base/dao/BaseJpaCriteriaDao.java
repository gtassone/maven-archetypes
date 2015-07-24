package ${topPackage}.${subPackage}.${artifactId}.core.service.base.dao;

import ${topPackage}.${subPackage}.${artifactId}.core.model.BaseEntity;

/**
 * Abstract base class for DAOs that use JPA Criteria API to perform search
 * queries.
 * 
 * @author gtassone
 * 
 * @param <T>
 */
public abstract class BaseJpaCriteriaDao<T extends BaseEntity> extends
		BaseDao<T> {

	protected BaseJpaCriteriaDao(Class<T> entityClass) {
		super(entityClass);
	}

}
