package com.nopcommerce.demo.feature.myaccount;

import com.nopcommerce.demo.core.BaseTest;
import com.nopcommerce.demo.pageobject.*;
import com.nopcommerce.demo.utils.DataUtils;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Epic("NopCommerce")
@Feature("My Account")
@Story("My Account")
public class MyAccount extends BaseTest {
    WebDriver driver;
    CustomerInforPageObject customerInforPage;
    LoginPageObject loginPage;
    HomePageObject homePage;
    ProductsPageObject productsPage;
    ProductDetailPageObject productDetailPage;

    String firstName, lastName, email, companyName, day, month, year;
    String country, state, city, address1, address2, zip, phoneNumber, faxNumber;
    String password, newPassword;


    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("chrome") String browser) {
        driver = getBrowserDriver(browser, "https://demo.nopcommerce.com/login");
        customerInforPage = PageGeneratorManager.getCustomerInforPage(driver);
        loginPage = PageGeneratorManager.getLoginPage(driver);
        homePage = PageGeneratorManager.getHomePage(driver);
        productsPage = PageGeneratorManager.getProductsPage(driver);
        productDetailPage = PageGeneratorManager.getProductDetailPage(driver);

        email = "thulogin@gmail.com";
        password = "123456";
        loginPage.inputToEmailTextbox(email);
        loginPage.inputToPasswordTextbox(password);
        loginPage.clickToLoginButton();

        homePage.clickToMyAccountLink();
    }

    @Test
    public void TC01_MyAccount_CustomerInfo() {
        firstName = DataUtils.getData().getFirtName();
        lastName = DataUtils.getData().getLastName();
        day = String.valueOf(DataUtils.getData().getDayNumber());
        month = "May";
        year = String.valueOf(DataUtils.getData().getYearNumber());
        companyName = DataUtils.getData().getCompanyNameNumber();
        email = DataUtils.getData().getEmailAddress();

        customerInforPage.setGenderFemaleRadioButton();
        customerInforPage.setFirstNameTextbox(firstName);
        customerInforPage.setLastNameTextbox(lastName);
        customerInforPage.setDayDropdown(day);
        customerInforPage.setMonthDropdown(month);
        customerInforPage.setYearDropdown(year);
        customerInforPage.setEmailTextbox(email);
        customerInforPage.setCompanyNameTextbox(companyName);

        customerInforPage.clickToSaveButon();

        customerInforPage.checkGenderFemaleRadioButton();
        customerInforPage.checkFirstNameTextbox(firstName);
        customerInforPage.checkLastNameTextbox(lastName);
        customerInforPage.checkDayDropdown(day);
        customerInforPage.checkMonthDropdown(month);
        customerInforPage.checkYearDropdown(year);
        customerInforPage.checkEmailTextbox(email);
        customerInforPage.checkCompanyNameTextbox(companyName);
    }

    @Test
    public void TC02_MyAccount_Addresses() {
        firstName = DataUtils.getData().getFirtName();
        lastName = DataUtils.getData().getLastName();
        email = DataUtils.getData().getEmailAddress();
        companyName = DataUtils.getData().getCompanyNameNumber();
        country = "Viet Nam";
        city = DataUtils.getData().getCity();
        address1 = DataUtils.getData().getFirstNameAddress();
        address2 = DataUtils.getData().getFirstNameAddress();
        zip = "550000";
        phoneNumber = DataUtils.getData().getPhoneNumber();
        faxNumber = DataUtils.getData().getPhoneNumber();

        customerInforPage.clickToAddressLink();
        customerInforPage.clickToAddNewButton();

        customerInforPage.inputFirstNameTextboxInAddress(firstName);
        customerInforPage.inputLastNameTextboxInAddress(lastName);
        customerInforPage.inputEmailTextboxInAddress(email);
        customerInforPage.inputCompanyNameTextboxInAddress(companyName);
        customerInforPage.inputCountryDropdownInAddress(country);
        customerInforPage.inputCityTextboxInAddress(city);
        customerInforPage.inputAddress1TextboxInAddress(address1);
        customerInforPage.inputAddress2TextboxInAddress(address2);
        customerInforPage.inputZipTextboxInAddress(zip);
        customerInforPage.inputPhoneNumberTextboxInAddress(phoneNumber);
        customerInforPage.inputfaxnumbertextboxInAddress(faxNumber);

        customerInforPage.clickToSaveButon();

        customerInforPage.checkNameTextboxInAddress(firstName + " " + lastName);
        customerInforPage.checkEmailTextboxInAddress(email);
        customerInforPage.checkCompanyNameTextboxInAddress(companyName);
        customerInforPage.checkCountryDropdownInAddress(country);
        customerInforPage.checkStateDropdownInAddress(state);
        customerInforPage.checkCityTextboxInAddress(city);
        customerInforPage.checkAddress1TextboxInAddress(address1);
        customerInforPage.checkAddress2TextboxInAddress(address2);
        customerInforPage.checkZipTextboxInAddress(zip);
        customerInforPage.checkPhoneNumberTextboxInAddress(phoneNumber);
        customerInforPage.checkFaxNumberTextboxInAddress(faxNumber);
    }

    @Test
    public void TC03_MyAccount_ChangePassword() {
        customerInforPage.clickToChangePasswordLink();

        newPassword = "666666";
        customerInforPage.inputOldPasswordTextbox(password);
        customerInforPage.inputNewPasswordTextbox(newPassword);
        customerInforPage.inputConfirmPasswordTextbox(newPassword);

        customerInforPage.clickToChangePasswordButton();
        customerInforPage.checkMsgChangePasswordSuccess("Password was changed");
        customerInforPage.clickToCloseChangePasswordButton();

        homePage.clickToLogOutLink();
        homePage.clickToLogInLink();

        loginPage.inputToEmailTextbox(email);
        loginPage.inputToPasswordTextbox(password);
        loginPage.clickToLoginButton();
        loginPage.checkValidationError("The credentials provided are incorrect");

        loginPage.inputToEmailTextbox(email);
        loginPage.inputToPasswordTextbox(newPassword);
        loginPage.clickToLoginButton();
        homePage.checkMyAccountLinkDisplayed();
    }

    @Test
    public void TC04_MyAccount_MyProductReviews() {
        homePage.clickToComputerLink();

        productsPage.clickToNotebookLink();
        productsPage.clickToProductName("Apple MacBook Pro 13-inch");

        productDetailPage.clickToAddYourReviewButton();
        productDetailPage.inputToReviewTitleTextbox("Nội dung");
        productDetailPage.inputToReviewTextTextbox("Nội dung chi tiết");
//        productDetailPage.ClickToRatingRadioButton();
        productDetailPage.ClickToSubmitReviewButton();

        homePage.clickToMyAccountLink();

        customerInforPage.clickToMyProductReviewLink();

        customerInforPage.isProductNameReviewedLinkDisplay("Apple MacBook Pro 13-inch");
        customerInforPage.checkReviewTextReviewed("Apple MacBook Pro 13-inch", "Nội dung chi tiết");
        customerInforPage.checkReviewTitleReviewed("Apple MacBook Pro 13-inch", "Nội dung");
    }

    @AfterClass
    public void afterClass() {
        cleanBrowserAndDriver();
    }
}
