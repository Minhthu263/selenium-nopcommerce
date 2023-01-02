package com.nopcommerce.demo.pageobject;

import com.nopcommerce.demo.core.BasePage;
import com.nopcommerce.demo.helper.logger.Log;
import com.nopcommerce.demo.pageui.*;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class ProductDetailPageObject extends BasePage {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    public ProductDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToAddYourReviewButton() {
        Log.allure("Click to AddYourReview Button");
        waitForElementClickable(driver, ProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
        clickToElement(driver, ProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
    }

    public void inputToReviewTitleTextbox(String reviewTitle) {
        Log.allure("Input to ReviewTitle text box with value: %s", reviewTitle);
        waitForElementVisible(driver, ProductDetailPageUI.REVIEW_TITLE_TEXTBOX);
        sendKeyToElement(driver, ProductDetailPageUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
    }

    public void inputToReviewTextTextbox(String reviewText) {
        Log.allure("Input to ReviewText text box with value: %s", reviewText);
        waitForElementVisible(driver, ProductDetailPageUI.REVIEW_TEXT_TEXTBOX);
        sendKeyToElement(driver, ProductDetailPageUI.REVIEW_TEXT_TEXTBOX, reviewText);
    }

    public void ClickToRatingRadioButton() {
//        Log.allure("Click to RatingRadioButton");
//        waitForElementClickable(driver, ProductDetailPageUI.);
//        clickToElement(driver, ProductDetailPageUI.DYNAMIC_PRODUCT_NAME_LINK);
    }

    public void ClickToSubmitReviewButton() {
        Log.allure("Click to Review Button");
        waitForElementClickable(driver, ProductDetailPageUI.SUBMIT_REVIEW_BUTTON);
        clickToElement(driver, ProductDetailPageUI.SUBMIT_REVIEW_BUTTON);
    }

    public void clickToAddToWishlistButton() {
        Log.allure("Click to Add Wishlist Button");
        waitForElementClickable(driver, ProductDetailPageUI.ADD_WISHLIST_BUTTON);
        clickToElement(driver, ProductDetailPageUI.ADD_WISHLIST_BUTTON);
    }

    public boolean checkAddWishlistMsgSuccess(String message) {
        Log.allure("check ReviewText Reviewed %s", message);
        waitForElementVisible(driver, ProductDetailPageUI.ADD_WISHLIST_MESSAGE);
        return isElementDisplay(driver, ProductDetailPageUI.ADD_WISHLIST_MESSAGE);
    }

    public void clickToCloseMsgButton() {
        waitForElementVisible(driver, ProductsPageUI.ADD_WISHLIST_MESSAGE_BUTTON);
        clickToElement(driver, ProductsPageUI.ADD_WISHLIST_MESSAGE_BUTTON);
    }

    public void selectProcessorDropdown(String processorName) {
        Log.allure("Select Processor dropdown");
        waitForElementVisible(driver, ProductsPageUI.PROCESSOR_DROPDOWN);
        selectItemInDefaultDropdownByText(driver, ProductsPageUI.PROCESSOR_DROPDOWN, processorName);
    }

    public void selectRamDropdown(String ramName) {
        Log.allure("Select Ram dropdown");
        waitForElementVisible(driver, ProductsPageUI.RAM_DROPDOWN);
        selectItemInDefaultDropdownByText(driver, ProductsPageUI.RAM_DROPDOWN, ramName);
    }

    public void clickHDDRadioButton(String hddName) {
        Log.allure("Click to HDD button");
        waitForElementVisible(driver, ProductsPageUI.HDD_RADIOBUTTON,hddName);
        clickToElement(driver, ProductsPageUI.HDD_RADIOBUTTON,hddName);
    }

    public void clickOSRadioButton(String osName) {
        Log.allure("Click to OS button");
        waitForElementVisible(driver, ProductsPageUI.OS_RADIOBUTTON,osName);
        clickToElement(driver, ProductsPageUI.OS_RADIOBUTTON,osName);
    }

    public void clickSoftwareCheckbox(String softwareName) {
        Log.allure("Click to Software Checkbox");
        waitForElementClickable(driver, ProductsPageUI.SOFTWARE_CHECKBOX, softwareName);
        checkToDefaultCheckboxOrDefaultRadio(driver, ProductsPageUI.SOFTWARE_CHECKBOX, softwareName);
    }

    public void clickAddToCartButton() {
        Log.allure("Click to Add to cart button");
        waitForElementVisible(driver, ProductsPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, ProductsPageUI.ADD_TO_CART_BUTTON);
    }

    public boolean checkMsgAddToCartSuccess(String msg) {
        Log.allure("check Msg add to cart");
        waitForElementVisible(driver, ProductsPageUI.ADDTOCART_SUCCESS_MESSAGE);
        return getTextElement(driver, ProductsPageUI.ADDTOCART_SUCCESS_MESSAGE).contains(msg);
    }

    public void unClickSoftwareCheckbox(String softwareName) {
        Log.allure("UnClick to Software Checkbox");
        waitForElementClickable(driver, ProductsPageUI.SOFTWARE_CHECKBOX, softwareName);
        uncheckToDefaultCheckbox(driver, ProductsPageUI.SOFTWARE_CHECKBOX, softwareName);
    }

    public void setQuantityTextbox(String quantity) {
        Log.allure("Input to Quantity text box with value: %s", quantity);
        waitForElementVisible(driver, ProductsPageUI.QUANTITY_TEXTBOX);
        sendKeyToElement(driver, ProductsPageUI.QUANTITY_TEXTBOX, quantity);
    }
}
