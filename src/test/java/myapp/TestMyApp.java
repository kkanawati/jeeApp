package myapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * Test Spring services
 */
@SpringBootTest
public class TestMyApp {

	@Autowired
	ApplicationContext context;

	@Qualifier("hello")
	@Autowired
	IHello helloByService;

	@Qualifier("hi")
	@Autowired
	IHello hello2byService;

	@Resource(name = "helloService")
	IHello helloByName;

	@Resource(name = "hello2Service")
	IHello hi;

	@Autowired
	String bye;

	@Autowired
	ILogger ilogger;

	@Autowired
	StderrLogger stderrLogger;

	@Test
	public void testHelloService() {
		assertTrue(helloByService instanceof HelloService);
		helloByService.hello();
	}

	@Test
	public void testHi() {
		assertTrue(hi instanceof Hello2service);
		hello2byService.hello();
	}

	@Test
	public void testLoggerInstanceof(){
		assertTrue(ilogger instanceof ILogger);
		ilogger.log("no errors");
	}

	@Test
	public void teststderlog(){
		assertTrue(stderrLogger instanceof StderrLogger);
		stderrLogger.log("no Err");
	}

	
	@Test
	public void testHelloByName() {
		assertEquals(helloByService, helloByName);
	}

	@Test
	public void testHiByName() {
		assertEquals(hello2byService, hi);
	}
	@Test
	public void testHelloByContext() {
		assertEquals(helloByName, context.getBean(IHello.class));
		assertEquals(helloByName, context.getBean("helloService"));
	}

	@Test
	public void testBye() {
		assertEquals(bye, "Bye.");
	}

}
