package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.User;
import net.thucydides.core.annotations.Steps;
import steps.stepsControllers.RegisterUserController;

import java.util.List;

public class RegisterUserSteps {

    @Steps
    RegisterUserController registerUserController;


    @Given("^the user is in the page \"([^\"]*)\"$")
    public void theUserIsInThePage(String mainPageUrl){
        registerUserController.openMainPage(mainPageUrl);
    }

    @And("^the user clicks in the sing in option$")
    public void theUserClicksInTheSingInOption(){
        registerUserController.signInUser();
    }

    @Given("^the user wants to register in the platform with the next data$")
    public void theUserWantsToRegisterInThePlatformWithTheNextData(List<User> userToRegister){
        registerUserController.writeEmail();
        registerUserController.createAccount();
        registerUserController.fillUserData(userToRegister.get(0));
    }

    @When("^the user selects the register option$")
    public void theUserSelectsTheRegisterOption(){
        registerUserController.registerUser();
    }

    @Then("^the user is redirected to the account user page$")
    public void theUserIsRedirectedToTheAccountUserPage(){
        registerUserController.accountPageShouldBeDisplayed();
    }

    @And("^the user name \"([^\"]*)\" is displayed in the head tool bar$")
    public void theUserNameIsDisplayedInTheHeadToolBar(String userName){
        registerUserController.userNameShouldBeInHeadToolBar(userName);
    }

    @Given("^a user that wants to sign in with the email \"([^\"]*)\"$")
    public void aUserThatWantsToSignInWithTheEmail(String email){
        registerUserController.writeEmail(email);
    }

    @When("^the user selects create an account button$")
    public void theUserSelectsCreateAnAccountButton() {
        registerUserController.createAccount();
    }

    @Then("^the \"([^\"]*)\" message should be displayed$")
    public void theMessageShouldBeDisplayed(String warningMessage){
        registerUserController.warningMessageShouldBeDisplayed(warningMessage);
    }

    @And("^the page keeps in the sign in page$")
    public void thePageKeepsInTheSignInPage(){
        registerUserController.signInPageShouldBeDisplayed();
    }

    @Then("^the register should fail showing an alert indicating the missing field \"([^\"]*)\"$")
    public void theRegisterShouldFailShowingAnAlertIndicatingTheMissingField(String missingField){
        registerUserController.registerAlertShouldBeDisplayed(missingField);
    }
}
