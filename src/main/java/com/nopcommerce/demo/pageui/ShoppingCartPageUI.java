package com.nopcommerce.demo.pageui;

import static com.nopcommerce.demo.core.Locator.xpath;

public class ShoppingCartPageUI {
    public static final String LIST_PRODUCT_CART = xpath("//a[@class='product-name']");
    public static final String EDIT_LINK = xpath("//a[@class='product-name']//following-sibling::div[@class='edit-item']/a");
    public static final String NO_DATA_MESSAGE = xpath("//div[@class='no-data']");
    public static final String REMOVE_BUTTON = xpath("//a[text()='%s']/parent::td/following-sibling::td[@class='remove-from-cart']/button");
    public static final String QUANTITY_TEXTBOX = xpath("//a[text()='%s']/parent::td/following-sibling::td[@class='quantity']//input");
    public static final String UPDATE_CART_BUTTON = xpath("//div[@class='cart-options']//button[@name='updatecart']");
    public static final String TOTAL_LABEL = xpath("//a[text()='%s']/parent::td/following-sibling::td[@class='subtotal']/span");
    public static final String ESTIMATE_SHIPPING_BUTTON = xpath("//a[@id='open-estimate-shipping-popup']");
    public static final String COUNTRY_DROPDOWN = xpath("//select[@id='CountryId']");
    public static final String ZIP_TEXTBOX = xpath("//input[@id='ZipPostalCode']");
    public static final String APPLY_BUTTON = xpath("//button[text()='Apply']");
    public static final String I_AGREE_CHECKBOX = xpath("//input[@id='termsofservice']");
    public static final String CHECKOUT_BUTTON = xpath("//button[@id='checkout']");
    public static final String LOADING_ICON = xpath("//div[@class='shipping-options-loading']");

}
