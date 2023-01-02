package com.nopcommerce.demo.pageobject;

import com.nopcommerce.demo.core.BasePage;
import com.nopcommerce.demo.helper.logger.Log;
import com.nopcommerce.demo.pageui.ShoppingCartPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ShoppingCartPageObject extends BasePage{
    WebDriver driver;

    public ShoppingCartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkProductCartDisplay(String productName) {
        Log.allure("Check Product Cart Display");
        waitForAllElementsVisible(driver, ShoppingCartPageUI.LIST_PRODUCT_CART);
        List<WebElement> list = getListWebElements(driver, ShoppingCartPageUI.LIST_PRODUCT_CART);
        boolean result = true;

        for (WebElement i : list) {
            if (!i.getText().contains(productName)) {
                result = false;
            }
        }

        return result;
    }

    public void checkProductInShoppingCart(String s) {

    }

    public void clickToEditProductButton(String productName) {
        Log.allure("Click to Edit Product button");
        waitForElementVisible(driver, ShoppingCartPageUI.EDIT_LINK);
        clickToElement(driver, ShoppingCartPageUI.EDIT_LINK);
    }

    public void clickToRemoveButton(String productName) {
        Log.allure("Click to Remove button");
        waitForElementVisible(driver, ShoppingCartPageUI.REMOVE_BUTTON,productName);
        clickToElement(driver, ShoppingCartPageUI.REMOVE_BUTTON,productName);
    }

    public void chechMsg(String msg) {
        Log.allure("Verify msg");
        waitForElementVisible(driver, ShoppingCartPageUI.NO_DATA_MESSAGE);
        Assert.assertEquals(getTextElement(driver, ShoppingCartPageUI.NO_DATA_MESSAGE), msg);
    }

    public boolean checkProductCartUndisplay(String productName) {
        Log.allure("Check Product Cart Display");
//        waitForAllElementsVisible(driver, ShoppingCartPageUI.LIST_PRODUCT_CART);
        List<WebElement> list = getListWebElements(driver, ShoppingCartPageUI.LIST_PRODUCT_CART);

        if(list.size() == 0 ){
            return true;
        }
        else{
            return false;
        }
    }

    public void inputToQuantityTextbox(String productName, String quantity) {
        Log.allure("input To Quantity Textbox");
        waitForElementVisible(driver, ShoppingCartPageUI.QUANTITY_TEXTBOX,productName);
        sendKeyToElement(driver,ShoppingCartPageUI.QUANTITY_TEXTBOX,quantity,productName);
    }

    public void clickToUpdateShoppingCartButton() {
        Log.allure("click To Update Shopping Cart Button");
        waitForElementClickable(driver, ShoppingCartPageUI.UPDATE_CART_BUTTON);
        clickToElement(driver, ShoppingCartPageUI.UPDATE_CART_BUTTON);
    }

    public boolean checkTotalLabel(String productName,String total) {
        Log.allure("check total");
        waitForElementVisible(driver, ShoppingCartPageUI.TOTAL_LABEL,productName);
        return getTextElement(driver, ShoppingCartPageUI.TOTAL_LABEL,productName).contains(total);
    }

    public void clickToEstimateShippingButton() {
        Log.allure("click To Estimate Shipping Button");
        waitForElementClickable(driver, ShoppingCartPageUI.ESTIMATE_SHIPPING_BUTTON);
        clickToElement(driver, ShoppingCartPageUI.ESTIMATE_SHIPPING_BUTTON);
    }

    public void selectCountryDropdown(String country) {
        Log.allure("Select country dropdown");
        waitForElementVisible(driver, ShoppingCartPageUI.COUNTRY_DROPDOWN);
        selectItemInDefaultDropdownByText(driver, ShoppingCartPageUI.COUNTRY_DROPDOWN, country);
    }

    public void inputToZipTextbox(String zip) {
        Log.allure("input To Zip Textbox");
        waitForElementVisible(driver, ShoppingCartPageUI.ZIP_TEXTBOX);
        sendKeyToElement(driver,ShoppingCartPageUI.ZIP_TEXTBOX,zip);
    }

    public void clickToApllyButton() {
        Log.allure("click To Apply Button");
        waitForElementClickable(driver, ShoppingCartPageUI.APPLY_BUTTON);
        clickToElement(driver, ShoppingCartPageUI.APPLY_BUTTON);
    }

    public void clickToIAgreeCheckbox() {
        Log.allure("click To I Agree Button");
        waitForElementClickable(driver, ShoppingCartPageUI.I_AGREE_CHECKBOX);
        clickToElement(driver, ShoppingCartPageUI.I_AGREE_CHECKBOX);
    }

    public void clickToCheckoutButton() {
        Log.allure("click To Checkout Button");
        waitForElementClickable(driver, ShoppingCartPageUI.CHECKOUT_BUTTON);
        clickToElement(driver, ShoppingCartPageUI.CHECKOUT_BUTTON);
    }

    public void waitLoadingUndisplay() {
        waitForElementUnDisplay(driver, ShoppingCartPageUI.LOADING_ICON);
    }
}
