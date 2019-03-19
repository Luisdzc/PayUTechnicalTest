package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.stepsControllers.AddProductController;

public class AddProductSteps {

    @Steps
    private AddProductController addProductController;

    @Given("^the user selects the first product for add it to the shopping cart$")
    public void theUserSelectsTheFirstProductForAddItToTheShoppingCart(){
        addProductController.selectProductToAdd();
        addProductController.getSelectedProductInfo();
    }

    @When("^the user clicks on add to cart$")
    public void theUserClicksOnAddToCart(){
        addProductController.addSelectedProduct();
    }

    @Then("^the successfully added message \"([^\"]*)\" should be displayed$")
    public void theSuccessfullyAddedMessageShouldBeDisplayed(String operationMessage){
        addProductController.successfullyMessageShouldBeDisplayed(operationMessage);
    }

    @And("^the information of the product should be the same of the selected product$")
    public void theInformationOfTheProductShouldBeTheSameOfTheSelectedProduct(){
        addProductController.addedProductShouldBe();
    }

    @When("^the user adds the already added product to the cart$")
    public void theUserAddsTheAlreadyAddedProductToTheCart(){
        addProductController.selectProductToAdd();
        addProductController.addSelectedProduct();
    }

    @And("^the shopping cart has \"([^\"]*)\" entries$")
    public void theShoppingCartHasEntries(String entries){
        addProductController.shoppingCartHas(entries);
    }

    @And("^the user goes to the shopping cart page$")
    public void theUserGoesToTheShoppingCartPage(){
        addProductController.openShoppingCart();
    }

    @When("^the user selects delete item$")
    public void theUserSelectsDeleteItem(){
        addProductController.deleteItemFromCart();
    }

    @Then("^the shopping car should have a \"([^\"]*)\" message$")
    public void theShoppingCarShouldHaveAMessage(String emptyMessage){
        addProductController.shoppingCartShouldBeEmpty(emptyMessage);
    }
}
