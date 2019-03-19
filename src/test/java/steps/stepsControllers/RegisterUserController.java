package steps.stepsControllers;

import model.User;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.Matchers;
import org.junit.Assert;
import pages.*;
import utils.MailGenerator;

public class RegisterUserController extends ScenarioSteps {

    private BasePage basePage;
    private MainPage mainPage;
    private SignInPage signInPage;
    private RegisterPage registerPage;
    private AccountPage accountPage;

    @Step
    public void openMainPage(String mainPageUrl) {
        basePage.OpenMainPage(mainPageUrl);
    }

    @Step
    public void signInUser() {
        mainPage.headToolBar.signInUser();
    }

    @Step
    public void writeEmail() {
        signInPage.putEmail(MailGenerator.getRandomEmail());
    }

    @Step
    public void writeEmail(String email) {
        signInPage.putEmail(email);
    }

    @Step
    public void createAccount(){
        signInPage.createAccount();
    }


    @Step
    public void fillUserData(User user) {
        registerPage.fillUserData(user);
    }

    @Step
    public void registerUser() {
        registerPage.registerUser();
    }

    @Step
    public void accountPageShouldBeDisplayed() {
        Assert.assertThat("The user was no redirected to user account page:",
                accountPage.getAccountUrlPage(), Matchers.containsString("my-account"));
    }

    @Step
    public void userNameShouldBeInHeadToolBar(String userName) {
        Assert.assertThat("The registered user name is not the same in the account page: ",
                mainPage.headToolBar.getLoggedUser(),Matchers.equalTo(userName));
    }

    @Step
    public void warningMessageShouldBeDisplayed(String warningMessage) {
        Assert.assertThat("The warning message was not displayed: ",
                signInPage.warningMessage.getText(),Matchers.containsString(warningMessage));
    }

    @Step
    public void signInPageShouldBeDisplayed() {
        Assert.assertThat("The sign in page is not displayed: ",
                signInPage.isDisplayed(),Matchers.equalTo(true));
    }

    @Step
    public void registerAlertShouldBeDisplayed(String missingField) {
        Assert.assertThat("The missing data alert was not displayed: ",
                signInPage.alertIsDisplayed(),Matchers.equalTo(true));
        Assert.assertThat("The alert is not indicating the missing field: ",
                signInPage.getAlertMessage(),Matchers.containsString(missingField));
    }
}
