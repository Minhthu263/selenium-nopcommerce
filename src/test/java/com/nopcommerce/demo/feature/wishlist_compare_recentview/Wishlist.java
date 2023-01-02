package com.nopcommerce.demo.feature.wishlist_compare_recentview;

import com.nopcommerce.demo.core.BaseTest;
import com.nopcommerce.demo.pageobject.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Wishlist extends BaseTest {
    WebDriver driver;
    LoginPageObject loginPage;
    HomePageObject homePage;
    ProductsPageObject productsPage;
    ProductDetailPageObject productDetailPage;
    WishlistPageObject wishlistPage;
    ShoppingCartPageObject shoppingCartPage;
    CompareProductsPageObject compareProductsPage;

    String email, password, productName, productName1, productName2;


    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("chrome") String browser) {
        driver = getBrowserDriver(browser, "https://demo.nopcommerce.com/login");
        loginPage = PageGeneratorManager.getLoginPage(driver);
        homePage = PageGeneratorManager.getHomePage(driver);
        productsPage = PageGeneratorManager.getProductsPage(driver);
        productDetailPage = PageGeneratorManager.getProductDetailPage(driver);
        wishlistPage = PageGeneratorManager.getWishlistPage(driver);
        shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
        compareProductsPage = PageGeneratorManager.getCompareProductsPage(driver);

        email = "thulogin@gmail.com";
        password = "123456";
        productName = "Apple MacBook Pro 13-inch";
        loginPage.inputToEmailTextbox(email);
        loginPage.inputToPasswordTextbox(password);
        loginPage.clickToLoginButton();

        homePage.clickToComputerLink();

        productsPage.clickToNotebookLink();
        productsPage.clickToProductName(productName);

    }

    @Test
    public void TC01_Add_To_Wishlist() {
        productDetailPage.clickToAddToWishlistButton();
//        productDetailPage.checkAddWishlistMsgSuccess("The product has been added to your wishlist");
        checkTrue(productDetailPage.checkAddWishlistMsgSuccess("The product has been added to your wishlist"));
        productDetailPage.clickToCloseMsgButton();
        homePage.clickToWishlistLink();
        Assert.assertTrue(wishlistPage.checkProductWishlistDisplay(productName));
        wishlistPage.clickToUrlSharingLink();
        wishlistPage.checkProductWishlistDisplay(productName);
    }

    @Test
    public void TC02_Add_Product_To_Card_FromWishlistPage() {
        productName = "Apple MacBook Pro 13-inch";
        driver.get("https://demo.nopcommerce.com/wishlist");
        wishlistPage.clickToAddToCardCheckbox(productName);
        wishlistPage.clickToAddToCardButton();
        shoppingCartPage.checkProductCartDisplay(productName);

        homePage.clickToWishlistLink();
        wishlistPage.checkProductWishlistUnDisplay(productName);
    }

    @Test
    public void TC03_Remove_Product_In_WishlistPage() {
        productName = "Apple MacBook Pro 13-inch";
        homePage.clickToComputerLink();

        productsPage.clickToNotebookLink();
        productsPage.clickToProductName(productName);
        productDetailPage.clickToAddToWishlistButton();

        homePage.clickToWishlistLink();
        wishlistPage.clickToRemoveCheckbox(productName);
        wishlistPage.checkProductWishlistUnDisplay(productName);
    }

    @Test
    public void TC04_Add_Product_To_Compare() {
        productName1 = "Build your own computer";
        productName2 = "Digital Storm VANQUISH 3 Custom Performance PC";
        homePage.clickToComputerLink();

        productsPage.clickToDesktopsLink();
        productsPage.clickToAddToCompareListButton(productName1);
        productsPage.clickToAddToCompareListButton(productName2);

        productsPage.checkMsgAddToCompareListSuccess("The product has been added to your ");
        homePage.clickToCompareProductsListLink();

        compareProductsPage.checkProductDispalay(productName1);
        compareProductsPage.checkProductDispalay(productName2);

        compareProductsPage.clickToClearListButton();
        compareProductsPage.checkMsgNoData("You have no items to compare.");
        compareProductsPage.checkProductUndisplay(productName1);
        compareProductsPage.checkProductUndisplay(productName2);
    }

    @Test
    public void TC05_Recently_Viewed_Products() {
        String productName1 = "Apple MacBook Pro 13-inch";
        String productName2 = "Asus N551JK-XO076H Laptop";
        String productName3 = "HP Envy 6-1180ca 15.6-Inch Sleekbook";
        String productName4 = "HP Spectre XT Pro UltraBook";
        String productName5 = "Lenovo Thinkpad X1 Carbon Laptop";

        homePage.clickToComputerLink();

        productsPage.clickToNotebookLink();
        productsPage.clickToProductName(productName1);
        productsPage.backToPreviousPage();
        productsPage.clickToProductName(productName2);
        productsPage.backToPreviousPage();
        productsPage.clickToProductName(productName3);
        productsPage.backToPreviousPage();
        productsPage.clickToProductName(productName4);
        productsPage.backToPreviousPage();
        productsPage.clickToProductName(productName5);
        productsPage.backToPreviousPage();

        homePage.clickToRecentlyViewedProductsListLink();

        productsPage.checkListProductRecentlyViewedDisplay(productName3, productName4, productName5);
    }

}
