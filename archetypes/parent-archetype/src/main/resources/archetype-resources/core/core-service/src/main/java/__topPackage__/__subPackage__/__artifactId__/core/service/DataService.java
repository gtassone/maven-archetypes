package ${topPackage}.${subPackage}.${artifactId}.core.service;

import java.util.List;

import ${topPackage}.${subPackage}.${artifactId}.core.service.search.SearchCriteria;
import ${topPackage}.${subPackage}.${artifactId}.core.service.DataService;
import ${topPackage}.${subPackage}.${artifactId}.core.service.search.SearchCriteria;

/**
 * The generic data service interface. 
 * 
 * This interface provides CRUD operations for a given Data type at the service layer. 
 * 
 * @author gtassone
 *
 * @param <I> The data type supported by the service.
 */
public interface DataService<I> {

	/**
	 * Factory method to create a new instance of the data type.
	 * 
	 * The instance is not persisted until {@link DataService#update()} is
	 * called.
	 * 
	 * @return a new instance.
	 */
	I newInstance();

	/**
	 * Retrieves the data item by ID.
	 * 
	 * @param id
	 *            the id of the data item to retrieve.
	 * @return the up-to-date data item with matching id, or null if no matching
	 *         data item is found.
	 */
	I get(String id);

	/**
	 * Searches for data items by applying the search criteria.
	 * 
	 * @param criteria
	 *            matching criteria for the search.
	 * @return list of data items satisfying the search criteria.
	 */
	List<? extends I> search(SearchCriteria<I> criteria);

	/**
	 * Persists the data item, updating the existing record as necessary.
	 * 
	 * @param data
	 *            the updated data item.
	 * @return the updated data item, once it has been persisted.
	 */
	I update(I data);

	/**
	 * Removes the persistent record for the given data item.
	 * 
	 * @param data
	 *            the data item to remove.
	 * @return true if successful, false otherwise.
	 */
	boolean delete(I data);
}
