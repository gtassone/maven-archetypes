package org.usac.${artifactId}.tools.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import joptsimple.OptionParser;
import joptsimple.OptionSet;

/**
 * Java application that invokes JPA schema generation. This tool can be used
 * manually or as part of the build process. For the build process it is invoked
 * to generate temporary in-memory databases during the unit test phase of JPA
 * artifact builds. The build should also include a build profile to regenerate
 * the dev environment database schema or DDL script.
 * 
 * During unit testing, the persistence.xml located in the test resources
 * directory will be used to configure JPA.
 * 
 * When explicitly rebuilding the database schema, <how to set up the
 * configuration>.
 * 
 * When using Spring, <how to set up the configuration>.
 * 
 * @author gtassone
 * 
 */
public class SchemaGenerator {

	public static void main(String[] args) {

		OptionParser parser = new OptionParser();
		parser.accepts("persistence-unit").withRequiredArg();

		OptionSet options = parser.parse(args);

		assert (options.has("persistence-unit"));

		System.out.println("\n\nPersistence Unit: "
				+ options.valueOf("persistence-unit"));

		String persistenceUnit = options.valueOf("persistence-unit").toString();

		Map<String, Object> properties = new HashMap<String, Object>();
		//
		// properties.put("javax.persistence.database-product-name", "Oracle");
		// properties.put("javax.persistence.database-major-version", 12);
		// properties.put("javax.persistence.database-minor-version", 1);
		// properties.put("javax.persistence.schema-generation.scripts.action",
		// "drop-and-create");
		// properties.put("javax.persistence.schema-generation.scripts.drop-target",
		// "jpa21-generate-schema-no-connection-drop.jdbc");
		// properties.put("javax.persistence.schema-generation.scripts.create-target",
		// "jpa21-generate-schema-no-connection-create.jdbc");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(
				persistenceUnit, properties);
		emf.close();

		// Persistence.generateSchema(persistenceUnit, properties);

		System.out.println("\n\nFinished generating schema...\n\n");
	}
}
