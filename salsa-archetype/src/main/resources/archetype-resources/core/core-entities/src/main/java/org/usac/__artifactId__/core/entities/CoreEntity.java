package org.usac.${artifactId}.core.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.usac.${artifactId}.core.model.BaseEntity;

/**
 * Base class for all Core Entities.
 * 
 * This class encapsulates the ID primary key strategy for core Entities, while
 * allowing other BaseEntity subclasses to use a different strategy. It also
 * gets around an eclipse bug whereby BaseEntity JPA ID could not be resolved as
 * a MappedSuperclass since it was in a different project. (Eclipse expects one
 * persistence unit per project.)
 * 
 * @author gtassone
 * 
 */
@MappedSuperclass
public abstract class CoreEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 36)
	protected String id;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}
}
