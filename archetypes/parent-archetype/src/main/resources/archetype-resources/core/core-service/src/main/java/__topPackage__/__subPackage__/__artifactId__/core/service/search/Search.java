package ${topPackage}.${subPackage}.${artifactId}.core.service.search;

import java.util.List;

/**
 * Interface for a search delegate object.
 * 
 * The separate Search interface allows different query implementations to be
 * used and injected into Composite DAOs.
 * 
 * @author gtassone
 * 
 * @param <T>
 */
public interface Search<T> {

	public int count(SearchCriteria<? super T> criteria);

	public List<T> search(SearchCriteria<? super T> criteria);

}
