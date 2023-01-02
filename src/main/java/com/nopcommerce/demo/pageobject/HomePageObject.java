package com.nopcommerce.demo.pageobject;

import com.nopcommerce.demo.core.BasePage;
import com.nopcommerce.demo.helper.logger.Log;
import com.nopcommerce.demo.pageui.HomePageUI;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class HomePageObject extends BasePage {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToRegisterLink() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
    }

    public void clickToLogInLink() {
        Log.allure("Click to login link");
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
    }

    public boolean isMyAccountLinkDisplayed() {
        Log.allure("Login: Verify MyAccount Link dispalyed");
        waitForElementVisible(driver, HomePageUI.MYACCOUNT_LINK);
        return isElementDisplay(driver, HomePageUI.MYACCOUNT_LINK);
    }

    public boolean isLogoutLinkDisplayed() {
        Log.allure("Login: Verify Logout Link dispalyed");
        waitForElementVisible(driver, HomePageUI.LOGOUT_LINK);
        return isElementDisplay(driver, HomePageUI.LOGOUT_LINK);
    }

    public void clickToMyAccountLink() {
        waitForElementClickable(driver, HomePageUI.MYACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MYACCOUNT_LINK);
    }

    public Boolean isRegisterLinkUnDisplayed() {
        waitForElementUnDisplay(driver, HomePageUI.REGISTER_LINK);
        return isElementUndisplayed(driver, HomePageUI.REGISTER_LINK);
    }

    public boolean isLoginLinkDisplayed() {
        waitForElementVisible(driver, HomePageUI.LOGIN_LINK);
        return isElementDisplay(driver, HomePageUI.LOGIN_LINK);
    }

    public void checkMyAccountLinkDisplayed() {
        Log.allure("Login: Verify MyAccount Link dispalyed");
        waitForElementVisible(driver, HomePageUI.MYACCOUNT_LINK);
        softAssert.assertTrue(isElementDisplay(driver, HomePageUI.MYACCOUNT_LINK));
    }

    public void clickToLogOutLink() {
        Log.allure("Click to logout link");
        waitForElementClickable(driver, HomePageUI.LOGOUT_LINK);
        clickToElement(driver, HomePageUI.LOGOUT_LINK);
    }

    public void clickToComputerLink() {
        Log.allure("Click to Computer link");
        waitForElementClickable(driver, HomePageUI.COMPUTER_LINK);
        clickToElement(driver, HomePageUI.COMPUTER_LINK);
    }

    public void clickToSearchButton() {
        Log.allure("Click to Search Link in footer");
        waitForElementClickable(driver, HomePageUI.SEARCH_LINK_IN_FOOTER);
        clickToElement(driver, HomePageUI.SEARCH_LINK_IN_FOOTER);
    }

    public void clickToWishlistLink() {
        waitForElementClickable(driver, HomePageUI.WISHLIST_LINK);
        clickToElement(driver, HomePageUI.WISHLIST_LINK);
    }

    public void clickToCompareProductsListLink() {
        Log.allure("Click Compare Products List Link in footer");
        waitForElementClickable(driver, HomePageUI.COMPARE_PRODUCTS_LIST_LINK_IN_FOOTER);
        clickToElement(driver, HomePageUI.COMPARE_PRODUCTS_LIST_LINK_IN_FOOTER);
    }

    public void clickToRecentlyViewedProductsListLink() {
        Log.allure("Click Recently View Products List Link in footer");
        waitForElementClickable(driver, HomePageUI.RECENTLY_VIEWED_PRODUCTS_LINK_IN_FOOTER);
        clickToElement(driver, HomePageUI.RECENTLY_VIEWED_PRODUCTS_LINK_IN_FOOTER);
    }

    public void clickToShoppingCartLink() {
        Log.allure("Click Shopping Cart Link");
        waitForElementClickable(driver, HomePageUI.SHOPPING_CART_LINK_IN_FOOTER);
        clickToElement(driver, HomePageUI.SHOPPING_CART_LINK_IN_FOOTER);
    }
}
