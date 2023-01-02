package com.nopcommerce.demo.pageui;

import static com.nopcommerce.demo.core.Locator.xpath;

public class SearchPageUI {
    public static final String SEARCH_TEXTBOX = xpath("//input[@class='search-text']");
    public static final String SEARCH_BUTTON = xpath("//button[@class='button-1 search-button']");
    public static final String SEARCH_ERROR_MESSAGE = xpath("//div[@class='warning']");
    public static final String SEARCH_RESULT_MESSAGE = xpath("//div[@class='no-result']");
    public static final String LIST_PRODUCT_SEARCHED = xpath("//div[@class='details']//a");
    public static final String ADVANCED_SEARCH_CHECKBOX = xpath("//input[@id='advs']");
    public static final String CATEGORY_DROPDOWN = xpath("//select[@id='cid']");
    public static final String AUTOMATICALLY_CHECKBOX = xpath("//input[@id='isc']");
    public static final String MANUFACTURER_DROPDOWN = xpath("//select[@id='mid']");
    public static final String SEARCH_PRODUCT_DESCRIPTIONS_CHECKBOX = xpath("//input[@id='sid']");


}
