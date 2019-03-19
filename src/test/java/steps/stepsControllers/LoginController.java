package steps.stepsControllers;

import model.User;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SignInPage;

public class LoginController extends ScenarioSteps {

    private SignInPage signInPage;


    public void logUser(User user) {
        signInPage.logUser(user);
    }
}
