package lifetek.vn.common;

import lifetek.vn.helpers.PropertiesHelpers;
import lifetek.vn.listeners.TestListener;
import lifetek.vn.driver.DriverManager;
import lifetek.vn.driver.TargetFactory;
import lifetek.vn.report.AllureManager;
import lifetek.vn.utils.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class BaseTest {

    @BeforeSuite
    public void beforeSuite() {
        AllureManager.setAllureEnvironmentInformation();
        PropertiesHelpers.loadAllFiles(); //Config and Locators
    }

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void createDriver(@Optional("chrome") String browser) {
        WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance(browser));
        DriverManager.setDriver(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        DriverManager.quit();
        WebUI.stopSoftAssertAll();
    }


    public WebDriver createBrowser(@Optional("chrome") String browser) {
        PropertiesHelpers.loadAllFiles();
        WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance(browser));
        DriverManager.setDriver(driver);
        return DriverManager.getDriver();

    }

}
