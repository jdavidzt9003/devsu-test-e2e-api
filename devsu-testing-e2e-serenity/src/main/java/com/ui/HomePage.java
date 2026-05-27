package com.ui;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    private HomePage() {
    }

    public static Target getProductByIndex(int index){
        return Target.the("Obtener producto por indice")
                .locatedBy("(//*[@class='card-img-top img-fluid'])[" + index + "]");
    }

    public static final Target PRODUCT_CARDS = Target
            .the("Productos")
            .locatedBy(".card-img-top.img-fluid");

    public static final Target LINK_HOME = Target
            .the("Link rel hacia home")
            .locatedBy("//a[@class='nav-link' and text()='Home ']");

    public static final Target LINK_CART = Target
            .the("Link rel hacia el carrito de compras")
            .locatedBy("//a[@class='nav-link' and text()='Cart']");
}
