package com.deosite.tests.features.coupon_codes_and_epoints;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.*;
import com.deosite.tests.questions.checkout.DiscountPrice;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.RefreshPage;
import com.deosite.tests.tasks.basic.ReturnToPreviousPage;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import com.deosite.tests.tasks.order.FillInBillingData;
import com.deosite.tests.tasks.product.AddProduct;
import com.deosite.tests.tasks.product.MoveMouseDown;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import java.math.BigDecimal;

import static com.deosite.tests.pages.Alert.CLOSE_ALERT_BOX_BUTTON;
import static com.deosite.tests.pages.CheckoutPage.*;
import static com.deosite.tests.pages.HomePage.DAJAR_LOGO;
import static com.deosite.tests.pages.MainMenu.*;
import static com.deosite.tests.pages.MainMenu.NEWSLETTER_POPUP_CLOSE_BUTTON;
import static com.deosite.tests.pages.PaymentPage.COUPON_CODE_BUTTON;
import static com.deosite.tests.pages.PaymentPage.COUPON_CODE_INPUT;
import static com.deosite.tests.pages.ProductPage.ADD_TO_CART_BUTTON;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class AddProductAfterApplyingCouponCodeAndCheckThePrice {
    @Steps
    SetupSteps setupSteps;

    BigDecimal firstDiscountPrice;
    BigDecimal secondDiscountPrice;

    @Given("that {word} is on the checkout page")
    public void actor_is_on_the_checkout_page(String actor){
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(7),
                Open.productPageByPositionRandomly(),
                AddProduct.toCart(),
                WaitUntil.the(CLOSE_ALERT_BOX_BUTTON, isPresent()).forNoMoreThan(10).seconds(),
                Click.on(CLOSE_ALERT_BOX_BUTTON),
                RefreshPage.refresh(),
                WaitUntil.the(NEWSLETTER_POPUP, isPresent()).forNoMoreThan(10).seconds(),
                Click.on(NEWSLETTER_POPUP_CLOSE_BUTTON),
                MoveMouseDown.move(),
                WaitUntil.the(MINI_CART_BUTTON, isClickable()),
                MoveMouse.to(MINI_CART_BUTTON),
                Open.miniCart(),
                Open.checkoutPage()

        );

    }
    @Given("that {word} is on the payment page as a {word}")
    public void actor_is_on_the_payment_page(String actor, String userType){
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(7),
                Open.productPageByPositionRandomly(),
                AddProduct.toCart(),
                WaitUntil.the(CLOSE_ALERT_BOX_BUTTON, isPresent()).forNoMoreThan(10).seconds(),
                Click.on(CLOSE_ALERT_BOX_BUTTON),
                RefreshPage.refresh(),
                WaitUntil.the(NEWSLETTER_POPUP, isPresent()).forNoMoreThan(10).seconds(),
                Click.on(NEWSLETTER_POPUP_CLOSE_BUTTON),
                MoveMouseDown.move(),
                MoveMouse.to(MINI_CART_BUTTON),
                WaitUntil.the(MINI_CART_BUTTON, isClickable()),
                Open.miniCart(),
                Open.checkoutPage(),
                FillInBillingData.type(userType),
                Click.on(SUBMIT_BUTTON),
                WaitUntil.the(CheckoutPage.DELIVERY_TYPE_COURIER, isNotPresent())


        );

    }

    @When("he applies a coupon code on checkout page")
    public void actor_applies_coupon_code_on_payment_page(){
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CheckoutPage.COUPON_CODE_BUTTON, isPresent()),
                Click.on(COUPON_CODE_BUTTON),
                SendKeys.of("ABC123").into(COUPON_CODE_INPUT),
                Click.on(APPLY_COUPON_CODE_BUTTON),
                WaitUntil.the(DELETE_COUPON_CODE_BUTTON, isPresent()).forNoMoreThan(50).seconds()

        );
    }
    @When("he applies a coupon code on payment page")
    public void actor_applies_coupon_code_on_checkout_page(){
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(COUPON_CODE_BUTTON, isPresent()),
                Click.on(COUPON_CODE_BUTTON),
                SendKeys.of("ABC123").into(COUPON_CODE_INPUT),
                Click.on(APPLY_COUPON_CODE_BUTTON)
        );
    }
    @And("he sees the discount price on checkout page")
    public void actor_sees_the_discounted_price(){
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(DISCOUNT_PRICE_HEADER, isPresent()),
                WaitUntil.the(DISCOUNT_PRICE, isPresent()).forNoMoreThan(50).seconds()
        );
        firstDiscountPrice = DiscountPrice.discount().answeredBy(theActorInTheSpotlight());

    }
    @And("he sees the discount price on payment page")
    public void actor_sees_the_discount_price_on_payment_page(){
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(DISCOUNT_PRICE_HEADER, isPresent()),
                WaitUntil.the(DISCOUNT_PRICE, isPresent()).forNoMoreThan(50).seconds()
        );
        firstDiscountPrice = DiscountPrice.discount().answeredBy(theActorInTheSpotlight());

    }
    @And("he returns from checkout page and adds another product to cart")
    public void actor_returns_from_checkout_and_adds_another_product(){
        theActorInTheSpotlight().attemptsTo(
                ReturnToPreviousPage.goToPreviousPage(),
                WaitUntil.the(ADD_TO_CART_BUTTON, isPresent()),
                MoveMouseDown.move(),
                MoveMouse.to(MainMenu.FIRST_MAIN_CATEGORY),
                ReturnToPreviousPage.goToPreviousPage(),
                ClickCategory.byCategoryNumber(5),
                Open.productPageByPositionRandomly(),
                AddProduct.toCart(),
                WaitUntil.the(CLOSE_ALERT_BOX_BUTTON, isPresent()).forNoMoreThan(10).seconds(),
                Click.on(CLOSE_ALERT_BOX_BUTTON),
                MoveMouseDown.move(),
                MoveMouse.to(MINI_CART_BUTTON)


        );
    }
    @And("he returns from payment page and adds another product to cart")
    public void actor_returns_to_homepage_and_adds_another_product(){
        theActorInTheSpotlight().attemptsTo(
                ReturnToPreviousPage.goToPreviousPage(),
                ReturnToPreviousPage.goToPreviousPage(),
                WaitUntil.the(ADD_TO_CART_BUTTON, isPresent()),
                MoveMouseDown.move(),
                MoveMouse.to(MainMenu.FIRST_MAIN_CATEGORY),
                ClickCategory.byCategoryNumber(5),
                Open.productPageByPositionRandomly(),
                AddProduct.toCart(),
                WaitUntil.the(CLOSE_ALERT_BOX_BUTTON, isPresent()).forNoMoreThan(10).seconds(),
                Click.on(CLOSE_ALERT_BOX_BUTTON),
                MoveMouseDown.move(),
                MoveMouse.to(MINI_CART_BUTTON)


        );
    }
    @When("he goes to checkout page")
    public void actor_goes_to_checkout_page(){
        theActorInTheSpotlight().attemptsTo(
                Open.miniCart(),
                Open.checkoutPage(),
                WaitUntil.the(EMAIL_INPUT, isPresent()).forNoMoreThan(50).seconds()
        );
        secondDiscountPrice = DiscountPrice.discount().answeredBy(theActorInTheSpotlight());
    }
    @When("he goes to the payment page")
    public void actor_goes_to_the_payment_page(){
        theActorInTheSpotlight().attemptsTo(
                Open.miniCart(),
                Open.checkoutPage(),
                WaitUntil.the(SUBMIT_BUTTON, isPresent()).forNoMoreThan(50).seconds(),
                Click.on(SUBMIT_BUTTON),
                WaitUntil.the(CheckoutPage.DELIVERY_TYPE_COURIER, isNotPresent())
        );
        secondDiscountPrice = DiscountPrice.discount().answeredBy(theActorInTheSpotlight());
    }

    @Then("he should see that the discount price is higher")
    public void actor_should_see_that_the_discount_price_is_higher(){
        theActorInTheSpotlight().attemptsTo();
        Ensure.that(secondDiscountPrice).isGreaterThan(firstDiscountPrice);

    }


}
