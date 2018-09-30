package testSuite.E2E;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import easy.util.BaseUtils;
public class TestFunctionalityC extends BaseUtils {

	@Override
	@BeforeTest
	@Parameters("browser")
	public void beforeTest(String browser) {

		testSetup(browser);
	}

	@AfterTest
	public void afterTest(String browser) {

		System.out.println("quiteting the browser" + driver.toString()
				+ "for TestFunctionality C ");
	}

	@Test
	public void test7() {

		System.out.println("executing test 7 with in TestFunctionality C");
		Assert.assertTrue(false, "Supposed to be failed");
	}

	@Test
	public void test8() {

		System.out.println("executing test 8  with in TestFunctionality C");
		Assert.assertTrue(false, "Supposed to be failed");
	}

	@Test
	public void test9() {

		System.out.println("executing test 9  with in TestFunctionality C");
		Assert.assertTrue(true, "Supposed to be passed");
	}
}
