package com.nopcommerce.demo.pageobject;

import com.nopcommerce.demo.core.BasePage;
import com.nopcommerce.demo.helper.logger.Log;
import com.nopcommerce.demo.helper.reporter.TestListener;
import com.nopcommerce.demo.pageui.LoginPageUI;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

@Listeners(TestListener.class)
public class LoginPageObject extends BasePage {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToEmailTextbox(String email) {
        Log.allure("Login: Input to email text box with value: %s", email);
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
    }

    public void inputToPasswordTextbox(String password) {
        Log.allure("Login: Input to password text box with value: %s", password);
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public void clickToLoginButton() {
        Log.allure("Login: Click to login button at Login Page");
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }

    public void checkMsgEmailError(String value) {
        Log.allure("Login: Check msg email error");
        waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
        softAssert.assertEquals(getTextElement(driver, LoginPageUI.EMAIL_ERROR_MESSAGE), value);
    }

    public void checkValidationError(String value) {
        Log.allure("Login: Check msg validation error");
        waitForElementVisible(driver, LoginPageUI.VALIDATION_ERROR_MESSAGE);
        softAssert.assertEquals(getTextElement(driver, LoginPageUI.VALIDATION_ERROR_MESSAGE), value);
    }
}
