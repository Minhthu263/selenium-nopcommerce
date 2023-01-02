package com.nopcommerce.demo.pageui;

import static com.nopcommerce.demo.core.Locator.xpath;

public class ProductsPageUI {
    public static final String PRODUCT_NOTEBOOKS_LINK = xpath("//a[text()=' Notebooks ']");
    public static final String PRODUCT_DESKTOPS_LINK = xpath("//a[text()=' Desktops ']");
    public static final String DYNAMIC_PRODUCT_NAME_LINK = xpath("//div[@class='page-body']//a[contains(text(),'%s')]");
    public static final String SORT_BY_DROPDOWN = xpath("//select[@id='products-orderby']");
    public static final String DISPLAY_BY_DROPDOWN = xpath("//select[@id='products-pagesize']");
    public static final String LIST_PRODUCT_DISPLAY = xpath("//div[@class='details']//a");
    public static final String CURRENT_PAGE = xpath("//li[@class='current-page']/span");
    public static final String NEXT_PAGE_LINK = xpath("//li[@class='next-page']/a");
    public static final String PREVIOUS_PAGE_LINK = xpath("//li[@class='previous-page']");
    public static final String PAGING = xpath("//div[@class='pager']");
    public static final String ADD_WISHLIST_MESSAGE_BUTTON = xpath("//div[@class='bar-notification success']//span[@class='close']");
    public static final String ADD_TO_COMPARE_LIST_BUTTON = xpath(
            "//a[text()='%s']//parent::h2//following-sibling::div[@class='add-info']//button[text()='Add to compare list']");
    public static final String ADDTOCART_SUCCESS_MESSAGE = xpath("//div[@class='bar-notification success']//p[@class='content']");
    public static final String PROCESSOR_DROPDOWN = xpath("//select[@name='product_attribute_1']");
    public static final String RAM_DROPDOWN = xpath("//select[@name='product_attribute_2']");
    public static final String HDD_RADIOBUTTON = xpath("//label[text()='%s']//preceding-sibling::input[@name='product_attribute_3']");
    public static final String OS_RADIOBUTTON = xpath("//label[text()='%s']//preceding-sibling::input[@name='product_attribute_4']");
    public static final String SOFTWARE_CHECKBOX = xpath("//label[text()='%s']//preceding-sibling::input[@name='product_attribute_5']");
    public static final String ADD_TO_CART_BUTTON = xpath("//div[@class='overview']//button[text()='Add to cart']");
    public static final String QUANTITY_TEXTBOX = xpath("//input[@id='product_enteredQuantity_1']");

}
