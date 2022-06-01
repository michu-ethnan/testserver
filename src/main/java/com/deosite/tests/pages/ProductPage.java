package com.deosite.tests.pages;

import net.serenitybdd.screenplay.targets.Target;

public class ProductPage {

    public static Target ADD_TO_CART_BUTTON = Target.the("Add to cart button").locatedBy("//button[@data-test='add-to-cart']");
    public static Target CONFIGURABLE_SELECT = Target.the("Configurable select").locatedBy("//*[@id=\"__app__\"]/div/div[3]/div/div[1]/div/div/div/div[3]/div/div[3]/div[1]/div/div/label/select");
    public static Target PRODUCT_NAME = Target.the("Product name").locatedBy("//*[@id=\"__app__\"]//h1");
    public static Target CONFIGURABLE_SELECT_LABEL = Target.the("Configurable select name").locatedBy("//*[@id=\"__app__\"]/div/div[3]/div/div[1]/div/div/div/div[3]/div/div[3]/div[1]/div/div/label/span");

    public static Target PRODUCT_PRICE = Target.the("Product price").locatedBy("//*[@id=\"__app__\"]/div[2]//div[2]/p/span/span[1]");
    public static Target DISCOUNTED_PRODUCT_PRICE = Target.the("Discounted Product price").locatedBy("//*[@id=\"__app__\"]/div[2]//div[3]/p[2]/span/span[1]");

    public static Target RIGHT_ARROW = Target.the("Right arrow").locatedBy("//button[@data-test='right-arrow-small-image-slider']");
    public static Target LEFT_ARROW = Target.the("Left arrow").locatedBy("//button[@data-test='left-arrow-small-image-slider']");
    public static Target PRODUCT_THUMBNAIL = Target.the("Product thumbnail").locatedBy("//*[@id=\"__app__\"]/div[2]/div[3]/div/div[2]/div/div/div/div[1]/div[2]/div[1]/div/div[3]");

    public static Target OTHER_PRODUCTS_HEADING = Target.the("Other products heading").locatedBy("(//*[@id=\"__app__\"]//h3)[1]");
    public static Target ADD_TO_CART_FROM_COLLECTION_PAGE = Target.the("Subcategory list").locatedBy("(//div[@class=\"css-6l1kfd\"]//div[@class=\"css-1n8bjx5\"])[1]");

    public static Target PAGE_NOT_FOUND = Target.the("Page not found").locatedBy("//*[@id=\"__app__\"]/div[2]/div[3]/div/div[2]/div/div/p");


}