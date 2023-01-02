package com.nopcommerce.demo.feature.search;

import com.nopcommerce.demo.core.BaseTest;
import com.nopcommerce.demo.pageobject.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AvancedSearch extends BaseTest {
    WebDriver driver;
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

        searchPage.clickToAdvancedSearchCheckbox();

    }

    @Test
    public void TC05_AdvancedSearch_With_Parent_Categories() {
        searchPage.inputToSearchTextbox("Apple Macbook Pro");
        searchPage.selectCategoryDropdown("Computers");
        searchPage.clickToSearchButton();

        searchPage.checkMsgSearchResult("No products were found that matched your criteria.");
    }

    @Test
    public void TC06_AdvancedSearch_With_Sub_Categories() {
        searchPage.inputToSearchTextbox("Apple Macbook Pro");
        searchPage.selectCategoryDropdown("Computers");
        searchPage.clickToAutomaticallyCheckbox();
        searchPage.clickToSearchButton();

        searchPage.checkListProductSearched("Apple MacBook Pro 13-inch");
    }

    @Test
    public void TC07_AdvancedSearch_Incorrect_Manufacturer() {
        searchPage.inputToSearchTextbox("Apple Macbook Pro");
        searchPage.selectCategoryDropdown("Computers");
        searchPage.clickToAutomaticallyCheckbox();
        searchPage.selectManufacturerDropdown("HP");
        searchPage.clickToSearchButton();

        searchPage.checkMsgSearchResult("No products were found that matched your criteria.");
    }

    @Test
    public void TC08_AdvancedSearch_Correct_Manufacturer() {
        searchPage.inputToSearchTextbox("Apple Macbook Pro");
        searchPage.selectCategoryDropdown("Computers");
        searchPage.clickToAutomaticallyCheckbox();
        searchPage.selectManufacturerDropdown("Apple");
        searchPage.clickToSearchProductDescriptionsCheckbox();
        searchPage.clickToSearchButton();

        searchPage.checkListProductSearched("Apple MacBook Pro 13-inch");
    }
}
