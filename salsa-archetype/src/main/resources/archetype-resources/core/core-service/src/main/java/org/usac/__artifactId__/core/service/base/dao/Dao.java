package org.usac.${artifactId}.core.service.base.dao;

import java.util.List;

import org.usac.${artifactId}.core.service.search.SearchCriteria;

/**
 * Interface for DAO objects which can be used to perform CRUD operations for a
 * particular data type.
 * 
 * @author gtassone
 * 
 * @param <T>
 *            The data type accessed by the DAO.
 */
public interface Dao<T> {

	// create
	T newInstance();

	// read
	T get(String id);

	// search
	List<T> search(SearchCriteria<? super T> criteria);

	// update instead of modify, because a newInstance isn't saved until its
	// saved
	T update(T data);

	// delete
	boolean delete(T data);

}
