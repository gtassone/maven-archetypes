package org.usac.${artifactId}.core.service;

import java.util.List;

import org.usac.${artifactId}.core.service.search.SearchCriteria;

public interface DataService<I> {

	// create
	I newInstance();
	
	// read
	I get(String id);
	
	// search
	List<? extends I> search(SearchCriteria<I> criteria);
	
	// update instead of modify, because a newInstance isn't saved until its saved
	I update(I data);
	
	// delete
	boolean delete(I data);

}
