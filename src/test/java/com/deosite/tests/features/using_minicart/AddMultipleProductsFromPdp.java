package com.deosite.tests.features.using_minicart;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.MiniCart;
import com.deosite.tests.questions.minicart.MinicartHeader;
import com.deosite.tests.questions.product.ProductPrice;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import com.deosite.tests.tasks.product.MoveMouseDown;
import com.deosite.tests.tasks.product.SelectProductAmount;
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

import static com.deosite.tests.pages.Alert.ALERT_BOX;
import static com.deosite.tests.pages.MainMenu.SEARCH_BAR;
import static com.deosite.tests.pages.ProductPage.ADD_TO_CART_BUTTON;
import static com.deosite.tests.pages.ProductPage.PRODUCT_AMOUNT_SELECT;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.hamcrest.CoreMatchers.containsString;

public class AddMultipleProductsFromPdp {
    @Steps
    SetupSteps setupSteps;
    BigDecimal productPrice;
    String amountNumber;
    String selectedAmountNumber;
    @Given("that {word} is on a certain product page")
    public void ethnan_is_on_a_certain_pdp(String actor){
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                WaitUntil.the(SEARCH_BAR, isPresent()).forNoMoreThan(100).seconds(),
                ClickCategory.byCategoryNumber(0),
                Open.productPageByPosition(4)
        );
        productPrice = ProductPrice.price().answeredBy(theActorInTheSpotlight());
    }
    @And("he opens pdp from search")
    public void actor_opens_pdp_from_search(){
        theActorInTheSpotlight().attemptsTo(
                Open.productPageByPosition(2)
        );
        productPrice = ProductPrice.price().answeredBy(theActorInTheSpotlight());
    }
    @When("he adds n amount of products from pdp")
    public void ethnan_adds_n_amount_of_products(){
        theActorInTheSpotlight().attemptsTo(
                Click.on(PRODUCT_AMOUNT_SELECT)
        );
        amountNumber = SelectProductAmount.amountNumber().answeredBy(theActorInTheSpotlight());
        selectedAmountNumber = amountNumber;
        theActorInTheSpotlight().attemptsTo(
                Click.on(ADD_TO_CART_BUTTON),
                WaitUntil.the(ALERT_BOX, isPresent()).forNoMoreThan(20).seconds()
        );
    }
    @Then("he should see the number of products he added in the minicart")
    public void actor_should_see_the_amount_in_minicart(){
        theActorInTheSpotlight().attemptsTo(
                MoveMouseDown.move(),
                Scroll.to(MiniCart.MINICART_BUTTON),
                Open.miniCart()
        );
        theActorInTheSpotlight().should(seeThat(MinicartHeader.numberOfProducts(), containsString(selectedAmountNumber)));
    }
    @Then("he should see that the sum is correct")
    public void actor_should_see_the_sum_is_correct(){
        BigDecimal totalSum =
                com.deosite.tests.questions.minicart.TotalSumInMinicart.sum().answeredBy(theActorInTheSpotlight());
        BigDecimal numberOfProducts = new BigDecimal(selectedAmountNumber);
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(totalSum).isEqualTo(productPrice.multiply(numberOfProducts))
        );
    }

}
