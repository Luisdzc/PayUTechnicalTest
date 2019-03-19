package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import model.User;
import net.thucydides.core.annotations.Steps;
import steps.stepsControllers.LoginController;
import steps.stepsControllers.RegisterUserController;

import java.util.List;

public class LoginSteps {

    @Steps
    RegisterUserController registerUserController;
    @Steps
    LoginController loginController;

    @Given("^the user is logged into the platform with the data$")
    public void theUserIsLoggedIntoThePlatformWithTheData(List<User> userInfo) {
        registerUserController.signInUser();
        loginController.logUser(userInfo.get(0));
    }
}
