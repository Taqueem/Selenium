package easy.util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class DriverFactory {

	protected static int					firefoxCntr	= 0;

	protected static int					ieCntr		= 0;

	private static ThreadLocal<WebDriver>	driver		= new ThreadLocal<>();

	static WebDriver						drv;

	public synchronized static void setDriver(String browser) {

		if (browser.equals("firefox")) {
			// if (driver != null) {
			System.out.println("Inside firefox ");
			System.setProperty("webdriver.gecko.driver",
					ConstantPath.pathGeckoDriver);
			firefoxCntr++;
			driver = ThreadLocal.withInitial(() -> new FirefoxDriver(
					OptionsManager.getFirefoxOptions()));
			drv = driver.get();
			// }
		} else if (browser.equals("chrome")) {
			if (driver != null) {
				System.out.println("Inside chrome ");
				System.setProperty("webdriver.chrome.driver",
						ConstantPath.pathChromeDriver);
				driver = ThreadLocal.withInitial(
						() -> new ChromeDriver(
								OptionsManager.getChromeOptions()));
				drv = driver.get();
			}
		} else if ((browser.equals("edge"))) {
			if (driver != null) {
				System.out.println("Inside edge ");
				System.setProperty("webdriver.edge.driver",
						ConstantPath.pathEdgeDriver);
				driver = ThreadLocal.withInitial(
						() -> new EdgeDriver(OptionsManager.getEdgeOptions()));
			}
		} else if ((browser.equals("ie"))) {
			// if (driver != null) {
			System.out.println("Inside ie");
			System.setProperty("webdriver.ie.driver",
					ConstantPath.pathIEDriver);
			ieCntr++;
			driver = ThreadLocal.withInitial(
					() -> new InternetExplorerDriver(
							OptionsManager.getIEOptions()));
			// }
		}
	}

	public synchronized static WebDriver getDriver() {

		System.out.println(driver.get());
		return driver.get();
	}
}
