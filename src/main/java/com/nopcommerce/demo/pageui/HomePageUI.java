package com.nopcommerce.demo.pageui;

import static com.nopcommerce.demo.core.Locator.xpath;

public class HomePageUI {
    public static final String REGISTER_LINK = xpath("//a[text()='Register']");
    public static final String LOGIN_LINK = xpath("//a[@class='ico-login']");
    public static final String MYACCOUNT_LINK = xpath("//a[@class='ico-account']");
    public static final String WISHLIST_LINK = xpath("//a[@class='ico-wishlist']");
    public static final String LOGOUT_LINK = xpath("//a[@class='ico-logout']");
    public static final String COMPUTER_LINK = xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]");
    public static final String SEARCH_LINK_IN_FOOTER = xpath("//div[@class='footer-block customer-service']//a[text()='Search']");
    public static final String COMPARE_PRODUCTS_LIST_LINK_IN_FOOTER = xpath("//div[@class='footer-block customer-service']//a[text()='Compare products list']");
    public static final String RECENTLY_VIEWED_PRODUCTS_LINK_IN_FOOTER = xpath("//div[@class='footer-block customer-service']//a[text()='Recently viewed products']");
    public static final String SHOPPING_CART_LINK_IN_FOOTER = xpath("//div[@class='footer-block my-account']//a[text()='Shopping cart']");
}
