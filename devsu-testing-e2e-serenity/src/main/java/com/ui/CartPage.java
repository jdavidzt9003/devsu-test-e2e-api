package com.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {

    private CartPage() {
    }

    public static final Target BUTTON_PLACE_ORDER = Target
            .the("Boton para activar el formulario de compra")
            .locatedBy(".btn.btn-success");
}
