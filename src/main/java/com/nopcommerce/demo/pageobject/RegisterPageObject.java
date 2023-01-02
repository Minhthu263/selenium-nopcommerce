package com.nopcommerce.demo.pageobject;

import com.nopcommerce.demo.core.BasePage;
import com.nopcommerce.demo.helper.logger.Log;
import com.nopcommerce.demo.pageui.LoginPageUI;
import com.nopcommerce.demo.pageui.RegisterPageUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class RegisterPageObject extends BasePage {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToGenderFemaleRadioButton() {
        Log.allure("Register: Click to Gender Male button");
        waitForElementVisible(driver, RegisterPageUI.GENDER_FEAMALE_RADIO);
        clickToElement(driver, RegisterPageUI.GENDER_FEAMALE_RADIO);
    }

    public void inputToFirtNameTextbox(String firstName) {
        Log.allure("Register: Input to Firtname text box with value: %s", firstName);
        waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void inputToLastNameTextbox(String lastName) {
        Log.allure("Register: Input to lastName text box with value: %s", lastName);
        waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
    }

    public void selectDayDropdown(String day) {
        Log.allure("Register: Select date dropdown");
        waitForElementVisible(driver, RegisterPageUI.DAY_DROPDOWN);
        selectItemInDefaultDropdownByText(driver, RegisterPageUI.DAY_DROPDOWN, day);
    }

    public void selectMonthDropdown(String month) {
        Log.allure("Register: Select month dropdown");
        waitForElementVisible(driver, RegisterPageUI.MONTH_DROPDOWN);
        selectItemInDefaultDropdownByText(driver, RegisterPageUI.MONTH_DROPDOWN, month);
    }

    public void selectYearDropdown(String year) {
        Log.allure("Register: Select year dropdown");
        waitForElementVisible(driver, RegisterPageUI.YEAR_DROPDOWN);
        selectItemInDefaultDropdownByText(driver, RegisterPageUI.YEAR_DROPDOWN, year);
    }

    public void inputToEmailTextbox(String email) {
        Log.allure("Register: Input to email text box with value: %s", email);
        waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
    }

    public void inputToPasswordTextbox(String password) {
        Log.allure("Register: Input to password text box with value: %s", password);
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        scrollToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void inputToConfirmPasswordTextbox(String password) {
        Log.allure("Register: Input to confirm password text box with value: %s", password);
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    public void clickToRegisterButton() {
        Log.allure("Register: Click to Register button at Register Page");
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    public String getResgisteredSuccessMessage() {
        Log.allure("Register: Verify success msg displayed");
        waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getTextElement(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public void clickToLogoutLink() {
        Log.allure("Register: Click to logout link");
        waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
        clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
    }

    public void checkMsgError() {
        Log.allure("Register: Check msg error");
        waitForElementVisible(driver, RegisterPageUI.DYNAMIC_ERROR_MESSAGE, "FirstName-error");
        softAssert.assertEquals(getTextElement(driver, RegisterPageUI.DYNAMIC_ERROR_MESSAGE, "FirstName-error"), "First name is required.");

        waitForElementVisible(driver, RegisterPageUI.DYNAMIC_ERROR_MESSAGE, "LastName-error");
        softAssert.assertEquals(getTextElement(driver, RegisterPageUI.DYNAMIC_ERROR_MESSAGE, "LastName-error"), "Last name is required.");

        waitForElementVisible(driver, RegisterPageUI.DYNAMIC_ERROR_MESSAGE, "Email-error");
        softAssert.assertEquals(getTextElement(driver, RegisterPageUI.DYNAMIC_ERROR_MESSAGE, "Email-error"), "Email-error");

        waitForElementVisible(driver, RegisterPageUI.DYNAMIC_ERROR_MESSAGE, "Password-error");
        softAssert.assertEquals(getTextElement(driver, RegisterPageUI.DYNAMIC_ERROR_MESSAGE, "Password-error"), "Password is required.");

        waitForElementVisible(driver, RegisterPageUI.DYNAMIC_ERROR_MESSAGE, "ConfirmPassword-error");
        softAssert.assertEquals(getTextElement(driver, RegisterPageUI.DYNAMIC_ERROR_MESSAGE, "ConfirmPassword-error"), "Password is required.");
    }

    public void checkEmailMsgError(String value) {
        Log.allure("Register: Check email error");
        waitForElementVisible(driver, RegisterPageUI.DYNAMIC_ERROR_MESSAGE, "Email-error");
        softAssert.assertEquals(getTextElement(driver, RegisterPageUI.DYNAMIC_ERROR_MESSAGE, "Email-error"), value);
    }

    public void checkValidationMsgError(String value) { ////div[@class='message-error validation-summary-errors']//li
        Log.allure("Register: validation email  error");
        waitForElementVisible(driver, RegisterPageUI.VALIDATION_ERROR_MESSAGE);
        softAssert.assertEquals(getTextElement(driver, RegisterPageUI.VALIDATION_ERROR_MESSAGE), value);
    }

    public void checkPasswordMsgError(String value) { ////span[@id='Password-error']//li
        Log.allure("Register: Check password error");
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
        softAssert.assertEquals(getTextElement(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE), value);
    }

    public void checkConfirmPasswordMsgError(String value) {////span[@id='ConfirmPassword-error']
        Log.allure("Register: Check ConfirmPassword error");
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
        softAssert.assertEquals(getTextElement(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE), value);
    }

    public void checkMsgSuccessful(String value) {
        Log.allure("Register: Verify success msg displayed");
        waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        Assert.assertEquals(getTextElement(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE), value);
    }
}
