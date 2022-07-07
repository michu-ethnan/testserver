package com.deosite.tests.features.pagination;

import com.deosite.tests.actions.Open;
import com.deosite.tests.actions.Search;
import com.deosite.tests.pages.HomePage;
import com.deosite.tests.questions.category.CurrentUrl;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.MoveMouseToTop;
import com.deosite.tests.tasks.basic.ReturnToPreviousPage;
import com.deosite.tests.tasks.brandPage.ClickBrand;
import com.deosite.tests.tasks.categoryPage.ClickCollectionBanner;
import com.deosite.tests.tasks.categoryPage.SelectPageNumber;
import com.deosite.tests.tasks.categoryPage.SelectPageNumberRandomly;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.Keys;

import java.math.BigDecimal;
import java.util.Random;

import static com.deosite.tests.pages.CategoryPage.*;
import static com.deosite.tests.pages.LoginPage.SUBMIT_BUTTON;
import static com.deosite.tests.pages.MainMenu.FIRST_MAIN_CATEGORY;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.hamcrest.CoreMatchers.containsString;

public class SelectPage {
    @Steps
    SetupSteps setupSteps;
String PageNumber;
String selectedPageNumber;
String url;
static String generatedRandomNumber;
static BigDecimal numberOfPages;
    @Given("that {word} is on a category page")
    public void that_actor_is_on_a_category_page(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                WaitUntil.the(FIRST_MAIN_CATEGORY, isPresent()),
                Open.categoryPage(),
                MoveMouseToTop.move()
        );
        numberOfPages = com.deosite.tests.questions.category.PageNumber.number().answeredBy(theActorInTheSpotlight());
    }
    @Given("that {word} visits collection page")
    public void that_actor_visits_collection_page(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(9),
                MoveMouseToTop.move(),
                ClickBrand.byBrand(0),
                ClickCollectionBanner.collectionNumber(1)
        );
    }
    @Given("that {word} looks for a {word}")
    public void actor_looks_for_a_product(String actor, String keyword) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                Search.forProductByTranslatedKeyword(keyword)
        );
    }
    @And("she is on the search results page")
    public void actor_is_on_the_search_results_page() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CATEGORY_HEADER, isPresent())
        );
        numberOfPages = com.deosite.tests.questions.category.PageNumber.number().answeredBy(theActorInTheSpotlight());
    }
    @When("she selects a page from collection page")
    public void actor_selects_a_page_from_collection_page() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(PAGINATION_SELECT)
        );
        PageNumber =   SelectPageNumberRandomly.pageNumber().answeredBy(theActorInTheSpotlight());
        selectedPageNumber = PageNumber;
        url = PageNumber;
    }
    @When("she selects a page from top")
    public void actor_selects_a_page() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(PAGINATION_SELECT, isPresent()).forNoMoreThan(100).seconds(),
                Click.on(PAGINATION_SELECT)
        );
     PageNumber =   SelectPageNumberRandomly.pageNumber().answeredBy(theActorInTheSpotlight());
        selectedPageNumber = PageNumber;
        url = PageNumber;
    }
    @When("she selects a page from bottom")
    public void actor_selects_a_page_from_top() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(PAGINATION_SELECT_BOTTOM, isPresent()).forNoMoreThan(100).seconds(),
                Click.on(PAGINATION_SELECT_BOTTOM)
        );
        PageNumber =   SelectPageNumberRandomly.pageNumber().answeredBy(theActorInTheSpotlight());
        selectedPageNumber = PageNumber;
        url = PageNumber;
    }
    @When("she inserts a page number from top")
    public void actor_inserts_page_number(){
        numberOfPages = com.deosite.tests.questions.category.PageNumber.number().answeredBy(theActorInTheSpotlight());
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(PAGINATION_SELECT, isPresent()).forNoMoreThan(100).seconds(),
                Click.on(PAGINATION_SELECT),
                SelectPageNumber.byNumber(9),
                WaitUntil.the(PAGINATION_INPUT, isPresent()),
                SendKeys.of(randomNumber()).into(PAGINATION_INPUT).thenHit(Keys.ENTER)
        );
    }
    @When("she inserts a page number from bottom")
    public void actor_inserts_page_number_from_bottom(){
        numberOfPages = com.deosite.tests.questions.category.PageNumber.number().answeredBy(theActorInTheSpotlight());
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(PAGINATION_SELECT_BOTTOM, isPresent()).forNoMoreThan(100).seconds(),
                Click.on(PAGINATION_SELECT_BOTTOM),
                SelectPageNumber.byNumber(9),
                WaitUntil.the(PAGINATION_INPUT_BOTTOM, isPresent()),
                SendKeys.of(randomNumber()).into(PAGINATION_INPUT_BOTTOM).thenHit(Keys.ENTER)
        );
    }
    private static String randomNumber() {
        Random rand = new Random();
        BigDecimal upperbound =  numberOfPages;
        int lowerBound = 2;
        int i = upperbound.intValue();
        int int_random = rand.nextInt(i-lowerBound)+lowerBound;
        generatedRandomNumber = String.valueOf(int_random);
        return generatedRandomNumber;
    }
@When("she opens pdp and returns to previous page")
public void actor_opens_pdp(){
        theActorInTheSpotlight().attemptsTo(
                Open.productPageByPositionRandomly(),
                ReturnToPreviousPage.goToPreviousPage()
        );
}
    @Then("she should be on that page")
    public void actor_should_be_on_that_page() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(HomePage.DAJAR_LOGO, isPresent()).forNoMoreThan(50).seconds(),
                WaitUntil.the(SUBMIT_BUTTON, isNotPresent())
        );
        theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString(url)));
    }
    @Then("she should be on the inserted page number")
    public void actor_should_be_on_inserted_page() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(HomePage.DAJAR_LOGO, isPresent()).forNoMoreThan(50).seconds(),
                WaitUntil.the(SUBMIT_BUTTON, isNotPresent())
        );
        theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString(generatedRandomNumber)));
    }
}