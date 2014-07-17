package org.usac.${artifactId}.core.model;

import java.io.Serializable;

/**
 * Interface that all model objects should implement.
 * 
 * Provides for a common base and enforces uniquely identifiable objects.
 * 
 * @author gtassone
 * 
 */
public interface Unique extends Serializable {

	public String getId();

}
