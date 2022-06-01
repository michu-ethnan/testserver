package com.deosite.tests.tasks.order;

import com.deosite.tests.actions.Open;
import com.deosite.tests.actions.Search;
import com.deosite.tests.pages.CategoryPage;
import com.deosite.tests.pages.MiniCart;
import com.deosite.tests.tasks.product.AddProduct;
import com.deosite.tests.tasks.product.MoveMouseDown;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.CheckoutPage.EMAIL_INPUT;
import static com.deosite.tests.pages.MainMenu.MINI_CART_BUTTON;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class CheckoutWithProduct implements Task {

    private final String product;

    public CheckoutWithProduct(String product) {
        this.product = product;
    }

    @Override
    @Step("{0} goes to checkout with #product")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Search.forProductByTranslatedKeyword(product),
                Open.productPageByPositionRandomly(),
                AddProduct.toCart(),
                MoveMouseDown.move(),
                MoveMouse.to(MINI_CART_BUTTON),
                Open.miniCart(),
                Open.checkoutPage()
        );
    }
}