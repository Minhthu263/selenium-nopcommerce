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
@Story("Login Successful")
public class LoginSuccessful extends BaseTest {
    WebDriver driver;
    LoginPageObject loginPage;
    HomePageObject homePage;
    String email, password;

    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("chrome") String browser) {
        driver = getBrowserDriver(browser, "https://demo.nopcommerce.com/login");
        loginPage = PageGeneratorManager.getLoginPage(driver);
        homePage = PageGeneratorManager.getHomePage(driver);
        email = "thulogin@gmail.com";
        password = "123456";
    }

    @Test
    public void TC06_Login_Successful() {
        loginPage.inputToEmailTextbox(email);
        loginPage.inputToPasswordTextbox(password);
        loginPage.clickToLoginButton();
        homePage.checkMyAccountLinkDisplayed();
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
        Assert.assertTrue(homePage.isLogoutLinkDisplayed());
    }

    @AfterClass
    public void afterClass() {
        cleanBrowserAndDriver();
    }
}
