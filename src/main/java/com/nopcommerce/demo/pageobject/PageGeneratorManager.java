package com.nopcommerce.demo.pageobject;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }

    public static RegisterPageObject getRegisterPage(WebDriver driver) {
        return new RegisterPageObject(driver);
    }

    public static CustomerInforPageObject getCustomerInforPage(WebDriver driver) {
        return new CustomerInforPageObject(driver);
    }

    public static ProductsPageObject getProductsPage(WebDriver driver) {
        return new ProductsPageObject(driver);
    }

    public static ProductDetailPageObject getProductDetailPage(WebDriver driver) {
        return new ProductDetailPageObject(driver);
    }

    public static SearchPageObject getSearchPage(WebDriver driver) {
        return new SearchPageObject(driver);
    }

    public static WishlistPageObject getWishlistPage(WebDriver driver) {
        return new WishlistPageObject(driver);
    }
    public static ShoppingCartPageObject getShoppingCartPage(WebDriver driver) {
        return new ShoppingCartPageObject(driver);
    }
    public static CompareProductsPageObject getCompareProductsPage(WebDriver driver) {
        return new CompareProductsPageObject(driver);
    }
    public static CheckoutPageObject getCheckoutPage(WebDriver driver) {
        return new CheckoutPageObject(driver);
    }
}
