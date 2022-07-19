package com.deosite.tests.questions.category;

import com.deosite.tests.pages.CategoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class AppliedSortName implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        String appliedFilterName = CategoryPage.SORT_NAME.resolveFor(actor).getText();
        String name = new String(appliedFilterName);
        return name;
    }
    public static Question<String> Name() {
        return new AppliedSortName();
    }
}
