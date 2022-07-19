package com.deosite.tests.features.sorting;

import com.deosite.tests.pages.MainMenu;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.basic.RefreshPage;
import com.deosite.tests.tasks.basic.ReturnToPreviousPage;
import com.deosite.tests.tasks.categoryPage.EnsureSortName;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import java.math.BigDecimal;

import static com.deosite.tests.pages.LoginPage.SUBMIT_BUTTON;
import static com.deosite.tests.pages.MainMenu.CLOSE_NEWSLETTER_POPUP;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class SortRefreshSelectPageAndOpenPdp {

    BigDecimal firstProductPrice;
    BigDecimal secondProductPrice;
    @Steps
    SetupSteps setupSteps;
  /*  @When("she sees the first catalog price")
    public void actor_sees_the_first_catalog_price(){
        theActorInTheSpotlight().attemptsTo(
                Open.productPageByPosition(1)
        );
        firstProductPrice = ProductCatalogPrice.price().answeredBy(theActorInTheSpotlight());
        System.out.println(firstProductPrice);
    }
    @When("she sees the second catalog price")
    public void actor_sees_the_second_catalog_price(){
    theActorInTheSpotlight().attemptsTo(
            Scroll.to(SEARCH_BAR),
            ReturnToPreviousPage.goToPreviousPage(),
            Open.productPageByPosition(22)
        );
     secondProductPrice = ProductCatalogPrice.price().answeredBy(theActorInTheSpotlight());
      System.out.println(secondProductPrice);
    }*/
    @And(("she reloads the page and ensures that {word} is still applied"))
    public void actor_refreshes_the_page_and_ensures_sort(String sortName){
        theActorInTheSpotlight().attemptsTo(
                RefreshPage.refresh(),
                WaitUntil.the(CLOSE_NEWSLETTER_POPUP, isPresent()),
                Click.on(MainMenu.CLOSE_NEWSLETTER_POPUP),
                EnsureSortName.bySortName(sortName)
        );
    }
    @And(("she refreshes the page and ensures that {word} is still applied"))
    public void actor_refreshes_the_page_and_ensures_the_sort(String sortName){
        theActorInTheSpotlight().attemptsTo(
                RefreshPage.refresh(),
                WaitUntil.the(SUBMIT_BUTTON, isNotPresent()),
                EnsureSortName.bySortName(sortName)
        );
    }
    @Then("she returns to previous page and ensures the page number and {word} sort")
    public void actor_return_to_previous_page_and_ensures(String sortName){
        theActorInTheSpotlight().attemptsTo(
                ReturnToPreviousPage.goToPreviousPage(),
                WaitUntil.the(SUBMIT_BUTTON, isNotPresent()),
                EnsureSortName.bySortName(sortName)
        );
    }
}