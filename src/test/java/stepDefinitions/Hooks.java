package stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.store.base.BaseClass;
import org.store.pageObject.HomePage;
import org.store.pageObject.LoginPage;
import org.store.pageObject.MyAccountPage;
import org.store.utility.ConfigUtility;
import java.io.IOException;
import java.util.Properties;

public class Hooks extends BaseClass {
    public static Properties myProp = ConfigUtility.getConfig("config");


    @Before
    public void setUp() throws IOException {
        BaseClass.setup(myProp.getProperty("browser"));// Initialize WebDriver before each scenario
        driver.get(myProp.getProperty("url"));

    }

    @After
    public void tearDown(Scenario scenario) {
        BaseClass.tearDown(); // Quit WebDriver after each scenario
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {

        // this is for cucumber junit report
        if (scenario.isFailed()) {

            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }
    }

}
