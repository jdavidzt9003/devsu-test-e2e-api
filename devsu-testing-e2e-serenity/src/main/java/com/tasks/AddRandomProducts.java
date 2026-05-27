package com.tasks;

import com.ui.HomePage;
import com.ui.ProductPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

public class AddRandomProducts implements Task {

    @Override
    @Step("{0} selecciona productos")
    public <T extends Actor> void performAs(T actor) {

        Random random = new Random();
        int contadorProductos = 0;

        while (contadorProductos < 2) {
            int total =
                    HomePage.PRODUCT_CARDS.resolveAllFor(actor).size();

            int first = random.nextInt(total) + 1;

            actor.attemptsTo(
                    Click.on(HomePage.getProductByIndex(first)),
                    Click.on(ProductPage.BUTTON_ADD_PRODUCT),
                    WaitUntil.the(ExpectedConditions.alertIsPresent()),
                    Switch.toAlert().andAccept(),
                    Click.on(HomePage.LINK_HOME)
            );

            contadorProductos++;
        }
    }

    public static AddRandomProducts randomly() {
        return Tasks.instrumented(AddRandomProducts.class);
    }
}
