package org.usac.${artifactId}.core.entities ;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.usac.${artifactId}.util.jpa.JpaConstants;

public class TestEntities {

	public static final String UNIT_TEST_PROPERTIES_FILE = "junit.properties";

	public static final String DBUNIT_TEST_DATA_FILE = "dbunit_test_data.xml";

	private static EntityManagerFactory emf;

	private static EntityManager em;

	private static Connection conn;

	/**
	 * Creates JDBC and JPA database connections to be used for all tests.
	 * 
	 * @throws IOException
	 * @throws SQLException
	 */
	@BeforeClass
	public static void beforeClass() throws IOException, SQLException {

		Properties props = loadProperties();

		emf = Persistence.createEntityManagerFactory("${artifactId}-entities-test",
				props);

		// these properties could be set directly in persistence.xml, 
		// but the password cannot be retrieved in plain-text from EntityManagerFactory. 
		// So we load them from a properties file instead.
		
		String jdbcDriver = props.get(JpaConstants.JDBC_DRIVER).toString();
		String jdbcURL = props.get(JpaConstants.JDBC_URL).toString();
		String jdbcUser = props.get(JpaConstants.JDBC_USER).toString();
		String jdbcPassword = props.get(JpaConstants.JDBC_PASSWORD).toString();

		try {
			conn = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

		em = emf.createEntityManager();
	}

	/**
	 * Closes connections and sets the final database state.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws MalformedURLException
	 * @throws DataSetException
	 * @throws DatabaseUnitException
	 * @throws IOException
	 */
	@AfterClass
	public static void afterClass() throws SQLException,
			ClassNotFoundException, MalformedURLException, DataSetException,
			DatabaseUnitException, IOException {
		em.close();
		emf.close();
		DatabaseOperation.CLEAN_INSERT.execute(getConnection(), getDataSet());
		conn.close();
	}

	/**
	 * Populates the database with clean test data before each test method runs.
	 * 
	 * @throws ClassNotFoundException
	 * @throws MalformedURLException
	 * @throws DataSetException
	 * @throws DatabaseUnitException
	 * @throws SQLException
	 * @throws IOException
	 */
	@Before
	public void before() throws ClassNotFoundException, MalformedURLException,
			DataSetException, DatabaseUnitException, SQLException, IOException {
		DatabaseOperation.CLEAN_INSERT.execute(getConnection(), getDataSet());
	}

	/**
	 * Clears test data set records from the database after each test method
	 * runs.
	 * 
	 * @throws ClassNotFoundException
	 * @throws MalformedURLException
	 * @throws DataSetException
	 * @throws DatabaseUnitException
	 * @throws SQLException
	 * @throws IOException
	 */
	@After
	public void after() throws ClassNotFoundException, MalformedURLException,
			DataSetException, DatabaseUnitException, SQLException, IOException {
		DatabaseOperation.DELETE_ALL.execute(getConnection(), getDataSet());
	}

	/**
	 * Loads the DBUnit data set from the provided XML data file.
	 * 
	 * @return
	 * @throws MalformedURLException
	 * @throws DataSetException
	 */
	private static IDataSet getDataSet() throws MalformedURLException,
			DataSetException {
		FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
		return builder.build(TestEntities.class.getClassLoader()
				.getResourceAsStream(DBUNIT_TEST_DATA_FILE));
	}

	/**
	 * Wraps JDBC connection as DBUnit connection.
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DatabaseUnitException
	 * @throws IOException
	 */
	private static IDatabaseConnection getConnection()
			throws ClassNotFoundException, SQLException, DatabaseUnitException,
			IOException {
		return new DatabaseConnection(conn);
	}

	private static Properties loadProperties() throws IOException {
		Properties properties = new Properties();
		properties.load(TestEntities.class.getClassLoader()
				.getResourceAsStream(UNIT_TEST_PROPERTIES_FILE));
		return properties;
	}

}
