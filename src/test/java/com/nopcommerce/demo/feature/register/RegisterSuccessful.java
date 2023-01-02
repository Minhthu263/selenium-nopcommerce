package com.nopcommerce.demo.feature.register;

import com.nopcommerce.demo.core.BaseTest;
import com.nopcommerce.demo.pageobject.LoginPageObject;
import com.nopcommerce.demo.pageobject.PageGeneratorManager;
import com.nopcommerce.demo.pageobject.RegisterPageObject;
import com.nopcommerce.demo.utils.DataUtils;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Epic("NopCommerce")
@Feature("Register")
@Story("Register Successful")
public class RegisterSuccessful extends BaseTest {
    WebDriver driver;
    LoginPageObject loginPage;
    RegisterPageObject registerPage;
    String email, password;

    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("chrome") String browser) {
        driver = getBrowserDriver(browser, "https://demo.nopcommerce.com/register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        password = "123456";
    }

    @Test
    public void TC03_Register_Successful() {
        registerPage.clickToGenderFemaleRadioButton();
        registerPage.inputToFirtNameTextbox(DataUtils.getData().getFirtName());
        registerPage.inputToLastNameTextbox(DataUtils.getData().getLastName());
        registerPage.selectDayDropdown(String.valueOf(DataUtils.getData().getDayNumber()));
        registerPage.selectMonthDropdown("May");
        registerPage.selectYearDropdown(String.valueOf(DataUtils.getData().getYearNumber()));
        registerPage.inputToEmailTextbox(DataUtils.getData().getEmailAddress());
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();

        registerPage.checkMsgSuccessful("Your registration completed");

        Assert.assertEquals(registerPage.getResgisteredSuccessMessage(), "Your registration completed");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
