package testSuite.Module1;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TestFunctionalityC {

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
