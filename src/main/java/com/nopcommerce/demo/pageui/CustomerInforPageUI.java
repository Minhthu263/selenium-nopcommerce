package com.nopcommerce.demo.pageui;

import static com.nopcommerce.demo.core.Locator.xpath;

public class CustomerInforPageUI {
    public static final String GENDER_FEAMALE_RADIO = xpath("//input[@id='gender-female']");
    //    public static final String FIRSTNAME_TEXTBOX =xpath("//input[@id='FirstName']");
//    public static final String LASTNAME_TEXTBOX =xpath("//input[@id='LastName']");
    public static final String DAY_DROPDOWN = xpath("//select[@name='DateOfBirthDay']");
    public static final String MONTH_DROPDOWN = xpath("//select[@name='DateOfBirthMonth']");
    public static final String YEAR_DROPDOWN = xpath("//select[@name='DateOfBirthYear']");
    //    public static final String EMAIL_TEXTBOX =xpath("//input[@id='Email']");
//    public static final String COMPANY_NAME_TEXTBOX =xpath("//input[@id='Company']");
    public static final String SAVE_BUTTON = xpath("//button[text()='Save']");
    public static final String DYNAMIC_TEXTBOX = xpath("//input[@id='%s']");
    public static final String DYNAMIC_LINK_IN_LISTBOX = xpath("//div[@class='listbox']//a[contains(text(),'%s')]");
    public static final String ADD_NEW_BUTTON = xpath("//button[text()='Add new']");
    public static final String COUNTRY_DROPDOWN = xpath("//select[@id='Address_CountryId']");
    public static final String STATE_DROPDOWN = xpath("//select[@id='Address_StateProvinceId']");
    public static final String DYNAMIC_ADDRESSES_TEXT = xpath("//div[@class='address-list']//li[@class='%s']");
    public static final String CHANGE_PASSWORD_BUTTON = xpath("//button[text()='Change password']");
    public static final String CHANGEPASSWORD_SUCCESS_MESSAGE = xpath("//div[@class='bar-notification success']//p[@class='content']");
    public static final String CHANGEPASSWORD_SUCCESS_BUTTON = xpath("//div[@class='bar-notification success']//span[@class='close']");
    public static final String PRODUCT_REVIEWED_LINK = xpath("//a[text()='%s']");
    public static final String DYNAMIC_REVIEW_TEXT_LABEL = xpath("//a[text()='%s']//ancestor::div[@class='review-content']//div[@class='review-text']");
    public static final String DYNAMIC_REVIEW_TITLE_LABEL = xpath("//a[text()='%s']//ancestor::div[@class='product-review-item']//strong");

}
