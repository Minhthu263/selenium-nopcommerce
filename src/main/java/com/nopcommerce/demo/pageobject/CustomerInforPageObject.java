package com.nopcommerce.demo.pageobject;

import com.nopcommerce.demo.core.BasePage;
import com.nopcommerce.demo.helper.logger.Log;
import com.nopcommerce.demo.pageui.CustomerInforPageUI;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import static org.apache.commons.lang3.StringUtils.contains;

public class CustomerInforPageObject extends BasePage {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    public CustomerInforPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void setGenderFemaleRadioButton() {
        Log.allure("Customer: Click to Gender Male button");
        waitForElementVisible(driver, CustomerInforPageUI.GENDER_FEAMALE_RADIO);
        clickToElement(driver, CustomerInforPageUI.GENDER_FEAMALE_RADIO);
    }

    public void setFirstNameTextbox(String firstName) {
        Log.allure("Customer: Input to Firtname text box with value: %s", firstName);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, "FirstName");
        sendKeyToElement(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, firstName, "FirstName");
    }

    public void setLastNameTextbox(String lastName) {
        Log.allure("Customer: Input to lastName text box with value: %s", lastName);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, "LastName");
        sendKeyToElement(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, lastName, "LastName");
    }

    public void setDayDropdown(String day) {
        Log.allure("Customer: Select date dropdown = %s", day);
        waitForElementVisible(driver, CustomerInforPageUI.DAY_DROPDOWN);
        selectItemInDefaultDropdownByText(driver, CustomerInforPageUI.DAY_DROPDOWN, day);
    }

    public void setMonthDropdown(String month) {
        Log.allure("Customer: Select month dropdown = %s", month);
        waitForElementVisible(driver, CustomerInforPageUI.MONTH_DROPDOWN);
        selectItemInDefaultDropdownByText(driver, CustomerInforPageUI.MONTH_DROPDOWN, month);
    }

    public void setYearDropdown(String year) {
        Log.allure("Customer: Select year dropdown = %s", year);
        waitForElementVisible(driver, CustomerInforPageUI.YEAR_DROPDOWN);
        selectItemInDefaultDropdownByText(driver, CustomerInforPageUI.YEAR_DROPDOWN, year);
    }

    public void setEmailTextbox(String email) {
        Log.allure("Customer: Input to email text box with value: %s", email);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, "Email");
        sendKeyToElement(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, email, "Email");
    }


    public void setCompanyNameTextbox(String companyName) {
        Log.allure("Customer: Input to email text box with value: %s", companyName);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, "Company");
        sendKeyToElement(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, companyName, "Company");
    }

    public void clickToSaveButon() {
        Log.allure("Customer: Click to Register button at Register Page");
        waitForElementClickable(driver, CustomerInforPageUI.SAVE_BUTTON);
        clickToElement(driver, CustomerInforPageUI.SAVE_BUTTON);
    }

    public void checkGenderFemaleRadioButton() {
    }

    public void checkFirstNameTextbox(String firstName) {
        Log.allure("check FirstName Textbox = %s", firstName);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, "FirstName");
        softAssert.assertEquals(getTextElement(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, "FirstName"), firstName);
    }

    public void checkLastNameTextbox(String lastName) {
        Log.allure("check LastName Textbox = %s", lastName);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, "LastName");
        softAssert.assertEquals(getTextElement(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, "LastName"), lastName);
    }

    public void checkDayDropdown(String day) {
        Log.allure("check Day Dropdown = %s", day);
        waitForElementVisible(driver, CustomerInforPageUI.DAY_DROPDOWN);
        softAssert.assertEquals(getSelectedItemInDefaultDropdown(driver, CustomerInforPageUI.DAY_DROPDOWN), day);
    }

    public void checkMonthDropdown(String month) {
        Log.allure("check Month Dropdown = %s", month);
        waitForElementVisible(driver, CustomerInforPageUI.MONTH_DROPDOWN);
        softAssert.assertEquals(getSelectedItemInDefaultDropdown(driver, CustomerInforPageUI.MONTH_DROPDOWN), month);
    }

    public void checkYearDropdown(String year) {
        Log.allure("check Year Dropdown = %s", year);
        waitForElementVisible(driver, CustomerInforPageUI.YEAR_DROPDOWN);
        softAssert.assertEquals(getSelectedItemInDefaultDropdown(driver, CustomerInforPageUI.YEAR_DROPDOWN), year);
    }

    public void checkEmailTextbox(String email) {
        Log.allure("check Email Textbox = %s", email);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, "LastName");
        softAssert.assertEquals(getTextElement(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, "LastName"), email);
    }

    public void checkCompanyNameTextbox(String company) {
    }

    //Address
    public void inputCountryDropdownInAddress(String country) {
        Log.allure("Customer: Select country dropdown");
        waitForElementVisible(driver, CustomerInforPageUI.COUNTRY_DROPDOWN);
        selectItemInDefaultDropdownByText(driver, CustomerInforPageUI.COUNTRY_DROPDOWN, country);
    }

    public void setStateDropdownInAddress(String state) {
        Log.allure("Customer: Select state dropdown");
        waitForElementVisible(driver, CustomerInforPageUI.STATE_DROPDOWN);
        selectItemInDefaultDropdownByText(driver, CustomerInforPageUI.STATE_DROPDOWN, state);
    }

    public void inputCityTextboxInAddress(String city) {
        Log.allure("Customer: Input to City text box with value: %s", city);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, "Address_City");
        sendKeyToElement(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, city, "Address_City");
    }

    public void inputAddress1TextboxInAddress(String address1) {
        Log.allure("Customer: Input to Address1 text box with value: %s", address1);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, "Address_Address1");
        sendKeyToElement(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, address1, "Address_Address1");
    }

    public void inputAddress2TextboxInAddress(String address2) {
        Log.allure("Customer: Input to Address2 text box with value: %s", address2);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, "Address_Address2");
        sendKeyToElement(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, address2, "Address_Address2");
    }

    public void inputZipTextboxInAddress(String zip) {
        Log.allure("Customer: Input to zip text box with value: %s", zip);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, "Address_ZipPostalCode");
        sendKeyToElement(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, zip, "Address_ZipPostalCode");
    }

    public void inputPhoneNumberTextboxInAddress(String phoneNumber) {
        Log.allure("Customer: Input to phone number text box with value: %s", phoneNumber);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, "Address_PhoneNumber");
        sendKeyToElement(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, phoneNumber, "Address_PhoneNumber");
    }

    public void inputfaxnumbertextboxInAddress(String faxNumber) {
        Log.allure("Customer: Input to fax number text box with value: %s", faxNumber);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, "Address_FaxNumber");
        sendKeyToElement(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, faxNumber, "Address_FaxNumber");
    }

    public void clickToAddressLink() {
        Log.allure("Click to Address Link");
        waitForElementClickable(driver, CustomerInforPageUI.DYNAMIC_LINK_IN_LISTBOX, "Addresses");
        clickToElement(driver, CustomerInforPageUI.DYNAMIC_LINK_IN_LISTBOX, "Addresses");
    }

    public void checkCountryDropdownInAddress(String country) {
        Log.allure("check country Dropdown = %s", country);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_ADDRESSES_TEXT, "country");
        softAssert.assertTrue(contains
                (getTextElement(driver, CustomerInforPageUI.DYNAMIC_ADDRESSES_TEXT, "country"), country));
    }

    public void checkStateDropdownInAddress(String state) {
        Log.allure("check state Dropdown = %s", state);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_ADDRESSES_TEXT, "city-state-zip");
        softAssert.assertTrue(contains
                (getTextElement(driver, CustomerInforPageUI.DYNAMIC_ADDRESSES_TEXT, "city-state-zip"), state));
    }

    public void checkCityTextboxInAddress(String city) {
        Log.allure("check city Textbox = %s", city);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_ADDRESSES_TEXT, "city-state-zip");
        softAssert.assertTrue(contains
                (getTextElement(driver, CustomerInforPageUI.DYNAMIC_ADDRESSES_TEXT, "city-state-zip"), city));
    }

    public void checkAddress1TextboxInAddress(String address1) {
        Log.allure("check address1 Textbox = %s", address1);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_ADDRESSES_TEXT, "address1");
        softAssert.assertTrue(contains
                (getTextElement(driver, CustomerInforPageUI.DYNAMIC_ADDRESSES_TEXT, "address1"), address1));
    }

    public void checkAddress2TextboxInAddress(String address2) {
        Log.allure("check address2 Textbox = %s", address2);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_ADDRESSES_TEXT, "address2");
        softAssert.assertTrue(contains
                (getTextElement(driver, CustomerInforPageUI.DYNAMIC_ADDRESSES_TEXT, "address2"), address2));
    }

    public void checkZipTextboxInAddress(String zip) {
        Log.allure("check zip Textbox = %s", zip);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_ADDRESSES_TEXT, "city-state-zip");
        softAssert.assertTrue(contains
                (getTextElement(driver, CustomerInforPageUI.DYNAMIC_ADDRESSES_TEXT, "city-state-zip"), zip));
    }

    public void checkPhoneNumberTextboxInAddress(String phoneNumber) {
        Log.allure("check phoneNumber Textbox = %s", phoneNumber);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_ADDRESSES_TEXT, "phone");
        softAssert.assertTrue(contains
                (getTextElement(driver, CustomerInforPageUI.DYNAMIC_ADDRESSES_TEXT, "phone"), phoneNumber));
    }

    public void checkFaxNumberTextboxInAddress(String faxNumber) {
        Log.allure("check faxNumber Textbox = %s", faxNumber);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_ADDRESSES_TEXT, "fax");
        softAssert.assertTrue(contains
                (getTextElement(driver, CustomerInforPageUI.DYNAMIC_ADDRESSES_TEXT, "fax"), faxNumber));
    }

    public void clickToAddNewButton() {
        Log.allure("Address: Click to Add New Button");
        waitForElementClickable(driver, CustomerInforPageUI.ADD_NEW_BUTTON);
        clickToElement(driver, CustomerInforPageUI.ADD_NEW_BUTTON);
    }

    public void inputFirstNameTextboxInAddress(String firstName) {
        Log.allure("Customer: Input to Firtname text box with value: %s", firstName);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, "Address_FirstName");
        sendKeyToElement(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, firstName, "Address_FirstName");
    }

    public void inputLastNameTextboxInAddress(String lastName) {
        Log.allure("Customer: Input to lastName text box with value: %s", lastName);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, "Address_LastName");
        sendKeyToElement(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, lastName, "Address_LastName");
    }

    public void inputEmailTextboxInAddress(String email) {
        Log.allure("Customer: Input to email text box with value: %s", email);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, "Address_Email");
        sendKeyToElement(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, email, "Address_Email");
    }

    public void inputCompanyNameTextboxInAddress(String companyName) {
        Log.allure("Customer: Input to Address_Company text box with value: %s", companyName);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, "Address_Company");
        sendKeyToElement(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, companyName, "Address_Company");
    }

    public void checkNameTextboxInAddress(String name) {
        Log.allure("check Name Text = %s", name);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_ADDRESSES_TEXT, "name");
        softAssert.assertTrue(contains
                (getTextElement(driver, CustomerInforPageUI.DYNAMIC_ADDRESSES_TEXT, "name"), name));
    }

    public void checkEmailTextboxInAddress(String email) {
        Log.allure("check email Textbox = %s", email);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_ADDRESSES_TEXT, "email");
        softAssert.assertTrue(contains
                (getTextElement(driver, CustomerInforPageUI.DYNAMIC_ADDRESSES_TEXT, "email"), email));
    }

    public void checkCompanyNameTextboxInAddress(String companyName) {
        Log.allure("check companyName Textbox = %s", companyName);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_ADDRESSES_TEXT, "company");
        softAssert.assertTrue(contains
                (getTextElement(driver, CustomerInforPageUI.DYNAMIC_ADDRESSES_TEXT, "company"), companyName));
    }

    //Change Password
    public void clickToChangePasswordLink() {
        Log.allure("Click to Address Link");
        waitForElementClickable(driver, CustomerInforPageUI.DYNAMIC_LINK_IN_LISTBOX, "Change password");
        clickToElement(driver, CustomerInforPageUI.DYNAMIC_LINK_IN_LISTBOX, "Change password");
    }

    public void inputOldPasswordTextbox(String password) {
        Log.allure("Customer: Input to password text box with value: %s", password);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, "OldPassword");
        sendKeyToElement(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, password, "OldPassword");
    }

    public void inputNewPasswordTextbox(String newPassword) {
        Log.allure("Customer: Input to newPassword text box with value: %s", newPassword);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, "NewPassword");
        sendKeyToElement(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, newPassword, "NewPassword");
    }

    public void inputConfirmPasswordTextbox(String newPassword) {
        Log.allure("Customer: Input to Firtname text box with value: %s", newPassword);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, "ConfirmNewPassword");
        sendKeyToElement(driver, CustomerInforPageUI.DYNAMIC_TEXTBOX, newPassword, "ConfirmNewPassword");
    }

    public void clickToChangePasswordButton() {
        Log.allure("Click to Change Password Button");
        waitForElementClickable(driver, CustomerInforPageUI.CHANGE_PASSWORD_BUTTON);
        clickToElement(driver, CustomerInforPageUI.CHANGE_PASSWORD_BUTTON);
    }

    public void checkMsgChangePasswordSuccess(String message) {
        Log.allure("check Msg Change Password Success = %s", message);
        waitForElementVisible(driver, CustomerInforPageUI.CHANGEPASSWORD_SUCCESS_MESSAGE);
        softAssert.assertEquals(getTextElement(driver, CustomerInforPageUI.CHANGEPASSWORD_SUCCESS_MESSAGE), message);
    }

    public void clickToCloseChangePasswordButton() {
        Log.allure("Click to Close Change Password Button");
        waitForElementClickable(driver, CustomerInforPageUI.CHANGEPASSWORD_SUCCESS_BUTTON);
        clickToElement(driver, CustomerInforPageUI.CHANGEPASSWORD_SUCCESS_BUTTON);
    }

    public void clickToMyProductReviewLink() {
        Log.allure("Click to My Product Review Link");
        waitForElementClickable(driver, CustomerInforPageUI.DYNAMIC_LINK_IN_LISTBOX, "My product reviews");
        clickToElement(driver, CustomerInforPageUI.DYNAMIC_LINK_IN_LISTBOX, "My product reviews");
    }

    public void isProductNameReviewedLinkDisplay(String s) {
        Log.allure("Check Product Name Reviewed Link Display");
        waitForElementVisible(driver, CustomerInforPageUI.PRODUCT_REVIEWED_LINK, s);
        isElementDisplay(driver, CustomerInforPageUI.PRODUCT_REVIEWED_LINK, s);
    }

    public void checkReviewTextReviewed(String s, String content) {
        Log.allure("check ReviewText Reviewed %s", content);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_REVIEW_TEXT_LABEL, s);
        softAssert.assertEquals(getTextElement(driver, CustomerInforPageUI.DYNAMIC_REVIEW_TEXT_LABEL, s), content);
    }

    public void checkReviewTitleReviewed(String s, String content) {
        Log.allure("check ReviewText Reviewed %s", content);
        waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_REVIEW_TEXT_LABEL, s);
        softAssert.assertEquals(getTextElement(driver, CustomerInforPageUI.DYNAMIC_REVIEW_TEXT_LABEL, s), content);
    }
}
