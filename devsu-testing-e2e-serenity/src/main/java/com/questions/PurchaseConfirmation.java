package com.questions;

import com.ui.ModalPlaceOrderPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class PurchaseConfirmation implements Question<String> {

    public static PurchaseConfirmation withText() {
        return new PurchaseConfirmation();
    }

    @Override
    @Step("{0} Validar compra exitosa")
    public String answeredBy(Actor actor) {
        return ModalPlaceOrderPage.SUCCESS_MESSAGE.resolveFor(actor).getText();
    }
}
