package ${topPackage}.${subPackage}.${artifactId}.core.service.base;

import java.util.List;

import ${topPackage}.${subPackage}.${artifactId}.core.model.BaseEntity;
import ${topPackage}.${subPackage}.${artifactId}.core.service.DataService;
import ${topPackage}.${subPackage}.${artifactId}.core.service.base.dao.Dao;
import ${topPackage}.${subPackage}.${artifactId}.core.service.search.SearchCriteria;
import ${topPackage}.${subPackage}.${artifactId}.core.service.DataService;
import ${topPackage}.${subPackage}.${artifactId}.core.service.base.dao.Dao;
import ${topPackage}.${subPackage}.${artifactId}.core.service.search.SearchCriteria;

/**
 * Base implementation for DataServices.
 * 
 * This implementation assumes that for a given DataService interface and data
 * type (I), a corresponding implementation data type (E, typically a JPA
 * Entity) is used by a DAO.
 * 
 * @author gtassone
 * 
 * @param <I>
 * @param <E>
 */
public abstract class BaseDataService<I, E extends I> implements DataService<I> {

	private Dao<E> dao;

	private Class<E> clazz;
	
	protected BaseDataService(Class<E> clazz) {
		this.clazz = clazz;
	}

	/**
	 * Setter and injection point for DAO.
	 * @param dao
	 */
	protected void setDao(Dao<E> dao) {
		this.dao = dao;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public I newInstance() {
		return dao.newInstance();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public I get(String id) {
		return dao.get(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<? extends I> search(SearchCriteria<I> criteria) {
		return dao.search(criteria);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public I update(I data) {
		if (!(clazz.isInstance(data))) {
			throw new IllegalArgumentException();
		}
		return dao.update((E) data);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(I data) {
		if (!(clazz.isInstance(data))) {
			throw new IllegalArgumentException();
		}
		return dao.delete((E) data);
	}
}
