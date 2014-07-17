package org.usac.${artifactId}.core.service.base;

import java.util.List;

import org.usac.${artifactId}.core.model.BaseEntity;
import org.usac.${artifactId}.core.service.DataService;
import org.usac.${artifactId}.core.service.base.dao.Dao;
import org.usac.${artifactId}.core.service.search.SearchCriteria;

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

	/**
	 * Provides the class of the implementation type parameter.
	 * 
	 * @param clazz
	 */
	protected void setClass(Class<E> clazz) {
		this.clazz = clazz;
	}

	public void setDao(Dao<E> dao) {
		this.dao = dao;
	}

	// create
	public I newInstance() {
		return dao.newInstance();
	}

	// read
	public I get(String id) {
		return dao.get(id);
	}

	// search
	public List<? extends I> search(SearchCriteria<I> criteria) {
		return dao.search(criteria);
	}

	// update instead of modify, because a newInstance isn't saved until its
	// saved
	public I update(I data) {
		if (!(clazz.isInstance(data))) {
			throw new IllegalArgumentException();
		}
		return dao.update((E) data);
	}

	// delete
	public boolean delete(I data) {
		if (!(clazz.isInstance(data))) {
			throw new IllegalArgumentException();
		}
		return dao.delete((E) data);
	}
}
