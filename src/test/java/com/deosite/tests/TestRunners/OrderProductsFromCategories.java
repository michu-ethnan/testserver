package com.deosite.tests.TestRunners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/features/creating_orders/order_products_from_categories.feature"},
        glue = {"com.deosite"}
)
public class OrderProductsFromCategories {
}
