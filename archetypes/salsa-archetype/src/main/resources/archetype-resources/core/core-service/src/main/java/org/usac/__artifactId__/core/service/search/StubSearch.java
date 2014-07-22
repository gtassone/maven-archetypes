package org.usac.${artifactId}.core.service.search;

import java.util.Collections;
import java.util.List;

public class StubSearch<T> implements Search<T> {

	@Override
	public int count(SearchCriteria<? super T> criteria) {
		return 0;
	}

	@Override
	public List<T> search(SearchCriteria<? super T> criteria) {
		return Collections.<T> emptyList();
	}

}
