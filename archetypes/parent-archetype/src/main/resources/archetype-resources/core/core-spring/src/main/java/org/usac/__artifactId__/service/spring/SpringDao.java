package org.usac.${artifactId}.service.spring;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.usac.${artifactId}.core.model.BaseEntity;
import org.usac.${artifactId}.core.service.base.dao.BaseCompositeDao;
import org.usac.${artifactId}.core.service.search.Search;
import org.usac.${artifactId}.core.service.search.SearchCriteria;

@Transactional(propagation = Propagation.MANDATORY, readOnly = false, rollbackFor = Exception.class)
public abstract class SpringDao<T extends BaseEntity> extends
		BaseCompositeDao<T> {

	protected SpringDao(Class<T> entityClass) {
		super(entityClass);
	}

	@Autowired
	public void setEntityManager(EntityManager em) {
		super.setEntityManager(em);
	}

	@Autowired
	public void setSearch(Search<T> search) {
		super.setSearch(search);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T newInstance() {
		return super.newInstance();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(propagation = Propagation.MANDATORY, readOnly = true, rollbackFor = Exception.class)
	public T get(String id) {
		return super.get(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(propagation = Propagation.MANDATORY, readOnly = false, rollbackFor = Exception.class)
	public T update(T entity) {
		return super.update(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(propagation = Propagation.MANDATORY, readOnly = false, rollbackFor = Exception.class)
	public boolean delete(T entity) {
		return super.delete(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(propagation = Propagation.MANDATORY, readOnly = true, rollbackFor = Exception.class)
	public List<T> search(SearchCriteria<? super T> criteria) {
		return super.search(criteria);
	}

}
