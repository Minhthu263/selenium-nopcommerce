package com.nopcommerce.demo.pageui;

import static com.nopcommerce.demo.core.Locator.xpath;

public class LoginPageUI {
    public static final String EMAIL_TEXTBOX = xpath("//input[@id='Email']");
    public static final String PASSWORD_TEXTBOX = xpath("//input[@id='Password']");
    public static final String LOGIN_BUTTON = xpath("//button[text()='Log in']");
    public static final String EMAIL_ERROR_MESSAGE = xpath("//span[@id='Email-error']");
    public static final String VALIDATION_ERROR_MESSAGE = xpath("//div[@class='message-error validation-summary-errors']//li");

}
