package Tests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import easy.util.BaseUtils;
public class SampleTest extends BaseUtils {

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
