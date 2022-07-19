package com.deosite.tests.TestRunners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/features/creating_orders/order_from_brand_page_4.feature"},
        glue = {"com.deosite"}
)
public class OrderProductsFromBrandsPage_4 {
}
