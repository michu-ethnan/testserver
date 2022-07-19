package com.deosite.tests.features.creating_orders;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.MiniCart;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.categoryPage.SelectBrandPage;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import com.deosite.tests.tasks.product.AddProduct;
import com.deosite.tests.tasks.product.MoveMouseDown;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class OrderFromMarki {
    @Steps
    SetupSteps setupSteps;
    @Given("that {word} is on {word} page")
    public void actor_is_on_a_selected_brand_page(String actor, String brandName){
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(9),
                SelectBrandPage.byName(brandName)
        );
    }
    @When("he adds product from brand page")
    public void actor_adds_product_from_brand_page(){
        theActorInTheSpotlight().attemptsTo(
                Open.productPageByPosition(0),
                AddProduct.toCart(),
                MoveMouseDown.move(),
                MoveMouse.to(MiniCart.MINICART_BUTTON),
                Open.miniCart()
        );
    }
}