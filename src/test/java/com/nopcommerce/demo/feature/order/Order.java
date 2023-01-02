package com.nopcommerce.demo.feature.order;

import com.nopcommerce.demo.core.BaseTest;
import com.nopcommerce.demo.pageobject.*;
import com.nopcommerce.demo.utils.object.Checkout;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Order extends BaseTest {
    WebDriver driver;
    LoginPageObject loginPage;
    HomePageObject homePage;
    ProductsPageObject productsPage;
    ProductDetailPageObject productDetailPage;
    ShoppingCartPageObject shoppingCartPage;
    CheckoutPageObject checkoutPage;


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
        checkoutPage = PageGeneratorManager.getCheckoutPage(driver);

        email = "thulogin@gmail.com";
        password = "123456";
        loginPage.inputToEmailTextbox(email);
        loginPage.inputToPasswordTextbox(password);
        loginPage.clickToLoginButton();
        productName = "Apple MacBook Pro 13-inch";

    }

    @Test
    public void TC05_Checkout_Order_PaymentByCheque() {
        homePage.clickToComputerLink();
        productsPage.clickToNotebookLink();

        productsPage.clickToProductName(productName);
        productDetailPage.clickAddToCartButton();
        productDetailPage.checkMsgAddToCartSuccess("The product has been added to your ");
        homePage.clickToShoppingCartLink();

        shoppingCartPage.clickToEstimateShippingButton();
        shoppingCartPage.selectCountryDropdown("Viet Nam");
        shoppingCartPage.inputToZipTextbox("550000");
        shoppingCartPage.waitLoadingUndisplay();
        shoppingCartPage.clickToApllyButton();
        shoppingCartPage.clickToIAgreeCheckbox();
        shoppingCartPage.clickToCheckoutButton();

        Checkout c = new Checkout();
        c.setFirstName("Minh");
        c.setLastName("Thu");
        c.setEmail("thuthu@g.vn");
        c.setCountry("Viet Nam");
        c.setCity("HN");
        c.setAndress1("Hà Đông");
        c.setAndress2("Hoàn Kiếm");
        c.setZip("123");
        c.setPhoneNumber("0987654321");

        checkoutPage.inputToTextboxById("BillingNewAddress_FirstName", c.getFirstName());
        checkoutPage.inputToTextboxById("BillingNewAddress_LastName", c.getLastName());
        checkoutPage.inputToTextboxById("BillingNewAddress_Email", c.getEmail());
        checkoutPage.selectCountryDropdown(c.getCountry());
        checkoutPage.inputToTextboxById("BillingNewAddress_City", c.getCity());
        checkoutPage.inputToTextboxById("BillingNewAddress_Address1", c.getAndress1());
        checkoutPage.inputToTextboxById("BillingNewAddress_Address2", c.getAndress2());
        checkoutPage.inputToTextboxById("BillingNewAddress_ZipPostalCode", c.getZip());
        checkoutPage.inputToTextboxById("BillingNewAddress_PhoneNumber", c.getPhoneNumber());

        checkoutPage.clickToContinueButtonById("checkout-step-billing");
        checkoutPage.clickToContinueButtonById("checkout-step-shipping-method");
        checkoutPage.clickToContinueButtonById("checkout-step-payment-method");
        checkoutPage.clickToContinueButtonById("checkout-step-payment-info");

    }
}
