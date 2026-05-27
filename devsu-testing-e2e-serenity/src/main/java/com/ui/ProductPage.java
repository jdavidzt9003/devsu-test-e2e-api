package com.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ProductPage {

    private ProductPage(){

    }

    public static final Target BUTTON_ADD_PRODUCT = Target
            .the("Boton para agregar producto")
            .locatedBy("//a[text()='Add to cart']");
}
