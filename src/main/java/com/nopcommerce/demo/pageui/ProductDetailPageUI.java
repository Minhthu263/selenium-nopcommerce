package com.nopcommerce.demo.pageui;

import static com.nopcommerce.demo.core.Locator.xpath;

public class ProductDetailPageUI {
    public static final String ADD_YOUR_REVIEW_LINK = xpath("//a[text()='Add your review']");
    public static final String REVIEW_TITLE_TEXTBOX = xpath("//input[@id='AddProductReview_Title']");
    public static final String REVIEW_TEXT_TEXTBOX = xpath("//textarea[@id='AddProductReview_ReviewText']");
    public static final String SUBMIT_REVIEW_BUTTON = xpath("//button[@name='add-review']");
    public static final String ADD_WISHLIST_MESSAGE = xpath("//div[@class='bar-notification success']//p[@class='content']");
    public static final String ADD_WISHLIST_BUTTON = xpath("//div[@class='product-essential']//button[text()='Add to wishlist']");

}
