package com.nopcommerce.demo.feature.sort_display;

import com.nopcommerce.demo.core.BaseTest;
import com.nopcommerce.demo.pageobject.HomePageObject;
import com.nopcommerce.demo.pageobject.PageGeneratorManager;
import com.nopcommerce.demo.pageobject.ProductsPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Display extends BaseTest {
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
    public void TC05_Display_With_3ProductOnPage() {
        productsPage.selectDisplayDropdown("3");
        checkTrue(productsPage.checkListProductDisplay(3));
        checkTrue(productsPage.checkNextIconPage());
        productsPage.clickToNextPage();
        checkTrue(productsPage.checkPreviousIconPage());
    }

    @Test
    public void TC06_Display_With_6ProductOnPage() {
        productsPage.selectDisplayDropdown("6");
        checkTrue(productsPage.checkListProductDisplay(6));
        checkTrue(productsPage.checkToPagingUndisplay());
    }

    @Test
    public void TC07_Display_With_9ProductOnPage() {
        productsPage.selectDisplayDropdown("9");
        checkTrue(productsPage.checkListProductDisplay(9));
        checkTrue(productsPage.checkToPagingUndisplay());
    }
}
