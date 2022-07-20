package com.deosite.tests.tasks.login;

import com.deosite.tests.abilities.Load;
import com.deosite.tests.actions.Open;
import com.deosite.tests.model.login.DifferentLoginForm;
import com.deosite.tests.pages.AccountPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.AccountPage.EMAIL_ADDRESS;
import static com.deosite.tests.pages.LoginPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class FillInLoginFormWithDifferentEmailAddress implements Task {

    private final String userType;

    public FillInLoginFormWithDifferentEmailAddress(String userType) {
        this.userType = userType;
    }

    @Override
    @Step("{0} fills in login form with different email address")
    public <T extends Actor> void performAs(T actor) {

        DifferentLoginForm differentLoginForm = Load.as(actor).loginWithDifferentEmailAddress(userType);

        actor.attemptsTo(
                WaitUntil.the(LOGIN_BUTTON, isPresent()),
                Click.on(LOGIN_BUTTON),
                WaitUntil.the(EMAIL_INPUT, isPresent()).forNoMoreThan(50).seconds(),
                SendKeys.of(differentLoginForm.getEmail()).into(EMAIL_INPUT));
        actor.attemptsTo(
                WaitUntil.the(PASSWORD_INPUT, isPresent()),
                SendKeys.of(differentLoginForm.getPassword()).into(PASSWORD_INPUT));
        actor.attemptsTo(
                WaitUntil.the(SUBMIT_BUTTON, isClickable()),
                Click.on(SUBMIT_BUTTON),
                WaitUntil.the(SUBMIT_BUTTON, isNotPresent()).forNoMoreThan(10).seconds(),
                Open.accountPage(),
                WaitUntil.the(EMAIL_ADDRESS, isPresent()).forNoMoreThan(10).seconds()
        );
    }

    public static Task type(String userType) {
        return Instrumented.instanceOf(FillInLoginFormWithDifferentEmailAddress.class).withProperties(userType);
    }
}
