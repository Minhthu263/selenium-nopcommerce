package com.nopcommerce.demo.pageobject;

import com.nopcommerce.demo.core.BasePage;
import com.nopcommerce.demo.helper.logger.Log;
import com.nopcommerce.demo.pageui.ProductsPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ProductsPageObject extends BasePage {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    public ProductsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToProductName(String productName) {
        Log.allure("Click to Product Name : %s", productName);
        waitForElementClickable(driver, ProductsPageUI.DYNAMIC_PRODUCT_NAME_LINK, productName);
        clickToElement(driver, ProductsPageUI.DYNAMIC_PRODUCT_NAME_LINK, productName);
    }

    public void clickToNotebookLink() {
        Log.allure("Click to Notebook Link");
        waitForElementClickable(driver, ProductsPageUI.PRODUCT_NOTEBOOKS_LINK);
        clickToElement(driver, ProductsPageUI.PRODUCT_NOTEBOOKS_LINK);
    }

    public void selectSortByDropdown(String sort) {
        Log.allure("Select sort dropdown");
        waitForElementVisible(driver, ProductsPageUI.SORT_BY_DROPDOWN);
        selectItemInDefaultDropdownByText(driver, ProductsPageUI.SORT_BY_DROPDOWN, sort);
    }

    public void selectDisplayDropdown(String display) {
        Log.allure("Select display dropdown");
        waitForElementVisible(driver, ProductsPageUI.DISPLAY_BY_DROPDOWN);
        selectItemInDefaultDropdownByText(driver, ProductsPageUI.DISPLAY_BY_DROPDOWN, display);
    }

    public boolean checkListProductDisplay(int productNumber) {
        Log.allure("Check List Product Display");
        waitForAllElementsVisible(driver, ProductsPageUI.LIST_PRODUCT_DISPLAY);
        List<WebElement> list = getListWebElements(driver, ProductsPageUI.LIST_PRODUCT_DISPLAY);
        boolean result = true;

        if (list.size() <= productNumber){
            result = true;
        }
        return result;
    }

    public boolean checkNextIconPage() {
        Log.allure("Check next icon page Display");
        waitForElementVisible(driver,ProductsPageUI.CURRENT_PAGE);

        if (getTextElement(driver, ProductsPageUI.CURRENT_PAGE) == "1"){
            waitForAllElementsVisible(driver, ProductsPageUI.NEXT_PAGE_LINK);
            return isElementDisplay(driver, ProductsPageUI.NEXT_PAGE_LINK);
        }
        else {
            return false;
        }
    }

    public void clickToNextPage() {
        Log.allure("Click to next page");
        waitForElementVisible(driver, ProductsPageUI.NEXT_PAGE_LINK);
        clickToElement(driver, ProductsPageUI.NEXT_PAGE_LINK);
    }

    public boolean checkPreviousIconPage() {
        Log.allure("Check Previous icon page Display");
        waitForElementVisible(driver,ProductsPageUI.CURRENT_PAGE);

        if (getTextElement(driver, ProductsPageUI.CURRENT_PAGE) == "2"){
            waitForAllElementsVisible(driver, ProductsPageUI.PREVIOUS_PAGE_LINK);
            return isElementDisplay(driver, ProductsPageUI.PREVIOUS_PAGE_LINK);
        }
        else {
            return false;
        }
    }

    public boolean checkToPagingUndisplay() {
        waitForElementUnDisplay(driver, ProductsPageUI.PAGING);
        return isElementUndisplayed(driver, ProductsPageUI.PAGING);
    }


    public void clickToDesktopsLink() {
        Log.allure("Click to Desktops Link");
        waitForElementClickable(driver, ProductsPageUI.PRODUCT_DESKTOPS_LINK);
        clickToElement(driver, ProductsPageUI.PRODUCT_DESKTOPS_LINK);
    }

    public void clickToAddToCompareListButton(String productName) {
        Log.allure("Click Add To Compare List Button");
        waitForElementClickable(driver, ProductsPageUI.ADD_TO_COMPARE_LIST_BUTTON, productName);
        clickToElement(driver, ProductsPageUI.ADD_TO_COMPARE_LIST_BUTTON, productName);
    }

    public boolean checkMsgAddToCompareListSuccess(String msg) {
        Log.allure("check Msg Add To Compare List Success");
        waitForElementVisible(driver, ProductsPageUI.ADDTOCART_SUCCESS_MESSAGE);
        return getTextElement(driver, ProductsPageUI.ADDTOCART_SUCCESS_MESSAGE).contains(msg);
    }

    public void backToPreviousPage() {
        forwawrdToPage(driver);
    }

    public boolean checkListProductRecentlyViewedDisplay(String productName3, String productName4, String productName5) {
        Log.allure("Check List Product Display");
        waitForAllElementsVisible(driver, ProductsPageUI.LIST_PRODUCT_DISPLAY);
        List<WebElement> list = getListWebElements(driver, ProductsPageUI.LIST_PRODUCT_DISPLAY);
        boolean result = true;

        if (list.size() == 3) {
            for (WebElement i : list) {
                result = i.getText().contains(productName3) && i.getText().contains(productName4) && i.getText().contains(productName5);
            }
        } else {
            result = false;
        }
        return result;
    }
}
