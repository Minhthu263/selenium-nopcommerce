package com.nopcommerce.demo.feature.register;

import com.nopcommerce.demo.core.BaseTest;
import com.nopcommerce.demo.pageobject.LoginPageObject;
import com.nopcommerce.demo.pageobject.PageGeneratorManager;
import com.nopcommerce.demo.pageobject.RegisterPageObject;
import com.nopcommerce.demo.utils.DataUtils;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.jsoup.helper.DataUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Epic("NopCommerce")
@Feature("Register")
@Story("Register UnSuccessful")
public class RegisterUnsuccessful extends BaseTest {
    WebDriver driver;
    LoginPageObject loginPage;
    RegisterPageObject registerPage;
    String email, password;

    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("chrome") String browser) {
        driver = getBrowserDriver(browser, "https://demo.nopcommerce.com/register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);
    }

    @Test
    public void TC01_Register_Empty_Data() {
        registerPage.clickToGenderFemaleRadioButton();
        registerPage.inputToFirtNameTextbox("");
        registerPage.inputToLastNameTextbox("");
        registerPage.inputToEmailTextbox("");
        registerPage.inputToPasswordTextbox("");
        registerPage.inputToConfirmPasswordTextbox("");
        registerPage.clickToRegisterButton();

        registerPage.checkMsgError();
    }

    @Test
    public void TC02_Register_Invalid_Email() {
        registerPage.clickToGenderFemaleRadioButton();
        registerPage.inputToFirtNameTextbox("");
        registerPage.inputToLastNameTextbox("");
        registerPage.inputToEmailTextbox("1");
        registerPage.inputToPasswordTextbox("");
        registerPage.inputToConfirmPasswordTextbox("");
        registerPage.clickToRegisterButton();

        registerPage.checkEmailMsgError("Wrong email");
    }

    @Test
    public void TC04_Register_Existed_Email() {
        registerPage.clickToGenderFemaleRadioButton();
        registerPage.inputToFirtNameTextbox(DataUtils.getData().getFirtName());
        registerPage.inputToLastNameTextbox(DataUtils.getData().getLastName());
        registerPage.inputToEmailTextbox("thuttm@gmail.com.vn");
        registerPage.inputToPasswordTextbox("123456");
        registerPage.inputToConfirmPasswordTextbox("123456");
        registerPage.clickToRegisterButton();

        registerPage.checkValidationMsgError("The specified email already exists");
    }

    @Test
    public void TC05_Register_Less6character_Password() {
        registerPage.clickToGenderFemaleRadioButton();
        registerPage.inputToFirtNameTextbox(DataUtils.getData().getFirtName());
        registerPage.inputToLastNameTextbox(DataUtils.getData().getLastName());
        registerPage.inputToEmailTextbox("thuttm@gmail.com.vn");
        registerPage.inputToPasswordTextbox("121");
        registerPage.inputToConfirmPasswordTextbox("121");
        registerPage.clickToRegisterButton();

        registerPage.checkPasswordMsgError("must have at least 6 characters");
    }

    @Test
    public void TC06_Register_Mismatched_ConfirmPassword() {
        registerPage.clickToGenderFemaleRadioButton();
        registerPage.inputToFirtNameTextbox(DataUtils.getData().getFirtName());
        registerPage.inputToLastNameTextbox(DataUtils.getData().getLastName());
        registerPage.inputToEmailTextbox("thuttm@gmail.com.vn");
        registerPage.inputToPasswordTextbox("123456");
        registerPage.inputToConfirmPasswordTextbox("654321");
        registerPage.clickToRegisterButton();

        registerPage.checkConfirmPasswordMsgError("The password and confirmation password do not match.");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
