package com.deosite.tests.questions.product;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.math.BigDecimal;

import static com.deosite.tests.pages.ProductPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class ProductCatalogPrice implements Question<BigDecimal>{
    String ProductPrice;
    @Override
    public BigDecimal answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(PRODUCT_NAME, isPresent())
        );
        if (PREVIOUS_PRODUCT_PRICE.resolveFor(actor).isPresent()) {
            ProductPrice = PREVIOUS_PRODUCT_PRICE.resolveFor(actor).getText();
        } else {
            ProductPrice = PRODUCT_PRICE.resolveFor(actor).getText();
        }

        String priceAfterTrim = ProductPrice.replace(",", ".").trim();
        BigDecimal price = new BigDecimal(priceAfterTrim);
        return price;
    }
    public static Question<BigDecimal> price() {
        return new ProductCatalogPrice();
    }
}
