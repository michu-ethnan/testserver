package com.deosite.tests.features.coupon_codes_and_epoints;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.*;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.ReturnToPreviousPage;
import com.deosite.tests.tasks.basic.RefreshPage;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import com.deosite.tests.tasks.order.FillInBillingData;
import com.deosite.tests.tasks.order.Pay;
import com.deosite.tests.tasks.product.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.pages.CheckoutPage.EMAIL_INPUT;
import static com.deosite.tests.pages.CheckoutPage.APPLY_COUPON_CODE_BUTTON;
import static com.deosite.tests.pages.CheckoutPage.SUBMIT_BUTTON;
import static com.deosite.tests.pages.PaymentPage.COUPON_CODE_BUTTON;
import static com.deosite.tests.pages.PaymentPage.COUPON_CODE_INPUT;
import static com.deosite.tests.pages.PaymentPage.DELETE_COUPON_CODE_BUTTON;
import static com.deosite.tests.pages.PaymentPage.FREE_DELIVERY_NOTIFICATION;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
public class EnterCouponCodeWithDiscountHigherThanOrderValue {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} is going to finalize her transaction as {word} using {word}")
    public void that_actor_is_going_to_finalize_her_transaction(String actor, String userType, String paymentType) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(5),
                Open.productPageByPosition(7),
                AddProduct.toCart(),
                WaitUntil.the(MainMenu.SEARCH_BAR, isPresent()),
                MoveMouseDown.move(),
                Scroll.to(MiniCart.MINICART_BUTTON),
                Open.miniCart(),
                Open.checkoutPage(),
                WaitUntil.the(EMAIL_INPUT, isPresent()).forNoMoreThan(50).seconds(),
                FillInBillingData.type(userType),
                Pay.by(paymentType)
        );
    }

    @When("she adds a coupon code with discount higher than the order value")
    public void actor_adds_a_coupon_code_with_discount_higher_than_the_order_value() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(COUPON_CODE_BUTTON),
                WaitUntil.the(COUPON_CODE_INPUT, isPresent()),
                SendKeys.of("nierealizowac2014").into(COUPON_CODE_INPUT),
                Click.on(APPLY_COUPON_CODE_BUTTON),
                WaitUntil.the(FREE_DELIVERY_NOTIFICATION, isPresent())
        );
    }

    @And("she removes the coupon code")
    public void actor_removes_the_coupon_code() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(DELETE_COUPON_CODE_BUTTON),
                WaitUntil.the(FREE_DELIVERY_NOTIFICATION, isNotVisible())
        );
    }

    @And("she navigates back to the previous page")
    public void actor_navigates_back_to_the_previous_page() {
        theActorInTheSpotlight().attemptsTo(
                ReturnToPreviousPage.goToPreviousPage(),
                WaitUntil.the(EMAIL_INPUT, isPresent()),
                Click.on(SUBMIT_BUTTON),
                WaitUntil.the(FREE_DELIVERY_NOTIFICATION, isPresent())

        );
    }

    @And("she reloads the page")
    public void actor_reloads_the_page() {
        theActorInTheSpotlight().attemptsTo(
                RefreshPage.refresh(),
                WaitUntil.the(FREE_DELIVERY_NOTIFICATION, isPresent())
        );
    }

    @Then("she should see a notification on the lack of any surcharge")
    public void actor_should_see_a_notification_on_the_lack_of_any_surcharge() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(FREE_DELIVERY_NOTIFICATION).isDisplayed()
        );
    }

    @Then("she should see that the notification is not visible")
    public void actor_should_see_that_the_notification_is_not_visible() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(FREE_DELIVERY_NOTIFICATION).isNotDisplayed()
        );
    }
}
