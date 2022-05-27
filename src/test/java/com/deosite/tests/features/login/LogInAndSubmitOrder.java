package com.deosite.tests.features.login;

import com.deosite.tests.actions.*;
import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.*;
import com.deosite.tests.questions.order.Success;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.*;
import com.deosite.tests.tasks.homePage.MoveMouseToBottom;
import com.deosite.tests.tasks.login.FillInLoginForm;
import com.deosite.tests.tasks.login.SubmitLoginForm;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import com.deosite.tests.tasks.order.ChooseDelivery;
import com.deosite.tests.tasks.order.PayAfterLogin;
import com.deosite.tests.tasks.order.PlaceAfterLogin;
import com.deosite.tests.tasks.product.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.abilities.Load.as;
import static com.deosite.tests.pages.CategoryPage.CATEGORY_HEADER;
import static com.deosite.tests.pages.LoginPage.*;
import static com.deosite.tests.pages.MainMenu.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class LogInAndSubmitOrder {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} has a product in the minicart")
    public void that_actor_has_a_product_in_the_minicart(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(7),
                Open.productPageByPositionRandomly(),
                AddProduct.toCart(),
                MoveMouseDown.move(),
                ReturnToPreviousPage.goToPreviousPage()
        );
    }

    @When("he logs in")
    public void actor_logs_in() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LOGIN_BUTTON, isClickable()).forNoMoreThan(100).seconds(),
                Open.loginPage(),
                FillInLoginForm.type("login and submit order"),
                SubmitLoginForm.submitLoginForm(),
                WaitUntil.the(SUBMIT_BUTTON, isNotPresent()).forNoMoreThan(50).seconds()
        );
    }

    @And("he orders a {string} using {word} delivery and {word}")
    public void actor_makes_an_order(String product, String deliveryType, String paymentType) {
        theActorInTheSpotlight().attemptsTo(
                Scroll.to(HomePage.SECOND_BANNER),
                MoveMouse.to(FIRST_MAIN_CATEGORY),
                ClickCategory.byCategoryNumber(5),
                WaitUntil.the(CATEGORY_HEADER, isPresent()),
                MoveMouse.to(MINI_CART_BUTTON),
                Open.miniCart(),
                WaitUntil.the(MiniCart.GO_TO_CHECKOUT_BUTTON, isClickable()).forNoMoreThan(100).seconds(),
                Click.on(MiniCart.GO_TO_CHECKOUT_BUTTON),
                ChooseDelivery.byType(deliveryType),
                PayAfterLogin.by(paymentType),
                PlaceAfterLogin.order()
        );
    }

    @Then("he should see that the order was made")
    public void actor_should_see_that_the_order_was_made() {
        theActorInTheSpotlight().should(
                seeThat(
                        Success.message(), equalTo(
                                as(theActorInTheSpotlight()).translate("success order message")
                        )),
                seeThat(Success.info(), equalTo(
                        as(theActorInTheSpotlight()).translate("additional success info")
                ))
        );
    }

}
