package com.deosite.tests.tasks.categoryPage;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Random;

import static com.deosite.tests.pages.CategoryPage.PAGINATION_NUMBER_LIST;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class SelectPageNumberRandomly implements Question<String> {
    @Override
    public String answeredBy(Actor actor)  {
        actor.attemptsTo(
                WaitUntil.the(PAGINATION_NUMBER_LIST, isPresent()).forNoMoreThan(100).seconds()
        );
        int size = PAGINATION_NUMBER_LIST.resolveAllFor(actor).size();
        List<WebElementFacade> pageNumbers = PAGINATION_NUMBER_LIST.resolveAllFor(actor);
        Random r = new Random();
        int high = pageNumbers.size();
        int low = 3;
        int lowerBound = 2;
        for (int i=2; i < high; i++) {
            int pageNumberList = r.nextInt(high-low) + lowerBound;
            String PageNumber = pageNumbers.get(pageNumberList).getAttribute("textContent");
            pageNumbers.get(pageNumberList).click();
            return PageNumber;
        }
        return null;
    }
    public static Question<String> pageNumber() {
        return new SelectPageNumberRandomly();
    }
}