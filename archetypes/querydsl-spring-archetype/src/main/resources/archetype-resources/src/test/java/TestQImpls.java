package ${package};

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import mockit.Mocked;
import mockit.Verifications;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/test_spring_context.xml" })
public class TestQImpls {

	private static Logger log;

	@Autowired
	private ApplicationContext applicationContext;


	@BeforeClass
	public static void beforeClass() {
		log = LoggerFactory.getLogger(TestQImpls.class);
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
