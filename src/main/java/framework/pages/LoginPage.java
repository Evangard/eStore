package framework.pages;

import framework.models.Customer;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div/input[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//h1")
    private WebElement caption;

    @Step("Enter Email")
    private void setEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    @Step("Enter Password")
    private void setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @Step("Click On Login Button")
    public void clickOnLoginButton() {
        loginButton.click();
    }

    @Step("Login as customer")
    public void loginAs(Customer customer){
        setEmail(customer.getEmail());
        setPassword(customer.getPassword());
        clickOnLoginButton();
    }

    @Override
    public void openPage() {
        driver.get(BASE_PAGE + "/login");
        waitUntilLoaded();
    }
}
