package framework.driver;

import framework.config.TestConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverRunner {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private WebDriverRunner() {
    }

    public static WebDriver getWebDriver() {
        if (driver.get() == null) {
            switch (TestConfig.CONFIG.browser()){
                case "firefox": {
                         WebDriverManager.firefoxdriver().setup();
                        driver.set(new FirefoxDriver());
                        break;
                }
                case "edge": {
                        WebDriverManager.edgedriver().setup();
                        driver.set(new EdgeDriver());
                        break;
                }
                default: {
                        WebDriverManager.chromedriver().setup();
                        driver.set(new ChromeDriver());
                    }
            }
            driver.get().manage().window().maximize();
        }
        return driver.get();
    }

    public static void closeWebDriver(){
        if (driver.get() != null){
            driver.get().manage().deleteAllCookies();
            driver.get().quit();
            driver.remove();
        }
    }
}
