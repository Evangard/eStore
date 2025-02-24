package framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BasePage extends AbstractPage {
    @FindBy(xpath = "//a[@class='ico-login']")
    protected WebElement loginIcon;

    @FindBy(xpath = "//a[@class='ico-account']")
    protected WebElement accountIcon;

    @FindBy(xpath = "//h1")
    protected WebElement caption;

    @Step("Verify that user is logged in")
    public boolean isUserLoggedIn() {
        try {
            return accountIcon.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Navigate to Customer Info page via account icon in header")
    public void clickOnAccountButton() {
        if (isUserLoggedIn()) {
            accountIcon.click();
        }
    }

    @Step("Get page title")
    public String getCaption() {
        return caption.getText();
    }

    public WebElement findElementByXpath(String text) {
        return driver.findElement(By.xpath(text));
    }

    @Override
    public void openPage() throws Exception {
        throw new Exception("Method openPage() isn't implemented.");
    }

    @Override
    protected void waitUntilLoaded() {
        waitHelper().waitElementUntilVisible(caption);
    }
}
