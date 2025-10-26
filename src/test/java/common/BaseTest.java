package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    ChromeOptions chromeOptions;
    EdgeOptions edgeOptions;

    @BeforeMethod(alwaysRun = true)
    public void globalSetup() {
        // Tự động gọi hàm getBrowserDriver với cấu hình Headless cho Jenkins/TestNG
        getBrowserDriver("HCHROME", "https://demoqa.com/");
    }
    public WebDriver getBrowserDriver(String browserName, String url) {
        String browser = browserName.toUpperCase();
        WebDriver currentDriver ;
        switch (browser) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                currentDriver = new ChromeDriver(chromeOptions);
                break;
            case "EDGE":
                WebDriverManager.edgedriver().setup();
                edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                currentDriver = new EdgeDriver(edgeOptions);
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                currentDriver = new FirefoxDriver();
                break;
            case "HCHROME":
                chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                WebDriverManager.chromedriver().setup();
                currentDriver = new ChromeDriver(chromeOptions);
                break;

            default:
                throw new RuntimeException("Please enter correct browser name");
        }
        currentDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalVariables.Long_time_out));
        currentDriver.manage().window().maximize();
        currentDriver.get(url);

        driver.set(currentDriver);
        return currentDriver;
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriver currentDriver = driver.get();
        if (currentDriver != null) {
            currentDriver.quit();
            driver.remove();
        }
    }
}
