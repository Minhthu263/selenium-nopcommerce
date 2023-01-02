package com.nopcommerce.demo.pageui;

import static com.nopcommerce.demo.core.Locator.xpath;

public class WishlistPageUI {
    public static final String LIST_PRODUCT_WISHLIST = xpath("//a[@class='product-name']");
    public static final String URL_SHARING_LINK = xpath("//a[@class='share-link']");
    public static final String ADD_TO_CART_CHECKBOX = xpath(
            "//a[@class='product-name' and contains(text(),'%s')]//preceding::td[@class='add-to-cart']/input[@name='addtocart']");
    public static final String ADD_TO_CART_BUTTON = xpath("//button[@name='addtocartbutton']");
    public static final String REMOVE_CHECKBOX = xpath(
            "//a[@class='product-name' and contains(text(),'%s')]//following::td[@class='remove-from-cart']//button");

}
