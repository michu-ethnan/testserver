package com.deosite.tests.features.pagination;

import com.deosite.tests.pages.CategoryPage;
import com.deosite.tests.pages.HomePage;
import com.deosite.tests.questions.category.CurrentUrl;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.basic.ReturnToPreviousPage;
import com.deosite.tests.tasks.categoryPage.ClickFilterButton;
import com.deosite.tests.tasks.categoryPage.ClickSelectedFilter;
import com.deosite.tests.tasks.categoryPage.SelectPageNumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import java.math.BigDecimal;

import static com.deosite.tests.pages.CategoryPage.*;
import static com.deosite.tests.pages.LoginPage.SUBMIT_BUTTON;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.CoreMatchers.containsString;
public class ApplyFiltersAndApplyPagination {
    @Steps
    SetupSteps setupSteps;
    BigDecimal numberOfPages1;
    BigDecimal numberOfPages2;
    BigDecimal numberOfPages3;
    BigDecimal numberOfPages4;
    @When("he applies two filters")
    public void actor_applies_two_filter() {
        theActorInTheSpotlight().attemptsTo(
                ClickFilterButton.number(0),
                ClickSelectedFilter.number(0),
                Click.on(SUBMIT_FILTER_BUTTON),
                WaitUntil.the(SUBMIT_FILTER_BUTTON, isNotPresent())
        );
        numberOfPages1 = com.deosite.tests.questions.category.PageNumber.number().answeredBy(theActorInTheSpotlight());
        System.out.println(numberOfPages1);

        theActorInTheSpotlight().attemptsTo(
                ClickFilterButton.number(1),
                ClickSelectedFilter.number(0),
                Click.on(SUBMIT_FILTER_BUTTON),
                WaitUntil.the(SUBMIT_FILTER_BUTTON, isNotPresent())
        );
        numberOfPages2 = com.deosite.tests.questions.category.PageNumber.number().answeredBy(theActorInTheSpotlight());
        System.out.println(numberOfPages2);
    }
    @And("she ensures that pagination button is present")
    public void actor_ensures_pagination_button(){
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(PAGINATION_SELECT).isDisplayed()
        );
    }
    @And("she selects a page number")
    public void actor_selects_a_page_number(){
        theActorInTheSpotlight().attemptsTo(
                Click.on(PAGINATION_SELECT),
                SelectPageNumber.byNumber(1),
                WaitUntil.the(PAGINATION_SELECT, isClickable()).forNoMoreThan(50).seconds()
        );
    }
    @Then("she should be on the selected page number and the filter is still applied")
    public void actor_should_be_on_the_selected_page_and_see_filter(){
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(HomePage.DAJAR_LOGO, isPresent()).forNoMoreThan(50).seconds(),
                WaitUntil.the(SUBMIT_BUTTON, isNotPresent()),
                Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed()
        );
        theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("p=2")));
    }
    @When("she returns to previous page")
    public void actor_returns_to_previous_page(){
        theActorInTheSpotlight().attemptsTo(
                ReturnToPreviousPage.goToPreviousPage(),
                WaitUntil.the(CATEGORY_HEADER, isPresent()),
                WaitUntil.the(SUBMIT_BUTTON, isNotPresent())
        );
        numberOfPages3 = com.deosite.tests.questions.category.PageNumber.number().answeredBy(theActorInTheSpotlight());
        System.out.println(numberOfPages3);
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(numberOfPages3).isEqualTo(numberOfPages2)
        );
        theActorInTheSpotlight().attemptsTo(
                ReturnToPreviousPage.goToPreviousPage(),
                WaitUntil.the(CATEGORY_HEADER, isPresent())
        );
        numberOfPages4 = com.deosite.tests.questions.category.PageNumber.number().answeredBy(theActorInTheSpotlight());
        System.out.println(numberOfPages4);
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(numberOfPages4).isEqualTo(numberOfPages1)
        );
    }
}