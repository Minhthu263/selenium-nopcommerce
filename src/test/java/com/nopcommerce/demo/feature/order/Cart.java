package com.nopcommerce.demo.feature.order;

import com.nopcommerce.demo.core.BaseTest;
import com.nopcommerce.demo.pageobject.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Cart extends BaseTest {
    WebDriver driver;
    LoginPageObject loginPage;
    HomePageObject homePage;
    ProductsPageObject productsPage;
    ProductDetailPageObject productDetailPage;
    ShoppingCartPageObject shoppingCartPage;


    String email, password;
    String productName;


    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("chrome") String browser) {
        driver = getBrowserDriver(browser, "https://demo.nopcommerce.com/login");
        loginPage = PageGeneratorManager.getLoginPage(driver);
        homePage = PageGeneratorManager.getHomePage(driver);
        productsPage = PageGeneratorManager.getProductsPage(driver);
        productDetailPage = PageGeneratorManager.getProductDetailPage(driver);
        shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);

        email = "thulogin@gmail.com";
        password = "123456";
        loginPage.inputToEmailTextbox(email);
        loginPage.inputToPasswordTextbox(password);
        loginPage.clickToLoginButton();
        productName = "Build your own computer";

    }

    @Test
    public void TC01_Add_Product_To_Cart() {

        homePage.clickToComputerLink();
        productsPage.clickToDesktopsLink();

        productsPage.clickToProductName(productName);

        productDetailPage.selectProcessorDropdown("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");
        productDetailPage.selectRamDropdown("8GB [+$60.00]");
        productDetailPage.clickHDDRadioButton("400 GB [+$100.00]");
        productDetailPage.clickOSRadioButton("Vista Premium [+$60.00]");
        productDetailPage.clickSoftwareCheckbox("Microsoft Office [+$50.00]");
        productDetailPage.clickSoftwareCheckbox("Acrobat Reader [+$10.00]");
        productDetailPage.clickSoftwareCheckbox("Total Commander [+$5.00]");

        productDetailPage.clickAddToCartButton();
        productDetailPage.checkMsgAddToCartSuccess("The product has been added to your ");
        homePage.clickToShoppingCartLink();

        checkTrue(shoppingCartPage.checkProductCartDisplay(productName));
    }

    @Test
    public void TC02_Edit_In_Shopping_Cart() {
        shoppingCartPage.clickToEditProductButton(productName);

        productDetailPage.selectProcessorDropdown("2.2 GHz Intel Pentium Dual-Core E2200");
        productDetailPage.selectRamDropdown("4GB [+$20.00]");
        productDetailPage.clickHDDRadioButton("320 GB");
        productDetailPage.clickOSRadioButton("Vista Home [+$50.00]");
        productDetailPage.clickSoftwareCheckbox("Microsoft Office [+$50.00]");
        productDetailPage.unClickSoftwareCheckbox("Acrobat Reader [+$10.00]");
        productDetailPage.unClickSoftwareCheckbox("Total Commander [+$5.00]");
        productDetailPage.setQuantityTextbox("2");

        productDetailPage.clickAddToCartButton();
        productDetailPage.checkMsgAddToCartSuccess("The product has been added to your ");
        homePage.clickToShoppingCartLink();

        checkTrue(shoppingCartPage.checkProductCartDisplay(productName));

    }

    @Test
    public void TC03_Remove_From_Cart() {
        shoppingCartPage.clickToRemoveButton(productName);
        shoppingCartPage.chechMsg("Your Shopping Cart is empty!");
        checkTrue(shoppingCartPage.checkProductCartUndisplay(productName));
    }

    @Test
    public void TC04_Update_Shopping_Cart() {
        productName = "Lenovo IdeaCentre 600 All-in-One PC";
        homePage.clickToComputerLink();
        productsPage.clickToDesktopsLink();

        productsPage.clickToProductName(productName);
        productDetailPage.clickAddToCartButton();
        productDetailPage.checkMsgAddToCartSuccess("The product has been added to your ");
        homePage.clickToShoppingCartLink();

        shoppingCartPage.inputToQuantityTextbox(productName,"5");
        shoppingCartPage.clickToUpdateShoppingCartButton();
        shoppingCartPage.checkTotalLabel(productName,"$2,500.00");
    }

    @AfterClass
    public void afterClass(){
        cleanBrowserAndDriver();
    }
}
