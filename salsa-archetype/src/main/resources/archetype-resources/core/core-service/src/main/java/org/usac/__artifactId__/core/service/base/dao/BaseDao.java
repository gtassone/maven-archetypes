package org.usac.${artifactId}.core.service.base.dao;

import javax.persistence.EntityManager;

import org.usac.${artifactId}.core.model.BaseEntity;

/**
 * Abstract base class for JPA Entity DAO implementations.
 * 
 * Handles direct interaction with the EntityManager.
 * 
 * @author gtassone
 * 
 * @param <T> The JPA Entity type for this DAO.
 */
public abstract class BaseDao<T extends BaseEntity> implements Dao<T> {

	private EntityManager entityManager;

	private Class<T> entityClass;

	protected BaseDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected void flushTransaction() {
		entityManager.flush();
	}

	@Override
	public T newInstance() {
		return BaseEntity.newInstance(entityClass);
	}

	@Override
	public T get(String id) {
		T entity = entityManager.find(entityClass, id);
		return entity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T update(T entity) {
		if (get(entity.getId()) == null) {
			entityManager.persist(entity);
			return entity;
		}
		return entityManager.merge(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(T entity) {
		entityManager.remove(update(entity));
		return true;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}

}
