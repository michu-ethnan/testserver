package com.deosite.tests.questions.category;

import com.deosite.tests.pages.CategoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.math.BigDecimal;

public class PageNumber implements Question<BigDecimal> {
    @Override
    public BigDecimal answeredBy(Actor actor){
        String pageNumber = CategoryPage.NUMBER_OF_PAGES.resolveFor(actor).getText();
        String pageNumberAfterTrim = pageNumber.replaceAll("[^\\d.]", "").trim();
        BigDecimal number = new BigDecimal(pageNumberAfterTrim);
        return number;
    }
    public static Question<BigDecimal> number() {
        return new PageNumber();
    }
}