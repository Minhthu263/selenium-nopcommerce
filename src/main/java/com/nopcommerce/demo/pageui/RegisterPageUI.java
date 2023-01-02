package com.nopcommerce.demo.pageui;

import static com.nopcommerce.demo.core.Locator.xpath;

public class RegisterPageUI {
    public static final String GENDER_FEAMALE_RADIO = xpath("//input[@id='gender-female']");
    public static final String FIRSTNAME_TEXTBOX =xpath("//input[@id='FirstName']");
    public static final String LASTNAME_TEXTBOX =xpath("//input[@id='LastName']");
    public static final String DAY_DROPDOWN =xpath("//select[@name='DateOfBirthDay']");
    public static final String MONTH_DROPDOWN =xpath("//select[@name='DateOfBirthMonth']");
    public static final String YEAR_DROPDOWN =xpath("//select[@name='DateOfBirthYear']");
    public static final String EMAIL_TEXTBOX =xpath("//input[@id='Email']");
    public static final String PASSWORD_TEXTBOX =xpath("//input[@id='Password']");
    public static final String CONFIRM_PASSWORD_TEXTBOX =xpath("//input[@id='ConfirmPassword']");
    public static final String REGISTER_BUTTON =xpath("//button[@id='register-button']");
    public static final String REGISTER_SUCCESS_MESSAGE =xpath("//div[@class='result']");
    public static final String LOGOUT_LINK =xpath("//a[@class='ico-logout']");
    public static final String VALIDATION_ERROR_MESSAGE =xpath("//div[@class='message-error validation-summary-errors']//li");
    public static final String PASSWORD_ERROR_MESSAGE =xpath("//span[@id='Password-error']//li");
    public static final String CONFIRM_PASSWORD_ERROR_MESSAGE =xpath("//span[@id='ConfirmPassword-error']");
    public static final String DYNAMIC_ERROR_MESSAGE =xpath("//span[@id='%s']");

}
