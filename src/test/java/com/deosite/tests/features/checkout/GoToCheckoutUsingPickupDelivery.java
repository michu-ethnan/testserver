package com.deosite.tests.features.checkout;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.MiniCart;
import com.deosite.tests.pages.PaymentPage;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import com.deosite.tests.tasks.order.FillInBillingData;
import com.deosite.tests.tasks.order.SelectPickupLocationByName;
import com.deosite.tests.tasks.product.AddProduct;
import com.deosite.tests.tasks.product.MoveMouseDown;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.pages.CheckoutPage.SUBMIT_BUTTON;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class GoToCheckoutUsingPickupDelivery {
    @Steps
    SetupSteps setupSteps;

    @Given("that {word} happens to be on the checkout with a product")
    public void ellen_goes_to_checkout(String actor){
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(7),
                Open.productPageByPositionRandomly(),
                AddProduct.toCart(),
                MoveMouseDown.move(),
                MoveMouse.to(MiniCart.MINICART_BUTTON),
                Open.miniCart(),
                Open.checkoutPage()
        );
    }
    @When("she selects delivery type pickup and chooses {word} as a {word}")
    public void ellen_selects_pick_up_point(String locationName, String userType){
        theActorInTheSpotlight().attemptsTo(
                SelectPickupLocationByName.byLocationName(locationName),
                FillInBillingData.type(userType),
                WaitUntil.the(SUBMIT_BUTTON, isClickable()).forNoMoreThan(100).seconds()

        );
    }

}
