package easy.util;
import java.net.MalformedURLException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
public class TestBase {

	protected WebDriverWait wait;

	// Do the test setup
	@BeforeTest(alwaysRun = true)
	// @BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void setupTest(@Optional("firefox") String browser)
			throws MalformedURLException, InterruptedException {

		System.out.println("Inside beforeTest");
		// Set & Get ThreadLocal Driver with Browser
		DriverFactory.setDriver(browser);
		System.out.println(DriverFactory.getDriver());
		// wait = new WebDriverWait(DriverFactory.getDriver(), 1);
		System.out.println();
	}

	// @AfterTest(alwaysRun = true)
	@AfterMethod
	public synchronized void tearDown() throws Exception {

		System.out.println("firefox counter " + DriverFactory.firefoxCntr);
		System.out.println("IE counter " + DriverFactory.ieCntr);
		System.out.println("Inside AfterTest");
		// DriverFactory.getDriver().close();
	}
}
