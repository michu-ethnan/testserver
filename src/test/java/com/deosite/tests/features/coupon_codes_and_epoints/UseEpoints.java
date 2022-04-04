package com.deosite.tests.features.coupon_codes_and_epoints;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.*;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.*;
import com.deosite.tests.tasks.login.FillInLoginForm;
import com.deosite.tests.tasks.login.SubmitLoginForm;
import com.deosite.tests.tasks.mainMenu.*;
import com.deosite.tests.tasks.order.GoToCheckout;
import com.deosite.tests.tasks.order.PayAfterLogin;
import com.deosite.tests.tasks.product.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.pages.LoginPage.LOGIN_BUTTON;
import static com.deosite.tests.pages.LoginPage.EMAIL_INPUT;
import static com.deosite.tests.pages.MainMenu.SEARCH_BAR;
import static com.deosite.tests.pages.PaymentPage.EPOINTS_BUTTON;
import static com.deosite.tests.pages.PaymentPage.EPOINTS_INPUT;
import static com.deosite.tests.pages.PaymentPage.APPLY_EPOINTS_BUTTON;
import static com.deosite.tests.pages.PaymentPage.DELETE_EPOINTS_BUTTON;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class UseEpoints {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} is about to finalize his transaction using {word}")
    public void that_actor_is_about_to_finalize_his_transaction(String actor, String paymentType) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                WaitUntil.the(LOGIN_BUTTON, isPresent()),
                Open.loginPage(),
                WaitUntil.the(EMAIL_INPUT, isPresent()),
                FillInLoginForm.type("login"),
                SubmitLoginForm.submitLoginForm(),
                WaitUntil.the(SEARCH_BAR, isPresent()),
                MoveMouseToTop.move(),
                ClickCategory.byCategoryNumber(5),
                Scroll.to(CategoryPage.PAGINATION_SELECT),
                ClickCategory.byCategoryNumber(5),
                Open.productPageByPosition(5),
                WaitUntil.the(CategoryPage.CATEGORY_HEADER, isNotPresent()),
                AddProduct.toCart(),
                MoveMouseDown.move(),
                Scroll.to(MiniCart.MINICART_BUTTON),
                MoveMouseDown.move(),
                Open.miniCart(),
                Open.checkoutPage(),
                PayAfterLogin.by(paymentType)
        );
    }

    @When("he adds ePoints")
    public void actor_adds_epoints() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(EPOINTS_BUTTON, isPresent()),
                Click.on(EPOINTS_BUTTON),
                WaitUntil.the(EPOINTS_INPUT, isPresent()),
                SendKeys.of("1").into(EPOINTS_INPUT),
                Click.on(APPLY_EPOINTS_BUTTON),
                WaitUntil.the(DELETE_EPOINTS_BUTTON, isPresent())
        );
    }

    @And("he hits the refresh button")
    public void actor_hits_the_refresh_button() {
        theActorInTheSpotlight().attemptsTo(
                RefreshPage.refresh(),
                WaitUntil.the(DELETE_EPOINTS_BUTTON, isPresent())
        );
    }

    @Then("he should see the discount")
    public void actor_should_see_the_discount() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(DELETE_EPOINTS_BUTTON).isDisplayed(),
                Click.on(DELETE_EPOINTS_BUTTON),
                WaitUntil.the(DELETE_EPOINTS_BUTTON, isNotPresent())
        );
    }
}
