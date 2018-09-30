package learnParallel;
import org.testng.annotations.Test;

import easy.util.TestBase;
public class TestClassA extends TestBase {

	@Test
	public void testMethod1() {

		System.out.println(
				"testMethod1 Test Started! " + Thread.currentThread().getId());
		System.out.println("inside test method 1 of test class A");
		System.out.println(
				"testMethod1 Test Ended! " + Thread.currentThread().getId());
		// DriverFactory.getDriver().get(ConfigFile.googleURL);
	}

	@Test
	public void testMethod2() {

		System.out.println(
				"testMethod2 Test Started! " + Thread.currentThread().getId());
		System.out.println("insside test method 2 of test class A");
		System.out.println(
				"testMethod2 Test Ended! " + Thread.currentThread().getId());
		// DriverFactory.getDriver().get(ConfigFile.yahooUrl);
	}
}
