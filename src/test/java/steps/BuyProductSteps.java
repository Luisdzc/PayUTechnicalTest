package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.stepsControllers.BuyProductController;
import steps.stepsControllers.RegisterUserController;

public class BuyProductSteps {

    @Steps
    private BuyProductController buyProductController;
    @Steps
    private RegisterUserController registerUserController;

    @And("^the user clicks in the checkout option$")
    public void theUserClicksInTheCheckoutOption(){
        buyProductController.proceedToCheckout();
    }

    @Then("^the sign in page should be displayed$")
    public void theSignInPageShouldBeDisplayed(){
        registerUserController.signInPageShouldBeDisplayed();
    }

    @Then("^the address details should be displayed$")
    public void theAddressDetailsShouldBeDisplayed(){
        buyProductController.addressDetailShouldBeDisplayed();
    }

    @And("^the user execute all the checkout states$")
    public void theUserExecuteAllTheCheckoutStates(){
        buyProductController.executeCompleteCheckout();
    }

    @When("^the user execute the payment$")
    public void theUserExecuteThePayment(){
        buyProductController.confirmOrder();
    }

    @Then("^the successfully buy message \"([^\"]*)\" should be displayed$")
    public void theSuccessfullyBuyMessageShouldBeDisplayed(String confirmationMessage){
        buyProductController.successBuyMessageShouldBe(confirmationMessage);
    }
}
