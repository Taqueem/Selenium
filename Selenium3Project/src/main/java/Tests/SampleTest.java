package Tests;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import easy.util.BaseUtils;
public class SampleTest extends BaseUtils {

	@BeforeMethod
	@BeforeTest public void setUp() {

		setFirefoxBrowser();
		setChromeBrowser();
		// setIEBrowser();
		setEdgeBrowser();
	}

	@Test public void test() {

		System.out.println(
				"Executing the test for the browser: " + driver.toString());
		driver.get("http://google.com");
	}
}
