package org.usac.${artifactId}.core.service.querydsl;

import org.usac.${artifactId}.core.model.BaseEntity;
import org.usac.${artifactId}.core.model.Unique;
import org.usac.${artifactId}.core.service.base.dao.BaseCompositeDao;
import org.usac.${artifactId}.core.service.search.Search;

public class CompositeQueryDslDao<T extends BaseEntity> extends
		BaseCompositeDao<T> {

	protected CompositeQueryDslDao(Class<T> entityClass) {
		super(entityClass);
		//setSearch(new QueryDslSearch<T>(this));
	}

}
