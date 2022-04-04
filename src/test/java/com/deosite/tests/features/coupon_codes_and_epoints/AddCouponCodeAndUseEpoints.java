package com.deosite.tests.features.coupon_codes_and_epoints;

import com.deosite.tests.actions.*;
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

import static com.deosite.tests.pages.CheckoutPage.APPLY_COUPON_CODE_BUTTON;
import static com.deosite.tests.pages.LoginPage.EMAIL_INPUT;
import static com.deosite.tests.pages.LoginPage.LOGIN_BUTTON;
import static com.deosite.tests.pages.MainMenu.SEARCH_BAR;
import static com.deosite.tests.pages.PaymentPage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class AddCouponCodeAndUseEpoints {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} is able to log in")
    public void that_actor_is_able_to_log_in(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                WaitUntil.the(LOGIN_BUTTON, isPresent()),
                Open.loginPage(),
                WaitUntil.the(EMAIL_INPUT, isPresent()),
                FillInLoginForm.type("login"),
                SubmitLoginForm.submitLoginForm()
                //MoveMouseDown.move()
        );
    }

    @When("she wants to submit an order and pay using {word}")
    public void actor_wants_to_submit_an_order(String paymentType) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(SEARCH_BAR, isPresent()),
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

    @And("she applies a coupon code")
    public void actor_applies_a_coupon_code() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(COUPON_CODE_BUTTON, isPresent()),
                Click.on(COUPON_CODE_BUTTON),
                WaitUntil.the(COUPON_CODE_INPUT, isPresent()),
                Click.on(PaymentPage.COUPON_CODE_INPUT),
                SendKeys.of("ABC123").into(PaymentPage.COUPON_CODE_INPUT),
                Click.on(APPLY_COUPON_CODE_BUTTON),
                WaitUntil.the(PaymentPage.DELETE_COUPON_CODE_BUTTON, isPresent())
        );
    }

    @And("she enters epoints")
    public void actor_enters_epoints() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(EPOINTS_BUTTON),
                WaitUntil.the(EPOINTS_INPUT, isPresent()),
                SendKeys.of("1").into(EPOINTS_INPUT),
                Click.on(APPLY_EPOINTS_BUTTON),
                WaitUntil.the(DELETE_EPOINTS_BUTTON, isPresent())
        );
    }

    @Then("she should see that the coupon code discount is visible")
    public void actor_should_see_that_the_coupon_code_discount_is_visible() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(DELETE_COUPON_CODE_BUTTON).isDisplayed()
        );
    }

    @And("she should see that the epoints discount is visible")
    public void actor_should_see_that_the_epoints_discount_is_visible() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(EPOINTS_DISCOUNT).isDisplayed()
        );
    }

    @And("remove discounts")
    public void remove_discounts() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(DELETE_COUPON_CODE_BUTTON, isClickable()),
                Click.on(DELETE_COUPON_CODE_BUTTON),
                //WaitUntil.the(DELETE_COUPON_CODE_BUTTON, isNotVisible()),
                Click.on(DELETE_EPOINTS_BUTTON),
                WaitUntil.the(DELETE_EPOINTS_BUTTON, isNotPresent())
        );
    }
}
