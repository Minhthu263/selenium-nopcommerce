package com.nopcommerce.demo.pageobject;

import com.nopcommerce.demo.core.BasePage;
import com.nopcommerce.demo.helper.logger.Log;
import com.nopcommerce.demo.pageui.CompareProductsPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CompareProductsPageObject extends BasePage {
    WebDriver driver;

    public CompareProductsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkProductDispalay(String productName) {
        Log.allure("Check Product Compare Display");
        waitForAllElementsVisible(driver, CompareProductsPageUI.LIST_PRODUCT_COMPARE);
        List<WebElement> list = getListWebElements(driver, CompareProductsPageUI.LIST_PRODUCT_COMPARE);
        boolean result = true;

        for (WebElement i : list) {
            if (!i.getText().contains(productName)) {
                result = false;
            }
        }

        return result;
    }

    public void clickToClearListButton() {
        Log.allure("Click to Clear List Button");
        waitForElementClickable(driver, CompareProductsPageUI.CLEAR_LIST_BUTTON);
        clickToElement(driver, CompareProductsPageUI.CLEAR_LIST_BUTTON);
    }

    public boolean checkMsgNoData(String msg) {
        Log.allure("check Msg No data");
        waitForElementVisible(driver, CompareProductsPageUI.NO_DATA_MESSAGE);
        return getTextElement(driver, CompareProductsPageUI.NO_DATA_MESSAGE).contains(msg);
    }

    public boolean checkProductUndisplay(String productName) {
        waitForElementUnDisplay(driver, CompareProductsPageUI.LIST_PRODUCT_COMPARE);
        return isElementUndisplayed(driver, CompareProductsPageUI.LIST_PRODUCT_COMPARE);
    }
}
