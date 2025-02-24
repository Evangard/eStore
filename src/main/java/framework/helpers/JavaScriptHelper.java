package framework.helpers;

import framework.driver.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper {

    public void clickJS(WebElement element) {
        ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("arguments[0].click();",
                element);
    }

    public void allElementsLoaded() {
        ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("return document.readyState").equals("complete");
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("arguments[0].scrollIntoView(true)",
                element);
    }

    public void clearLocalStorageJS() {
        ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("window.localStorage.clear()");
    }
}
