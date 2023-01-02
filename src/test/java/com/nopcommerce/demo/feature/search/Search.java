package com.nopcommerce.demo.feature.search;

import com.nopcommerce.demo.core.BaseTest;
import com.nopcommerce.demo.pageobject.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Search extends BaseTest {
    WebDriver driver;
    CustomerInforPageObject customerInforPage;
    LoginPageObject loginPage;
    HomePageObject homePage;
    SearchPageObject searchPage;

    String email, password;


    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("chrome") String browser) {
        driver = getBrowserDriver(browser, "https://demo.nopcommerce.com/login");
        loginPage = PageGeneratorManager.getLoginPage(driver);
        homePage = PageGeneratorManager.getHomePage(driver);
        searchPage = PageGeneratorManager.getSearchPage(driver);

        email = "thulogin@gmail.com";
        password = "123456";
        loginPage.inputToEmailTextbox(email);
        loginPage.inputToPasswordTextbox(password);
        loginPage.clickToLoginButton();

        homePage.clickToSearchButton();
    }

    @Test
    public void TC01_Search_With_Empty_Data() {
        searchPage.inputToSearchTextbox("");
        searchPage.clickToSearchButton();
        searchPage.checkMsgSearchError("Search term minimum length is 3 characters");
    }

    @Test
    public void TC02_Search_With_Data_NotExist() {
        searchPage.inputToSearchTextbox("Macbook pro 0 0 có");
        searchPage.clickToSearchButton();
        searchPage.checkMsgSearchResult("No products were found that matched your criteria.");
    }

    @Test
    public void TC03_Search_With_Product_Name_Relative() {
        searchPage.inputToSearchTextbox("Lenovo");
        searchPage.clickToSearchButton();
        searchPage.checkListProductSearched("Lenovo");
    }

    @Test
    public void TC04_Search_With_Product_Name_Absolute() {
        searchPage.inputToSearchTextbox("ThinkPad X1 Carbon");
        searchPage.clickToSearchButton();
        searchPage.checkListProductSearched("ThinkPad X1 Carbon");
    }
}
