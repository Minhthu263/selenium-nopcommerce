package com.nopcommerce.demo.pageobject;

import com.nopcommerce.demo.core.BasePage;
import com.nopcommerce.demo.helper.logger.Log;
import com.nopcommerce.demo.pageui.CheckoutPageUI;
import com.nopcommerce.demo.pageui.RegisterPageUI;
import com.nopcommerce.demo.pageui.ShoppingCartPageUI;
import org.openqa.selenium.WebDriver;

public class CheckoutPageObject extends BasePage {
    WebDriver driver;

    public CheckoutPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToTextboxById(String id, String value) {
        Log.allure("input Textbox with : %s", value);
        waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_TEXTBOX_BY_ID, id);
        sendKeyToElement(driver,CheckoutPageUI.DYNAMIC_TEXTBOX_BY_ID,value, id);
    }

    public void selectCountryDropdown(String country) {
        Log.allure("Select country dropdown");
        waitForElementVisible(driver, CheckoutPageUI.COUNTRY_DROPDOWN);
        selectItemInDefaultDropdownByText(driver, CheckoutPageUI.COUNTRY_DROPDOWN, country);
    }

    public void clickToContinueButtonById(String id) {
        Log.allure("click To Continue Button");
        waitForElementClickable(driver, CheckoutPageUI.DYNAMIC_CONTINUE_BUTTON_BY_ID,id);
        clickToElement(driver, CheckoutPageUI.DYNAMIC_CONTINUE_BUTTON_BY_ID, id);
    }
}
