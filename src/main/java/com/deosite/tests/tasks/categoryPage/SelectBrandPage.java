package com.deosite.tests.tasks.categoryPage;

import com.deosite.tests.pages.SearchPage;
import com.deosite.tests.questions.category.CurrentUrl;
import com.deosite.tests.tasks.brandPage.ClickBrand;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.hamcrest.CoreMatchers.containsString;

public class SelectBrandPage implements Task {
    private final String brandName;
    public SelectBrandPage(String brandName){
        this.brandName = brandName;
    }
    @Override
    @Step("{0} selects brand")
    public <T extends Actor> void performAs(T actor){
        if (brandName.contains("Ambition")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(0),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("ambition")));
        }

        if (brandName.contains("Luminarc")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(1),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("luminarc")));
        }

        if (brandName.contains("Domotti")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(2),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("domotti")));
        }

        if (brandName.contains("Pasabahce")) {
            actor.attemptsTo(
                    (ClickBrand.byBrandName(3)),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("pasabahce")));
        }

        if (brandName.contains("Pyrex")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(4),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("pyrex")));
        }

        if (brandName.contains("Disney")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(5),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("disney")));
        }

        if (brandName.contains("Patio")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(6),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("patio")));
        }

        if (brandName.contains("Velkea")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(7),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("velkea")));
        }

        if (brandName.contains("Nardi")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(8),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("nardi")));
        }
        if (brandName.contains("Curver")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(9),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("curver")));
        }

        if (brandName.contains("Keter")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(10),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("keter")));
        }

        if (brandName.contains("Myhome")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(11),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("myhome-x")));
        }

        if (brandName.contains("Jotta")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(12),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("jotta")));
        }

        if (brandName.contains("Bestway")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(13),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("bestway")));
        }

        if (brandName.contains("BranQ")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(14),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("branq")));
        }

        if (brandName.contains("Arcoroc")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(15),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("arcoroc")));
        }

        if (brandName.contains("DisAmb")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(16),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("disney-ambition")));
        }

        if (brandName.contains("Arcopal")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(17),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("arcopal")));
        }

        if (brandName.contains("Ocuisine")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(18),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("ocuisine")));
        }

        if (brandName.contains("Eko-drew")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(19),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("ekodrew")));
        }

        if (brandName.contains("Nickelodeon")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(20),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("nickelodeon")));
        }

        if (brandName.contains("Fiskars")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(21),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("fiskars")));
        }

        if (brandName.contains("Kis")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(22),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("kis")));
        }

        if (brandName.contains("Plast_Team")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(23),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("plast-team")));
        }

        if (brandName.contains("Rotho")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(24),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("rotho")));
        }

        if (brandName.contains("Orplast")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(25),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("orplast")));
        }

        if (brandName.contains("Sanrio")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(26),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("sanrio")));
        }

        if (brandName.contains("Marvel")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(27),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("marvel")));
        }

        if (brandName.contains("Arranger")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(28),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("arranger")));
        }

        if (brandName.contains("Glasmark")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(29),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("glasmark")));
        }

        if (brandName.contains("Aquaphor")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(30),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("aquaphor")));
        }

        if (brandName.contains("Walther_Glas")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(31),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("walther-glas")));
        }

        if (brandName.contains("Vileda")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(32),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );

            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("vileda")));
        }

        if (brandName.contains("Borcam")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(33),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );

            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("borcam")));
        }

        if (brandName.contains("Churchill")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(34),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("churchill")));
        }

        if (brandName.contains("AmbJunior")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(35),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("ambition-junior")));
        }

        if (brandName.contains("Brabantia")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(36),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("brabantia")));
        }

        if (brandName.contains("Kettler")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(37),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("kettler")));
        }

        if (brandName.contains("Weber")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(38),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("weber")));
        }

        if (brandName.contains("Emalia_Olkusz")) {
            actor.attemptsTo(
                    ClickBrand.byBrandName(39),
                    WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("emalia-olkusz")));
        }
    }
    public static SelectBrandPage byName(String brandName) {
        return Instrumented.instanceOf(SelectBrandPage.class).withProperties(brandName);
    }
}