package com.deosite.tests.pages;

import net.serenitybdd.screenplay.targets.Target;

public class SearchPage {

    public static Target PRODUCTS_TITLE = Target.the("First product title").locatedBy("//div[@data-test='product-box']/a/div/p");

}