package testSuite.Module1;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TestFunctionalityA {

	@Test
	public void test1() {

		System.out.println("executing test 1 with in TestFunctionalityA");
		Assert.assertTrue(true, "Supposed to be passed");
	}

	@Test
	public void test2() {

		System.out.println("executing test 2  with in TestFunctionalityA");
		Assert.assertTrue(false, "Supposed to be failed");
	}

	@Test
	public void test3() {

		System.out.println("executing test 3  with in TestFunctionalityA");
		Assert.assertTrue(true, "Supposed to be passed");
	}
}
