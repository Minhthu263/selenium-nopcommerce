package com.nopcommerce.demo.feature.sort_display;

import com.nopcommerce.demo.core.BaseTest;
import com.nopcommerce.demo.pageobject.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sort extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;
    ProductsPageObject productsPage;


    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("chrome") String browser) {
        driver = getBrowserDriver(browser, "https://demo.nopcommerce.com/");
        homePage = PageGeneratorManager.getHomePage(driver);
        productsPage = PageGeneratorManager.getProductsPage(driver);

        homePage.clickToComputerLink();

        productsPage.clickToNotebookLink();
    }

    @Test
    public void TC01_Sort_With_Name_AtoZ() {
        productsPage.selectSortByDropdown("Name: A to Z");
    }

    @Test
    public void TC02_Sort_With_Name_ZtoA() {
        productsPage.selectSortByDropdown("Name: Z to A");
    }

    @Test
    public void TC03_Sort_With_Price_LowToHigh() {
        productsPage.selectSortByDropdown("Price: Low to High");
    }

    @Test
    public void TC04_Sort_With_Price_HighToLow() {
        productsPage.selectSortByDropdown("Price: High to Low");
    }
}
