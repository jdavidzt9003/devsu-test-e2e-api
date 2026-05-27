package com.interactions;

import com.ui.CartPage;
import com.ui.HomePage;
import com.ui.ModalPlaceOrderPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class OpenPlaceOrder implements Interaction {

    public static OpenPlaceOrder openPlaceOrder() {
        return Tasks.instrumented(OpenPlaceOrder.class);
    }

    @Override
    @Step("{0} Da clic para completar el formulario")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.LINK_CART),
                Click.on(CartPage.BUTTON_PLACE_ORDER),

                WaitUntil.the(
                        ModalPlaceOrderPage.ORDER_MODAL,
                        WebElementStateMatchers.isVisible()
                ).forNoMoreThan(10).seconds()
        );
    }
}
