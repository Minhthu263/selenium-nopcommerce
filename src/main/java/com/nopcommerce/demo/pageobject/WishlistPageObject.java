package com.nopcommerce.demo.pageobject;

import com.nopcommerce.demo.core.BasePage;
import com.nopcommerce.demo.helper.logger.Log;
import com.nopcommerce.demo.pageui.ProductsPageUI;
import com.nopcommerce.demo.pageui.SearchPageUI;
import com.nopcommerce.demo.pageui.WishlistPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class WishlistPageObject extends BasePage {
    WebDriver driver;

    public WishlistPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkProductWishlistDisplay(String productName) {
        Log.allure("Check Product In Wishlist");
        waitForAllElementsVisible(driver, WishlistPageUI.LIST_PRODUCT_WISHLIST);
        List<WebElement> list = getListWebElements(driver, WishlistPageUI.LIST_PRODUCT_WISHLIST);
        boolean result = true;

        for (WebElement i : list) {
            if (!i.getText().contains(productName)) {
                result = false;
            }
        }

        return result;
    }

    public void clickToUrlSharingLink() {
        Log.allure("click To Url Sharing Link");
        waitForElementVisible(driver, WishlistPageUI.URL_SHARING_LINK);
        clickToElement(driver, WishlistPageUI.URL_SHARING_LINK);
    }

    public void clickToAddToCardCheckbox(String productName) {
        Log.allure("click Add To Card Checkbox");
        waitForElementVisible(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX,productName);
        clickToElement(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX,productName);
    }

    public void clickToAddToCardButton() {
        Log.allure("click Add To Card Button");
        waitForElementVisible(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
    }

    public boolean checkProductWishlistUnDisplay(String productName) {
        waitForElementUnDisplay(driver, WishlistPageUI.LIST_PRODUCT_WISHLIST);
        return isElementUndisplayed(driver, WishlistPageUI.LIST_PRODUCT_WISHLIST);
    }

    public void clickToRemoveCheckbox(String productName) {
        Log.allure("click To Remove Checkbox");
        waitForElementVisible(driver, WishlistPageUI.REMOVE_CHECKBOX,productName);
        clickToElement(driver, WishlistPageUI.REMOVE_CHECKBOX,productName);
    }
}
