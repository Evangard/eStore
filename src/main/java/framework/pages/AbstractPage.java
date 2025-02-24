package framework.pages;

import com.github.javafaker.Faker;
import framework.config.TestConfig;
import framework.driver.WebDriverRunner;
import framework.helpers.JavaScriptHelper;
import framework.helpers.WebDriverWaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    protected final String BASE_PAGE = TestConfig.CONFIG.baseUrl();
    protected WebDriver driver;
    protected JavaScriptHelper javaScriptHelper;
    protected Faker faker;

    public AbstractPage() {
        driver = WebDriverRunner.getWebDriver();
        PageFactory.initElements(driver, this);
    }

    public WebDriverWaitHelper waitHelper() {
        return new WebDriverWaitHelper();
    }

    public JavaScriptHelper jsHelper() {
        return new JavaScriptHelper();
    }

    public abstract void openPage() throws Exception;

    protected abstract void waitUntilLoaded();
}
