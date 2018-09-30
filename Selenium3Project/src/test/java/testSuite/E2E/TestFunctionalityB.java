package testSuite.E2E;
import org.testng.Assert;
import org.testng.annotations.Test;

import easy.util.BaseUtils;
public class TestFunctionalityB extends BaseUtils {

	@Test(groups = "bugFixes", priority = 3)
	public void test4() {

		System.out.println("executing test 4 with in TestFunctionality B   "
				+ driver.toString());
		driver.get("https://www.google.com/");
		Assert.assertTrue(true, "Supposed to be passed");
	}

	@Test(groups = "bugFixes")
	public void test5() {

		System.out.println("executing test 5  with in TestFunctionality B  "
				+ driver.toString());
		driver.get("https://www.google.com/");
		Assert.assertTrue(true, "Supposed to be passed");
	}

	@Test(priority = 0)
	public void test6() {

		System.out.println("executing test 6  with in TestFunctionality B  "
				+ driver.toString());
		driver.get("https://www.google.com/");
		Assert.assertTrue(false, "Supposed to be failed");
	}
}
