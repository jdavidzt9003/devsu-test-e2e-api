package com.stepdefinitions.compras;

import com.models.PlaceOrderData;
import com.questions.PurchaseConfirmation;
import com.tasks.AddRandomProducts;
import com.tasks.CompletePurchaseForm;
import com.utils.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class ComprasSteps {

    @Given("{string} selecciona dos productos")
    public void selectProducts(String actorName) {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(actorName);
        theActorInTheSpotlight().attemptsTo(
                Open.browserOn().thePageNamed("pages.testPage"));
    }

    @Then("completa el formulario de compra")
    public void completePurchase(List<PlaceOrderData> data) {
        theActorInTheSpotlight().attemptsTo(
                AddRandomProducts.randomly(),
                CompletePurchaseForm.withData(data.get(0))
        );
    }

    @Then("Debera ver la compra realizada exitosamente")
    public void confirmPurchase() {
        theActorInTheSpotlight().should(
                seeThat(PurchaseConfirmation.withText(), equalTo(Constants.SUCCESS_PURCHASE))
        );
    }
}
