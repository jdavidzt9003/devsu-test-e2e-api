package com.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ModalPlaceOrderPage {

    private ModalPlaceOrderPage() {
    }

    public static final Target ORDER_MODAL =
            Target.the("Modal Place Order")
                    .locatedBy("//div[@id='orderModal']");

    public static final Target INPUT_NAME =
            Target.the("Name")
                    .locatedBy("//input[@id='name']");

    public static final Target INPUT_COUNTRY =
            Target.the("Country")
                    .locatedBy("//input[@id='country']");

    public static final Target INPUT_CITY =
            Target.the("City")
                    .locatedBy("//input[@id='city']");

    public static final Target INPUT_CREDIT_CARD =
            Target.the("Credit Card")
                    .locatedBy("//input[@id='card']");

    public static final Target INPUT_MONTH =
            Target.the("Month")
                    .locatedBy("//input[@id='month']");

    public static final Target INPUT_YEAR =
            Target.the("Year")
                    .locatedBy("//input[@id='year']");

    public static final Target BUTTON_PURCHASE =
            Target.the("Boton para finalizar la compra")
                    .locatedBy("//button[text()='Purchase']");

    public static final Target SUCCESS_MESSAGE =
            Target.the("Compra exitosa")
                    .locatedBy("//h2[text()='Thank you for your purchase!']");

}
