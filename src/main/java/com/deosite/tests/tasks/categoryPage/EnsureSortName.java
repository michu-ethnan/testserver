package com.deosite.tests.tasks.categoryPage;

import com.deosite.tests.pages.SearchPage;
import com.deosite.tests.questions.category.AppliedSortName;
import com.deosite.tests.questions.category.CurrentUrl;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static org.hamcrest.CoreMatchers.containsString;

public class EnsureSortName implements Task {
    private final String sortName;
    public EnsureSortName(String sortName){
        this.sortName = sortName;
    }
    @Override
    @Step("{0} selects filter by name")
    public <T extends Actor> void performAs(T actor){
        if (sortName.contains("Cena:_od_najwyższej")) {
            actor.attemptsTo(
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isClickable())
            );
            theActorInTheSpotlight().should(seeThat(AppliedSortName.Name(), containsString("Cena: od najwyższej")));
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("dir=desc&order=final_price")));
        }
        if (sortName.contains("Cena:_od_najniższej")) {
            actor.attemptsTo(
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isClickable())
            );
            theActorInTheSpotlight().should(seeThat(AppliedSortName.Name(), containsString("Cena: od najniższej")));
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("dir=asc&order=final_price")));
        }
        if (sortName.contains("Wg_nazwy_Z-A")) {
            actor.attemptsTo(
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isClickable())
            );
            theActorInTheSpotlight().should(seeThat(AppliedSortName.Name(), containsString("Wg nazwy Z-A")));
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("dir=desc&order=name")));
        }
        if (sortName.contains("Wg_nazwy_A-Z")) {
            actor.attemptsTo(
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isClickable())
            );
            theActorInTheSpotlight().should(seeThat(AppliedSortName.Name(), containsString("Wg nazwy A-Z")));
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("dir=asc&order=name")));
        }
        if (sortName.contains("Cena_katalogowa:_od_najwyższej")) {
            actor.attemptsTo(
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isClickable())
            );
            theActorInTheSpotlight().should(seeThat(AppliedSortName.Name(), containsString("Cena katalogowa: od najwyższej")));
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("dir=desc&order=price")));
        }
        if (sortName.contains("Cena_katalogowa:_od_najniższej")) {
            actor.attemptsTo(
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isClickable())
            );
            theActorInTheSpotlight().should(seeThat(AppliedSortName.Name(), containsString("Cena katalogowa: od najniższej")));
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("dir=asc&order=price")));
        }
    }
    public static EnsureSortName bySortName(String sortName) {
        return Instrumented.instanceOf(EnsureSortName.class).withProperties(sortName);
    }
}