package org.usac.${artifactId}.core.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.usac.${artifactId}.core.model.Unique;

/**
 * Abstract base class for all JPA Entities.
 * 
 * This class provides the JPA version and id properties.
 * 
 * FIXME consider moving all the id and initEntity logic into CoreEntity, which
 * would let this class better accomodate other subclassed Entities which use
 * different id strategies.
 * 
 * @author gtassone
 * 
 */
public abstract class BaseEntity implements Unique, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Long CURRENT_VERSION = 1l;

	@Version
	@Column(name = "VERSION", nullable = false)
	protected Long version = CURRENT_VERSION;

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	/**
	 * Create a new instance of an entity.
	 * 
	 * @return new instance of the entity
	 */
	public static <T extends BaseEntity> T newInstance(Class<T> clazz) {

		T newInstance;

		try {

			newInstance = clazz.newInstance();
			newInstance.initEntity();
			return newInstance;

		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}

		return null;
	}

	/**
	 * Called via BaseEntity.newInstance() to initialize the Entity with any
	 * custom setup - id generation, contained Entity instantiation and wiring,
	 * etc.
	 */
	protected abstract void initEntity();

	public String toString() {
		return "id='" + getId() + '\'' + ", version='" + version + '\'';
	}

}
