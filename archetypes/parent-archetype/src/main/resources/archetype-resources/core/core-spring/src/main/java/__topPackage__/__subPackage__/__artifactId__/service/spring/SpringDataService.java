package ${topPackage}.${subPackage}.${artifactId}.service.spring;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import ${topPackage}.${subPackage}.${artifactId}.core.service.base.BaseDataService;
import ${topPackage}.${subPackage}.${artifactId}.core.service.search.SearchCriteria;

/**
 * Base class for Spring-annotated services.
 * 
 * @author gtassone
 *
 * @param <I>
 * @param <E>
 */
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public abstract class SpringDataService<I, E extends I> extends BaseDataService<I, E> {

	protected SpringDataService(Class<E> clazz) {
		super(clazz);
	}

	public I newInstance() {
		return super.newInstance();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
	public I get(String id) {
		return super.get(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
	public List<? extends I> search(SearchCriteria<I> criteria) {
		return super.search(criteria);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public I update(I data) {
		return super.update(data);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public boolean delete(I data) {
		return super.delete(data);
	}
}
