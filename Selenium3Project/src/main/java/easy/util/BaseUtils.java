package easy.util;
import java.lang.reflect.Method;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
public class BaseUtils {

	protected static WebDriver		driver;

	protected static Capabilities	capability;

	public static ExtentTest		test;

	protected WebDriver setFirefoxBrowser() {

		System.setProperty("webdriver.gecko.driver",
				ConstantPath.pathGeckoDriver);
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary(
				"C:\\Program Files\\Mozilla Version\\55.0\\firefox.exe");
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setAcceptInsecureCerts(true);
		driver = new FirefoxDriver(options);
		return driver;
	}

	protected WebDriver setChromeBrowser() {

		System.setProperty("webdriver.chrome.driver",
				ConstantPath.pathChromeDriver);
		ChromeOptions options = new ChromeOptions();
		options.setBinary(
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		driver = new ChromeDriver(options);
		return driver;
	}

	protected WebDriver setEdgeBrowser() {

		System.setProperty("webdriver.edge.driver",
				ConstantPath.pathEdgeDriver);
		EdgeOptions options = new EdgeOptions();
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		driver = new EdgeDriver(options);
		return driver;
	}

	protected WebDriver setIEBrowser() {

		System.setProperty("webdriver.ie.driver",
				ConstantPath.pathIEDriver);
		InternetExplorerOptions options = new InternetExplorerOptions();
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.introduceFlakinessByIgnoringSecurityDomains();
		options.elementScrollTo(ElementScrollBehavior.BOTTOM);
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		driver = new InternetExplorerDriver(options);
		return driver;
	}

	@DataProvider(name = "browserTypes")
	protected static Object[][] getBrowsers() {

		String[] browsers = ConfigFile.browser.split(",");
		int timesOfRepeat = browsers.length;
		int numOfParameter = 1;
		Object[][] data = new Object[timesOfRepeat][numOfParameter];
		for (int i = 0; i < timesOfRepeat; i++) {
			data[i][1] = browsers[i];
		}
		return data;
	}

	@Test
	protected void testSetup(String browser) {

		if (driver == null)
			driver = driverSetUp(browser);
		else if (!getBrowserName().equalsIgnoreCase(browser))
			driver = driverSetUp(browser);
	}

	private String getBrowserName() {

		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		return browserName;
	}

	protected WebDriver driverSetUp(String browser) {

		if (browser.equalsIgnoreCase(Enums.Browser.FIREFOX.getBrowser()))
			return setFirefoxBrowser();
		else if (browser.equalsIgnoreCase(Enums.Browser.CHROME.getBrowser()))
			return setChromeBrowser();
		else if (browser.equalsIgnoreCase(Enums.Browser.EDGE.getBrowser()))
			return setEdgeBrowser();
		else if (browser.equalsIgnoreCase(Enums.Browser.IE.getBrowser()))
			return setIEBrowser();
		else {
			Assert.assertTrue(false, "Please pass a browser Name");
			return null;
		}
	}

	@BeforeTest(alwaysRun = true)
	@Parameters("browser")
	public void beforeTest(
			@Optional(ConfigFile.defaultBrowser) String browser) {

		System.out.println("inside Before Test");
		testSetup(browser);
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {

		/*	System.out.println(
					"with in afterTest closing the browser" + driver.toString()
							+ "for TestFunctionality B ");*/
		System.out.println("Inside After Test");
		driver.close();
	}

	Method method;

	/*@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
	
		method = this.getClass().getEnclosingMethod();
		System.out.println("method name = " + method.getName());
		// extentReporter.startReporting(this.getClass().getEnclosingMethod());
		extentReporter.startReporting(method);
	}*/
	@AfterMethod(alwaysRun = true)
	public void afterMethod() {

		extentReporter.endReporting();
	}

	public static ExtentReporter extentReporter = new ExtentReporter();;

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {

		// extentReporter = new ExtentReporter();
		extentReporter.initializeExtentReport();
	}

	@BeforeClass
	public void beforeClass() {

		System.out.println("Inside Before class");
	}
}
