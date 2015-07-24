package org.usac.${artifactId}.core.service.base.dao;

import org.usac.${artifactId}.core.model.BaseEntity;

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
