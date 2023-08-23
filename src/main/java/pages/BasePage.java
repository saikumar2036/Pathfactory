package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.annotations.Parameters;

public class BasePage {

	public static WebDriver driver;
	String url = "https://magento.softwaretestingboard.com/";
	public static ExtentTest logger;
	public static ExtentReports report;

	@BeforeClass(alwaysRun=true)
	@Parameters("browser")
	public void setUp(String browser,ITestContext context) {
		if ("chrome".equalsIgnoreCase(browser)) {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true"); // This suppresses the Severe Timed out receiving messages
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		} else if ("firefox".equalsIgnoreCase(browser)) {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null"); // Suppresses Firefox logging
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		} else if ("edge".equalsIgnoreCase(browser)) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		context.setAttribute("WebDriver", driver);
	}

	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
}
