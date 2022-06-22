package com.deosite.tests.features.creating_orders;

import com.deosite.tests.actions.Open;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.MoveMouseToTop;
import com.deosite.tests.tasks.brandPage.ClickBrand;
import com.deosite.tests.tasks.categoryPage.EnsurePageContent;
import com.deosite.tests.tasks.categoryPage.OpenInspirations;
import com.deosite.tests.tasks.categoryPage.SelectCategory;
import com.deosite.tests.tasks.categoryPage.SelectPromotion;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import com.deosite.tests.tasks.order.FillInBillingData;
import com.deosite.tests.tasks.product.AddProduct;
import com.deosite.tests.tasks.product.MoveMouseDown;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.pages.Alert.ALERT_BOX;
import static com.deosite.tests.pages.Alert.CLOSE_ALERT_BOX_BUTTON;
import static com.deosite.tests.pages.CategoryPage.*;
import static com.deosite.tests.pages.CheckoutPage.EMAIL_INPUT;
import static com.deosite.tests.pages.MainMenu.MINI_CART_BUTTON;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class BrowseAndOrderFromCategories {
    @Steps
    SetupSteps setupSteps;

    @Given("that {word} wants to browse and order products from {word}")
    public void alex_wants_to_order_from_categories(String actor, String categoryName){
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                SelectCategory.byName(categoryName),
                WaitUntil.the(CATEGORY_HEADER, isPresent()),
                MoveMouseToTop.move()
        );
    }
    @And("she ensures that {word} contents are present")
    public void wiktoria_ensures_category_page_contents_are_present(String categoryName){
        theActorInTheSpotlight().attemptsTo(
                EnsurePageContent.by(categoryName)
        );

    }
    @Given("that {word} wants to browse and order products from {word} page")
    public void alex_wants_to_order_from_marki(String actor, String categoryName){
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(9),
                MoveMouseToTop.move(),
                EnsurePageContent.by(categoryName),
                ClickBrand.byBrand(0)
        );
    }


    @Given("that {word} wants to browse and order products from {word} list")
    public void alex_wants_to_order_from_inspiracji(String actor, String categoryName){
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(10),
                MoveMouseToTop.move(),
                EnsurePageContent.by(categoryName),
                WaitUntil.the(CATEGORY_HEADER, isPresent()),
                Scroll.to(INSPIRATIONS_BANNER_1),
                OpenInspirations.by(1)
        );
    }
    @Given("that {word} wants to browse and order products from {word} category")
    public void alex_wants_to_order_from_promocje(String actor, String categoryName) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(8),
                MoveMouseToTop.move(),
                WaitUntil.the(CATEGORY_HEADER, isPresent()).forNoMoreThan(10).seconds(),
                EnsurePageContent.by(categoryName),
                Scroll.to(FIRST_PROMOTION_BANNER),
                SelectPromotion.by(2)
        );

    }

    @When("she adds a product from category page")
    public void alex_adds_product_from_category_page(){
        theActorInTheSpotlight().attemptsTo(
                Scroll.to(CATEGORY_HEADER),
                Open.productPageByPositionRandomly(),
                AddProduct.toCart(),
                WaitUntil.the(ALERT_BOX, isPresent()),
                Click.on(CLOSE_ALERT_BOX_BUTTON),
                MoveMouseDown.move(),
                MoveMouse.to(MINI_CART_BUTTON),
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

