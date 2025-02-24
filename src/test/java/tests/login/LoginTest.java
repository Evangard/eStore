package tests.login;

import com.github.javafaker.Faker;
import framework.enums.Customers;
import framework.models.Customer;
import framework.pages.CustomerInfoPage;
import framework.pages.HomePage;
import framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.Locale;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;
    private CustomerInfoPage customerInfoPage;
    private Customer customer;
    private Faker faker;
    private Locale locale = new Locale("uk_UA");

    private String expectedLastName = "";
    private String message = "Actual page caption is: %s";

    @BeforeMethod
    void setup() {
        customer = Customers.TEST_USER.getCustomer();
        loginPage = new LoginPage();
        loginPage.openPage();
        homePage = new HomePage();
        customerInfoPage = new CustomerInfoPage();
        faker = new Faker(locale);
        expectedLastName = faker.name().lastName();
    }

    @Test(description = "After login user returns to the Home Page", priority = 1)
    private void userCanLoginTest() {
        loginPage.loginAs(customer);
        softAssert.assertEquals(homePage.getCaption(), "Вітаємо в BUTLERS!", String.format(message, homePage.getCaption()));
        softAssert.assertTrue(homePage.isUserLoggedIn(), "User is NOT logged in");
        softAssert.assertAll();
    }

    @Test(description = "Verify that user can navigate to personal cabinet after login", priority = 2)
    private void userCanNavigateToCustomerInfoPageTest() {
        loginPage.clickOnAccountButton();
        Assert.assertEquals(customerInfoPage.getCaption(), "Персональний кабінет - Інформація про клієнта", String.format(message, customerInfoPage.getCaption()));
    }

    @Test(description = "Verify that user can update last name", priority = 2)
    private void userCanUpdateLastNameTest() {
        customerInfoPage.openPage();
        customerInfoPage.updateLastName(expectedLastName);
        customerInfoPage.saveInfo();

        Assert.assertEquals(customerInfoPage.getLastName(), expectedLastName, String.format("Actual surname is: ", customerInfoPage.getLastName()));
    }
}
