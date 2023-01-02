package com.nopcommerce.demo.pageobject;

import com.nopcommerce.demo.core.BasePage;
import com.nopcommerce.demo.helper.logger.Log;
import com.nopcommerce.demo.pageui.RegisterPageUI;
import com.nopcommerce.demo.pageui.SearchPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SearchPageObject extends BasePage {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    public SearchPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToSearchTextbox(String search) {
        Log.allure("Input to Search text box with value: %s", search);
        waitForElementVisible(driver, SearchPageUI.SEARCH_TEXTBOX);
        sendKeyToElement(driver, SearchPageUI.SEARCH_TEXTBOX, search);
    }

    public void clickToSearchButton() {
        Log.allure("Click to Search button");
        waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
        clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
    }

    public void checkMsgSearchError(String message) {
        Log.allure("Check email error");
        waitForElementVisible(driver, SearchPageUI.SEARCH_ERROR_MESSAGE);
        softAssert.assertEquals(getTextElement(driver, SearchPageUI.SEARCH_ERROR_MESSAGE), message);
    }

    public void checkListProductSearched(String productName) {
        Log.allure("Check List Product Searched");
        waitForAllElementsVisible(driver, SearchPageUI.LIST_PRODUCT_SEARCHED);
        List<WebElement> list = getListWebElements(driver, SearchPageUI.LIST_PRODUCT_SEARCHED);
        boolean result = true;

        for (WebElement i : list) {
            if (!i.getText().contains(productName)) {
                result = false;
            }
        }
        softAssert.assertTrue(result);
    }

    public void checkMsgSearchResult(String message) {
        Log.allure("Check text search result: %s", message);
        waitForElementVisible(driver, SearchPageUI.SEARCH_RESULT_MESSAGE);
        softAssert.assertEquals(getTextElement(driver, SearchPageUI.SEARCH_RESULT_MESSAGE), message);
    }

    public void clickToAdvancedSearchCheckbox() {
        Log.allure("Click to Advanced Search Checkbox");
        waitForElementClickable(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
        checkToDefaultCheckboxOrDefaultRadio(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
    }

    public void selectCategoryDropdown(String category) {
        Log.allure("Select Category dropdown");
        waitForElementVisible(driver, SearchPageUI.CATEGORY_DROPDOWN);
        selectItemInDefaultDropdownByText(driver, SearchPageUI.CATEGORY_DROPDOWN, category);
    }

    public void clickToAutomaticallyCheckbox() {
        Log.allure("Click to Automatically Checkbox");
        waitForElementClickable(driver, SearchPageUI.AUTOMATICALLY_CHECKBOX);
        checkToDefaultCheckboxOrDefaultRadio(driver, SearchPageUI.AUTOMATICALLY_CHECKBOX);
    }

    public void selectManufacturerDropdown(String manufacture) {
        Log.allure("Select Manufacturer dropdown");
        waitForElementVisible(driver, SearchPageUI.MANUFACTURER_DROPDOWN);
        selectItemInDefaultDropdownByText(driver, SearchPageUI.MANUFACTURER_DROPDOWN, manufacture);
    }

    public void clickToSearchProductDescriptionsCheckbox() {
        Log.allure("Click to SearchProductDescriptions Checkbox");
        waitForElementClickable(driver, SearchPageUI.SEARCH_PRODUCT_DESCRIPTIONS_CHECKBOX);
        checkToDefaultCheckboxOrDefaultRadio(driver, SearchPageUI.SEARCH_PRODUCT_DESCRIPTIONS_CHECKBOX);
    }
}
