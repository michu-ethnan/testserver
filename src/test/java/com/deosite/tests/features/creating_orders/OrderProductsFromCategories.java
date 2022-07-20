package com.deosite.tests.features.creating_orders;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.MiniCart;
import com.deosite.tests.pages.PaymentPage;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.MoveMouseToTop;
import com.deosite.tests.tasks.brandPage.ClickBrand;
import com.deosite.tests.tasks.categoryPage.OpenInspirations;
import com.deosite.tests.tasks.categoryPage.SelectCategory;
import com.deosite.tests.tasks.categoryPage.SelectPromotion;
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
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.pages.CategoryPage.CATEGORY_HEADER;
import static com.deosite.tests.pages.CheckoutPage.EMAIL_INPUT;
import static com.deosite.tests.pages.CheckoutPage.SUBMIT_BUTTON;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class OrderProductsFromCategories {
    @Steps
    SetupSteps setupSteps;

@Given("that {word} wants to order products from {word}")
    public void alex_wants_to_order_from_categories(String actor, String categoryName){
    theActorCalled(actor).wasAbleTo(
            Setup.site(),
            SelectCategory.byName(categoryName),
            WaitUntil.the(CATEGORY_HEADER, isPresent())
    );
}
    @Given("that {word} wants to order products from Marki page")
    public void alex_wants_to_order_from_marki(String actor){
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(9),
                MoveMouseToTop.move(),
                WaitUntil.the(CATEGORY_HEADER, isPresent()),
                ClickBrand.byBrandName(0)
        );
}

    @Given("that {word} wants to order products from Inspiracje page")
    public void alex_wants_to_order_from_inspiracji(String actor){
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(10),
                MoveMouseToTop.move(),
                WaitUntil.the(CATEGORY_HEADER, isPresent()),
                MoveMouseToTop.move(),
                OpenInspirations.by(2)
        );
    }
    @Given("that {word} wants to order products from Promocje page")
    public void alex_wants_to_order_from_promocje(String actor){
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(8),
                MoveMouseToTop.move(),
                WaitUntil.the(CATEGORY_HEADER, isPresent()),
                MoveMouseToTop.move(),
                SelectPromotion.by(0)
        );
    }

@When("she adds a product from category page")
    public void alex_adds_product_from_category_page(){
    theActorInTheSpotlight().attemptsTo(
            Open.productPageByPositionRandomly(),
            AddProduct.toCart(),
            MoveMouseDown.move(),
            MoveMouse.to(MiniCart.MINICART_BUTTON),
            Open.miniCart()

    );

}
@And("goes to checkout as a {word}")
    public void alex_goes_to_checkout_as_a_person(String userType){
           theActorInTheSpotlight().attemptsTo(
                   Open.checkoutPage(),
                   WaitUntil.the(EMAIL_INPUT, isPresent()).forNoMoreThan(50).seconds(),
                   FillInBillingData.type(userType)
           );
}
}

