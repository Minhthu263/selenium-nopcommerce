package com.nopcommerce.demo.pageui;

import static com.nopcommerce.demo.core.Locator.xpath;

public class CheckoutPageUI {
    public static final String DYNAMIC_TEXTBOX_BY_ID = xpath("//input[@id='%s']");
    public static final String COUNTRY_DROPDOWN = xpath("//select[@id='BillingNewAddress_CountryId']");
    public static final String DYNAMIC_CONTINUE_BUTTON_BY_ID = xpath("//div[@id='%s']//button[text()='Continue']");

}
