package com.nopcommerce.demo.feature.login;

import com.nopcommerce.demo.core.BaseTest;
import com.nopcommerce.demo.pageobject.HomePageObject;
import com.nopcommerce.demo.pageobject.LoginPageObject;
import com.nopcommerce.demo.pageobject.PageGeneratorManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


@Epic("NopCommerce")
@Feature("Login")
@Story("Login Unuccessful")
public class LoginUnsuccessful extends BaseTest {
    WebDriver driver;
    LoginPageObject loginPage;
    HomePageObject homePage;
    String email, password;

    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("chrome") String browser) {
        driver = getBrowserDriver(browser, "https://demo.nopcommerce.com/login");
        loginPage = PageGeneratorManager.getLoginPage(driver);
    }

    @Test
    public void TC01_Login_Empty_Data() {
        loginPage.inputToEmailTextbox("");
        loginPage.inputToPasswordTextbox("");
        loginPage.clickToLoginButton();
        loginPage.checkMsgEmailError("Please enter your email");
    }

    @Test
    public void TC02_Login_Invalid_Email() {
        loginPage.inputToEmailTextbox("1");
        loginPage.inputToPasswordTextbox("");
        loginPage.clickToLoginButton();
        loginPage.checkMsgEmailError("Wrong email");
    }

    @Test
    public void TC03_Login_Unregistered_Email() {
        loginPage.inputToEmailTextbox("1@gmail.com.vn");
        loginPage.inputToPasswordTextbox("");
        loginPage.clickToLoginButton();
        loginPage.checkValidationError("No customer account found");
    }

    @Test
    public void TC04_Login_Empty_Password() {
        loginPage.inputToEmailTextbox("thuttm@gmail.com.vn");
        loginPage.inputToPasswordTextbox("");
        loginPage.clickToLoginButton();
        loginPage.checkValidationError("The credentials provided are incorrect");
    }

    @Test
    public void TC05_Login_wrong_Email_Password() {
        loginPage.inputToEmailTextbox("thuttm@gmail.com.vn");
        loginPage.inputToPasswordTextbox("123321");
        loginPage.clickToLoginButton();
        loginPage.checkValidationError("The credentials provided are incorrect");
        takeScreenshot(driver);
    }

    @AfterClass
    public void afterClass() {
        cleanBrowserAndDriver();
    }
}
