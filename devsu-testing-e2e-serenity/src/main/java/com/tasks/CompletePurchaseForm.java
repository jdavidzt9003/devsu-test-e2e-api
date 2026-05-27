package com.tasks;

import com.interactions.OpenPlaceOrder;
import com.models.PlaceOrderData;
import com.ui.ModalPlaceOrderPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class CompletePurchaseForm implements Task {

    private final PlaceOrderData data;

    public CompletePurchaseForm(PlaceOrderData data) {
        this.data = data;
    }

    public static CompletePurchaseForm withData(PlaceOrderData data) {
        return Tasks.instrumented(CompletePurchaseForm.class, data);
    }

    @Override
    @Step("{0} completar la solicitud")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                OpenPlaceOrder.openPlaceOrder(),
                Enter.theValue(data.getName()).into(ModalPlaceOrderPage.INPUT_NAME),
                Enter.theValue(data.getCountry()).into(ModalPlaceOrderPage.INPUT_COUNTRY),
                Enter.theValue(data.getCity()).into(ModalPlaceOrderPage.INPUT_CITY),
                Enter.theValue(data.getCreditCard()).into(ModalPlaceOrderPage.INPUT_CREDIT_CARD),
                Enter.theValue(data.getMonth()).into(ModalPlaceOrderPage.INPUT_MONTH),
                Enter.theValue(data.getYear()).into(ModalPlaceOrderPage.INPUT_YEAR),
                Click.on(ModalPlaceOrderPage.BUTTON_PURCHASE)
        );
    }
}
