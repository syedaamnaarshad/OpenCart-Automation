package org.store.base;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
public class BaseClass {

    @Getter
    public static WebDriver driver;

    //set up the driver
    public static void setup(String browser) {
        if (driver == null) {
            // Choose browser based on input
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Browser not supported");
            }

            // Configure browser settings
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
    }

    //quit the driver
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    // Other reusable methods, e.g., navigation helpers
    public void navigateTo(String url) {
        //myProp= ConfigUtility.getConfig("config");
        driver.get(url);
    }

}
