package ${topPackage}.${subPackage}.${artifactId}.core.service.base.dao;

import javax.persistence.EntityManager;

import ${topPackage}.${subPackage}.${artifactId}.core.model.BaseEntity;

/**
 * Abstract base class for JPA Entity DAO implementations.
 * 
 * Handles direct interaction with the EntityManager.
 * 
 * @author gtassone
 * 
 * @param <T>
 *            The JPA Entity type for this DAO.
 */
public abstract class BaseDao<T extends BaseEntity> implements Dao<T> {

	private EntityManager entityManager;

	private Class<T> entityClass;

	protected BaseDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	/**
	 * Setter and injection point for EntityManager.
	 * 
	 * @param em
	 *            the EntityManager.
	 */
	protected void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}

	/**
	 * 
	 */
	protected void flushTransaction() {
		entityManager.flush();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T newInstance() {
		return BaseEntity.newInstance(entityClass);
	}

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * provides access to the EntityManager for this DAO.
	 * 
	 * This allows search implementations to access the EntityManager directly.
	 * 
	 * @return the EntityManager used by this DAO.
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
