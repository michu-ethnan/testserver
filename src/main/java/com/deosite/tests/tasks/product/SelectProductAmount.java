package com.deosite.tests.tasks.product;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Random;

import static com.deosite.tests.pages.ProductPage.PRODUCT_AMOUNT_LIST;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class SelectProductAmount implements Question<String> {
    @Override
    public String answeredBy(Actor actor)  {
        actor.attemptsTo(
                WaitUntil.the(PRODUCT_AMOUNT_LIST, isPresent()).forNoMoreThan(100).seconds()
        );
        int size = PRODUCT_AMOUNT_LIST.resolveAllFor(actor).size();
        List<WebElementFacade> amountNumbers = PRODUCT_AMOUNT_LIST.resolveAllFor(actor);
        Random r = new Random();
        int high = amountNumbers.size();
        int low2 = 3;
        int low = 2;
        for (int i=2; i < high; i++) {
            int amountNumberList = r.nextInt(high-low2) + low;
            String PageNumber = amountNumbers.get(amountNumberList).getAttribute("textContent");
            amountNumbers.get(amountNumberList).click();
            return PageNumber;

        }
        return null;
    }
    public static Question<String> amountNumber() {
        return new SelectProductAmount();
    }
}
