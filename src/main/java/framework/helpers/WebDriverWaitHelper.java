package framework.helpers;

import framework.driver.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverWaitHelper {
    protected final int TIME_OUT = 10;

    public void waitElementUntilVisible(WebElement element) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilTextToBePresent(WebElement element, String text) {
        getWebDriverWait().until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitLocatorUntilVisible(String locator) {
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitLocatorUntilInvisible(String locator) {
        getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitElementUntilInvisible(WebElement element) {
        getWebDriverWait().until(ExpectedConditions.invisibilityOf(element));
    }

    protected WebDriverWait getWebDriverWait() {
        return getWebDriverWait(TIME_OUT);
    }

    protected WebDriverWait getWebDriverWait(long timeoutInSeconds) {
        return (WebDriverWait) new WebDriverWait(WebDriverRunner.getWebDriver(), TIME_OUT)
                .pollingEvery(Duration.ofMillis(500))
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }
}
