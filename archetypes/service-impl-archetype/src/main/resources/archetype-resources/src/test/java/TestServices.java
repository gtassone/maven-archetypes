package ${package};

import java.util.Collection;
import java.util.List;

import mockit.Injectable;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import  mockit.Expectations.*;
import mockit.Tested;
import mockit.Verifications;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * In this class we want to test our service implementations. DAOs will be
 * mocked, and we want to verify that they are invoked properly when the service
 * methods are invoked.
 * 
 * Things to test:
 * 
 * are the right DAO methods invoked, given good data
 * 
 * (if there was security, are the right security methods invoked)
 * 
 * if bad data is provided, the right exception is thrown
 * 
 * bad data: wrong type of object.
 * 
 * bad data: nulls
 * 
 * bad data: manually constructed entity/ no id
 * 
 * 
 * 
 * 
 * @author gtassone
 * 
 */
public class TestServices {
	
	private static Logger log;
	
	@BeforeClass
	public static void beforeClass() {
		log = LoggerFactory.getLogger(TestDaos.class);
		log.info("initializing Tests...");
	}

	@AfterClass
	public static void afterClass() {

	}

	@Before
	public void before() {

	}

	@After
	public void after() {

	}
}
