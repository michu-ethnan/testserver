package com.deosite.tests.features.sorting;

import com.deosite.tests.actions.Open;
import com.deosite.tests.actions.Search;
import com.deosite.tests.pages.CategoryPage;
import com.deosite.tests.questions.product.ProductCatalogPrice;
import com.deosite.tests.questions.product.ProductName;
import com.deosite.tests.questions.product.ProductPrice;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.MoveMouseToTop;
import com.deosite.tests.tasks.basic.ReturnToPreviousPage;
import com.deosite.tests.tasks.categoryPage.SelectSortByNameOnCategoryPage;
import com.deosite.tests.tasks.categoryPage.SelectSortByNameOnSearchPage;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import java.math.BigDecimal;

import static com.deosite.tests.abilities.Load.as;
import static com.deosite.tests.pages.CategoryPage.CATEGORY_HEADER;
import static com.deosite.tests.pages.LoginPage.SUBMIT_BUTTON;
import static com.deosite.tests.pages.MainMenu.FIRST_MAIN_CATEGORY;
import static com.deosite.tests.pages.MainMenu.SEARCH_BAR;
import static com.deosite.tests.pages.SearchPage.PRODUCTS_TITLE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.CoreMatchers.containsString;

public class ApplyAllSorts {
    @Steps
    SetupSteps setupSteps;
    BigDecimal firstProductPrice;
    BigDecimal secondProductPrice;
    String firstProductName;
    String numberOfProductsBeforeSort;
    String numberOfProductsAfterSort;

    @Given("that {word} opens the first category page")
    public void maja_opens_the_first_category_page(String actor){
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                WaitUntil.the(FIRST_MAIN_CATEGORY, isPresent()),
                ClickCategory.byCategoryNumber(0),
                MoveMouseToTop.move(),
                WaitUntil.the(CategoryPage.PAGINATION_ARROW, isPresent())
        );
        numberOfProductsBeforeSort = CATEGORY_HEADER.resolveFor(theActorInTheSpotlight()).getText().replace("(","").replaceAll("[^\\d.]", "").replace(")","").replaceAll("\\/","").replaceAll("\\s+", "");
    }
    @Given("that {word} attempts to search for a {string}")
    public void maja_attempts_to_look_for_a_mug(String actor, String keyword){
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                WaitUntil.the(SEARCH_BAR, isPresent()).forNoMoreThan(10).seconds(),
                Search.forProductByTranslatedKeyword(keyword),
                WaitUntil.the(CATEGORY_HEADER, isPresent()),
                WaitUntil.the(PRODUCTS_TITLE, isClickable()).forNoMoreThan(50).seconds()
        );
        numberOfProductsBeforeSort = CATEGORY_HEADER.resolveFor(theActorInTheSpotlight()).getText().replace("(","").replaceAll("[^\\d.]", "").replace(")","").replaceAll("\\/","").replaceAll("\\s+", "");
    }
    @When("she applies {word} filter")
    public void actor_applies_sorts(String sortName){
        theActorInTheSpotlight().attemptsTo(
                Click.on(CategoryPage.SORTING_BUTTON),
                SelectSortByNameOnCategoryPage.byName(sortName),
                WaitUntil.the(SUBMIT_BUTTON, isNotPresent()),
                WaitUntil.the(PRODUCTS_TITLE, isClickable()).forNoMoreThan(50).seconds()
        );
        numberOfProductsAfterSort = CATEGORY_HEADER.resolveFor(theActorInTheSpotlight()).getText().replace("(","").replaceAll("[^\\d.]", "").replace(")","").replaceAll("\\/","").replaceAll("\\s+", "");
    }
    @When("she applies {word} filter on search page")
    public void actor_applies_sorts_on_search_page(String sortName){
        theActorInTheSpotlight().attemptsTo(
                Click.on(CategoryPage.SORTING_BUTTON),
                SelectSortByNameOnSearchPage.byName(sortName),
                WaitUntil.the(SUBMIT_BUTTON, isNotPresent()),
                WaitUntil.the(PRODUCTS_TITLE, isClickable()).forNoMoreThan(50).seconds()
        );
        numberOfProductsAfterSort = CATEGORY_HEADER.resolveFor(theActorInTheSpotlight()).getText().replace("(","").replaceAll("[^\\d.]", "").replace(")","").replaceAll("\\/","").replaceAll("\\s+", "");
    }
    @When("she sees the first catalog price")
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
    }
    @And("she sees the first price")
    public void actor_sees_first_price(){
        theActorInTheSpotlight().attemptsTo(
                Open.productPageByPosition(2)

        );
        firstProductPrice= ProductPrice.price().answeredBy(theActorInTheSpotlight());
    }
    @And("she sees the second price")
    public void actor_sees_second_price(){
        theActorInTheSpotlight().attemptsTo(
                Scroll.to(SEARCH_BAR),
                ReturnToPreviousPage.goToPreviousPage(),
                Open.productPageByPosition(22)
        );
        secondProductPrice= ProductPrice.price().answeredBy(theActorInTheSpotlight());
    }
    @And("she sees the first product name")
    public void actor_sees_the_first_name(){
        theActorInTheSpotlight().attemptsTo(
                Open.productPageByPosition(0)

        );
        firstProductName = ProductName.productName().answeredBy(theActorInTheSpotlight());
    }

    @Then("she should see that the sort is in descending order")
    public void actor_ensures_that_the_sort_is_in_descending_order(){
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(firstProductPrice).isGreaterThanOrEqualTo(secondProductPrice)
                //Ensure.that(numberOfProductsBeforeSort).isEqualTo(numberOfProductsAfterSort)
        );
    }
    @Then("she should ensure that the sort is in ascending order")
    public void actor_ensures_the_sort_is_in_ascending_order(){
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(firstProductPrice).isLessThanOrEqualTo(secondProductPrice)
                //Ensure.that(numberOfProductsBeforeSort).isEqualTo(numberOfProductsAfterSort)
        );
    }
    @Then("she should see that the sort is in descending order search page")
    public void actor_ensures_that_the_sort_is_in_descending_order_search_page(){
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(firstProductPrice).isGreaterThanOrEqualTo(secondProductPrice)
        );
    }
    @Then("she should ensure that the sort is in ascending order search page")
    public void actor_ensures_the_sort_is_in_ascending_order_search_page(){
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(firstProductPrice).isLessThanOrEqualTo(secondProductPrice)
        );
    }
    @Then("she should see that the sort is {string}")
    public void actor_ensures_the_sort(String message){
 theActorInTheSpotlight().should(seeThat(ProductName.productName(), containsString(as(theActorInTheSpotlight()).translate(message))));

    }
}
