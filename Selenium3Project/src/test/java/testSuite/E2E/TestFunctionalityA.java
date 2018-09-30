package testSuite.E2E;
import org.testng.Assert;
import org.testng.annotations.Test;

import easy.util.BaseUtils;
//@Listeners(listeners.TestListener.class)
public class TestFunctionalityA extends BaseUtils {

	@Test(groups = {"smoke", "sanity", "bugFixes"}, priority = 3)
	public void test1() {

		System.out.println(
				"executing test 1 with in TestFunctionality A  "
						+ driver.toString());
		driver.get("https://cacert.org/");
		Assert.assertTrue(false, "Supposed to be failed");
		System.out.println("After Assertion 1");
		// test.fail(" failed");
	}

	@Test(groups = {"smoke"}, priority = 2)
	public void test2() {

		System.out.println("executing test 2  with in TestFunctionality A  "
				+ driver.toString());
		driver.get("https://www.google.com/");
		Assert.assertTrue(true, "Supposed to be passed");
		// test.pass(" passed");
		System.out.println("After Assertion 2");
	}

	@Test(groups = {"sanity"}, priority = 0)
	public void test3() {

		System.out.println("executing test 3  with in TestFunctionality A  "
				+ driver.toString());
		driver.get("https://www.google.com/");
		Assert.assertTrue(false, "Supposed to be passed");
		// test.pass(" passed");
		System.out.println("After Assertion 3");
	}
}
