package easy.util;
import java.net.MalformedURLException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
public class TestBase {

	protected WebDriverWait wait;

	// Do the test setup
	@BeforeTest(alwaysRun = true)
	// @BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void setupTest(String browser)
			throws MalformedURLException {

		System.out.println("Inside beforeTest");
		// Set & Get ThreadLocal Driver with Browser
		DriverFactory.setDriver(browser);
		wait = new WebDriverWait(DriverFactory.getDriver(), 15);
	}

	// @AfterTest(alwaysRun = true)
	public synchronized void tearDown() throws Exception {

		System.out.println("Inside AfterTest");
		DriverFactory.getDriver().close();
	}
}
