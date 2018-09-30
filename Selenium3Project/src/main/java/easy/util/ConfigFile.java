package easy.util;
import easy.util.Enums.TestGroups;
public class ConfigFile {

	public static String		browser			= Enums.Browser.ALL
			.getBrowser();

	public static final String	defaultBrowser	= "firefox";

	public static String		testGroup		= TestGroups.BUGFIXES
			.toString();

	public static int			maxRetryCount	= 0;

	public static final String	googleURL		= "Http://google.com";

	public static final String	yahooUrl		= "Http://yahoo.in";
}
