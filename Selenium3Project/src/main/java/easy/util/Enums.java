package easy.util;
public class Enums {

	public enum Browser {
							FIREFOX("firefox"),
							CHROME("chrome"),
							IE("ie"),
							EDGE("edge"),
							ALL("firefox,chrome,ie");

		private String browserName;

		Browser(String browser) {

			this.browserName = browser;
		}

		public String getBrowser() {

			return browserName;
		}
	};

	public enum TestGroups {
							SMOKE,
							SANITY,
							BUGFIXES;
	};
}
