package tests;

import framework.driver.WebDriverRunner;
import framework.helpers.JavaScriptHelper;
import framework.helpers.WebDriverWaitHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;


public class BaseTest {

    protected WebDriver driver;
    protected JavaScriptHelper javaScriptHelper;
    protected WebDriverWaitHelper webDriverWaitHelper;
    protected SoftAssert softAssert;

    @BeforeClass
    public void setupDriver() {
        driver = WebDriverRunner.getWebDriver();
        webDriverWaitHelper = new WebDriverWaitHelper();
        javaScriptHelper = new JavaScriptHelper();
        softAssert = new SoftAssert();
    }

    @AfterClass(alwaysRun=true)
    public void closeSite() {
        javaScriptHelper.clearLocalStorageJS();
        WebDriverRunner.closeWebDriver();
    }
}
