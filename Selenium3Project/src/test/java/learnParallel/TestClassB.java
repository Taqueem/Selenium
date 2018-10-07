package learnParallel;
import org.testng.annotations.Test;

import easy.util.ConfigFile;
import easy.util.DriverFactory;
import easy.util.TestBase;
public class TestClassB extends TestBase {

	@Test
	public void testMethod3() {

		System.out.println(
				"testMethod3 Test Started! " + Thread.currentThread().getId());
		// System.out.println(DriverFactory.getDriver());
		System.out.println("insside test method 3 of test class B");
		DriverFactory.getDriver().get(ConfigFile.yahooUrl);
		System.out.println(
				"testMethod3 Test ended! " + Thread.currentThread().getId());
	}
	// @Test
	// public void testMethod4() {
	//
	// System.out.println(
	// "testMethod4 Test Started! " + Thread.currentThread().getId());
	// System.out.println(DriverFactory.getDriver());
	// System.out.println("insside test method 4 of test class B");
	// DriverFactory.getDriver().get(ConfigFile.googleURL);
	// System.out.println(
	// "testMethod4 test ended! " + Thread.currentThread().getId());
	// }
}
