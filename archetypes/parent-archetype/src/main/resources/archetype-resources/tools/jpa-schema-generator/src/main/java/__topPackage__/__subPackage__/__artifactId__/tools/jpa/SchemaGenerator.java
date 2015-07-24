package ${topPackage}.${subPackage}.${artifactId}.tools.jpa;

import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import joptsimple.OptionParser;
import joptsimple.OptionSet;

import ${topPackage}.${subPackage}.${artifactId}.util.jpa.JpaConstants;

/**
 * Java application that invokes JPA schema generation.
 * 
 * This tool accepts the following arguments:
 * 
 * --persistence-unit="{name-of-persistence-unit}"
 * 
 * --jpa-properties-file="{properties-file-resource-name}"
 * 
 * The persistence-unit should match the persistence.xml on the classpath. The
 * JPA properties file should be specified as a resource on the classpath,
 * rather than a filepath. For instance, a properties file in src/test/resources
 * of the invoking project can be specified just by the filename.
 * 
 * This tool can be used manually or as part of the build process. The build
 * should include a build profile to regenerate the dev environment database
 * schema or DDL script.
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

	private static final String DEFAULT_PROPERTIES = "schemagen.properties";

	public static void main(String[] args) {

		OptionParser parser = new OptionParser();
		parser.accepts("persistence-unit").withRequiredArg();
		parser.accepts("jpa-properties-file").withRequiredArg();

		OptionSet options = parser.parse(args);

		assert (options.has("persistence-unit"));

		System.out.println("\n\nPersistence Unit: "
				+ options.valueOf("persistence-unit"));

		String persistenceUnit = options.valueOf("persistence-unit").toString();

		String propertiesResourcePath = DEFAULT_PROPERTIES;
		if (options.has("jpa-properties-file")) {
			propertiesResourcePath = options.valueOf("jpa-properties-file")
					.toString();
		}

		Properties props;
		try {
			props = loadProperties(DEFAULT_PROPERTIES);

			String jdbcDriver = props.get(JpaConstants.JDBC_DRIVER).toString();
			String jdbcURL = props.get(JpaConstants.JDBC_URL).toString();
			String jdbcUser = props.get(JpaConstants.JDBC_USER).toString();
			String jdbcPassword = props.get(JpaConstants.JDBC_PASSWORD)
					.toString();

			System.err.println("\n\n\nproperties: \n" + jdbcDriver + "\n"
					+ jdbcURL + "\n" + jdbcUser + "\n" + jdbcPassword + "\n");

			//
			// properties.put("javax.persistence.database-product-name",
			// "Oracle");
			// properties.put("javax.persistence.database-major-version", 12);
			// properties.put("javax.persistence.database-minor-version", 1);
			// properties.put("javax.persistence.schema-generation.scripts.action",
			// "drop-and-create");
			// properties.put("javax.persistence.schema-generation.scripts.drop-target",
			// "jpa21-generate-schema-no-connection-drop.jdbc");
			// properties.put("javax.persistence.schema-generation.scripts.create-target",
			// "jpa21-generate-schema-no-connection-create.jdbc");

			EntityManagerFactory emf = Persistence.createEntityManagerFactory(
					persistenceUnit, props);
			emf.close();

			// this should work but is currently broken in hibernate (doesn't terminate)
			// Persistence.generateSchema(persistenceUnit, properties);

			System.out.println("\n\nFinished generating schema...\n\n");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static Properties loadProperties(String propertiesResource)
			throws IOException {
		Properties properties = new Properties();
		properties.load(SchemaGenerator.class.getClassLoader()
				.getResourceAsStream(propertiesResource));
		return properties;
	}
}
