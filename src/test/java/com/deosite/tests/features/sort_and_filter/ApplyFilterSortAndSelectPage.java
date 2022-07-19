package com.deosite.tests.features.sort_and_filter;

import com.deosite.tests.pages.CategoryPage;
import com.deosite.tests.questions.CategoryHeader;
import com.deosite.tests.questions.category.CurrentUrl;
import com.deosite.tests.questions.filters.FilterWithManyProducts;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.categoryPage.ClickFilterButton;
import com.deosite.tests.tasks.categoryPage.EnsureSortName;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

import static com.deosite.tests.pages.CategoryPage.CATEGORY_HEADER;
import static com.deosite.tests.pages.CategoryPage.SUBMIT_FILTER_BUTTON;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static org.hamcrest.CoreMatchers.containsString;

public class ApplyFilterSortAndSelectPage {
    @Steps
    SetupSteps setupSteps;
    String filter;
    String numberOfProductsAfterFilter;
    String url_filter;
    String selectedFilter;
    String numberOfProductsAfterSort;
    @When("she applies a certain filter and checks number of products")
    public void actor_applies_a_certain_filter(){
        theActorInTheSpotlight().attemptsTo(
                ClickFilterButton.number(0)
        );
        filter = FilterWithManyProducts.filterName().answeredBy(theActorInTheSpotlight());
        selectedFilter = filter.replace("(","").replaceAll("[0-9]", "").replace(")","").replaceAll("\\s+", "");
        url_filter = StringUtils.stripAccents(selectedFilter);
        numberOfProductsAfterFilter = filter.replace("(","").replaceAll("[^\\d.]", "").replace(")","").replaceAll("\\/","").replaceAll("\\s+", "");

        System.out.println("The selected filter name: " + selectedFilter);
        System.out.println("Filter name in url: " + url_filter.toLowerCase(Locale.ROOT));
        System.out.println("Number of products in the selected filter: " + numberOfProductsAfterFilter);

        theActorInTheSpotlight().attemptsTo(
                Click.on(SUBMIT_FILTER_BUTTON),
                WaitUntil.the(SUBMIT_FILTER_BUTTON, isNotPresent()),
                Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed()
        );
        theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString(url_filter.toLowerCase(Locale.ROOT))));
        theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString(selectedFilter)));
        theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString(numberOfProductsAfterFilter)));
        numberOfProductsAfterSort = CATEGORY_HEADER.resolveFor(theActorInTheSpotlight()).getText().replace("(","").replaceAll("[^\\d.]", "").replace(")","").replaceAll("\\/","").replaceAll("\\s+", "");

    }

    @When("she applies a certain filter and checks number of products on search page")
    public void actor_applies_a_certain_filter_on_sarch_page(){
        theActorInTheSpotlight().attemptsTo(
                ClickFilterButton.number(0)
        );
        filter = FilterWithManyProducts.filterName().answeredBy(theActorInTheSpotlight());
        selectedFilter = filter.replace("(","").replaceAll("[0-9]", "").replace(")","").replaceAll("\\s+", "");
        url_filter = StringUtils.stripAccents(selectedFilter);
        numberOfProductsAfterFilter = filter.replace("(","").replaceAll("[^\\d.]", "").replace(")","").replaceAll("\\/","").replaceAll("\\s+", "");

        System.out.println("The selected filter name: " + selectedFilter);
        System.out.println("Filter name in url: " + url_filter.toLowerCase(Locale.ROOT));
        System.out.println("Number of products in the selected filter: " + numberOfProductsAfterFilter);

        theActorInTheSpotlight().attemptsTo(
                Click.on(SUBMIT_FILTER_BUTTON),
                WaitUntil.the(SUBMIT_FILTER_BUTTON, isNotPresent()),
                Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed()
        );
        theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("producer=44")));
        theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString(numberOfProductsAfterFilter)));
        numberOfProductsAfterSort = CATEGORY_HEADER.resolveFor(theActorInTheSpotlight()).getText().replace("(","").replaceAll("[^\\d.]", "").replace(")","").replaceAll("\\/","").replaceAll("\\s+", "");

    }

    @And("she applies the second filter")
    public void actor_applies_the_second_filter(){
        int maxLength = 5;
        theActorInTheSpotlight().attemptsTo(
                ClickFilterButton.number(1)
        );
        filter = FilterWithManyProducts.filterName().answeredBy(theActorInTheSpotlight());
        if(filter.length()>maxLength){
            url_filter = filter.substring(0,5).replace("(","").replace(")","").replaceAll("\\s+", "").replaceAll("[0-9]", "").replaceAll("[^\\x00-\\x7f]", "");
        }
        selectedFilter = filter.replace("(","").replaceAll("[0-9]", "").replace(")","");
        url_filter = StringUtils.stripAccents(url_filter);
        numberOfProductsAfterFilter = filter.replace("(","").replaceAll("[^\\d.]", "").replace(")","").replaceAll("\\/","").replaceAll("\\s+", "");

        System.out.println("The selected filter name: " + selectedFilter);
        System.out.println("Filter name in url: " + url_filter.toLowerCase(Locale.ROOT));
        System.out.println("Number of products in the selected filter: " + numberOfProductsAfterFilter);

        theActorInTheSpotlight().attemptsTo(
                Click.on(SUBMIT_FILTER_BUTTON),
                WaitUntil.the(SUBMIT_FILTER_BUTTON, isNotPresent()),
                Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed()
        );
        theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString(url_filter.toLowerCase(Locale.ROOT))));
        theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString(selectedFilter)));
        theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString(numberOfProductsAfterFilter)));
        numberOfProductsAfterSort = CATEGORY_HEADER.resolveFor(theActorInTheSpotlight()).getText().replace("(","").replaceAll("[^\\d.]", "").replace(")","").replaceAll("\\/","").replaceAll("\\s+", "");

    }
    @And("she applies the second filter on search page")
    public void actor_applies_the_second_filter_on_search_page(){
        int maxLength = 5;
        theActorInTheSpotlight().attemptsTo(
                ClickFilterButton.number(1)
        );
        filter = FilterWithManyProducts.filterName().answeredBy(theActorInTheSpotlight());
        if(filter.length()>maxLength){
            url_filter = filter.substring(0,5).replace("(","").replace(")","").replaceAll("\\s+", "").replaceAll("[0-9]", "").replaceAll("[^\\x00-\\x7f]", "");
        }
        selectedFilter = filter.replace("(","").replaceAll("[0-9]", "").replace(")","");
        url_filter = StringUtils.stripAccents(url_filter);
        numberOfProductsAfterFilter = filter.replace("(","").replaceAll("[^\\d.]", "").replace(")","").replaceAll("\\/","").replaceAll("\\s+", "");

        System.out.println("The selected filter name: " + selectedFilter);
        System.out.println("Filter name in url: " + url_filter.toLowerCase(Locale.ROOT));
        System.out.println("Number of products in the selected filter: " + numberOfProductsAfterFilter);

        theActorInTheSpotlight().attemptsTo(
                Click.on(SUBMIT_FILTER_BUTTON),
                WaitUntil.the(SUBMIT_FILTER_BUTTON, isNotPresent()),
                Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed()
        );
        theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("dajar_collection=443")));
        theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString(numberOfProductsAfterFilter)));
       numberOfProductsAfterSort = CATEGORY_HEADER.resolveFor(theActorInTheSpotlight()).getText().replace("(","").replaceAll("[^\\d.]", "").replace(")","").replaceAll("\\/","").replaceAll("\\s+", "");

    }
    @Then("she should ensure that {word} and filter are still applied")
    public void actor_ensures_sort_and_filter_are_still_applied(String sortName){
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                EnsureSortName.bySortName(sortName),
                Ensure.that(numberOfProductsAfterFilter).isEqualTo(numberOfProductsAfterSort)
        );
        theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString(url_filter.toLowerCase(Locale.ROOT))));
        theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString(selectedFilter)));
        theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString(numberOfProductsAfterFilter)));
    }
    @Then("she should ensure that {word} and filter are still applied on search page")
    public void actor_ensures_sort_and_filter_are_still_applied_on_search_page(String sortName){
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                EnsureSortName.bySortName(sortName),
                Ensure.that(numberOfProductsAfterFilter).isEqualTo(numberOfProductsAfterSort)
        );
        theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("dajar_collection=443")));
        theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("producer=44")));
        theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString(numberOfProductsAfterFilter)));
    }
}
