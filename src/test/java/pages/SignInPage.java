package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.logging.XMLFormatter;

public class SignInPage extends BasePage {


    @FindBy(xpath = "//input[@name='email_create']")
    private WebElement emailForCreateAccount;
    @FindBy(xpath = "//button[@id='SubmitCreate']")
    private WebElement createAccountButton;
    @FindBy(xpath = "//ol//li")
    public WebElement warningMessage;
    @FindBy(xpath = "//h3[contains(text(),'Create an account')]")
    private WebElement createAnAccountPanel;
    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement alertPopUp;

    public SignInPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void putEmail(String randomEmail) {
        webDriverWait.until(ExpectedConditions.visibilityOf(emailForCreateAccount)).sendKeys(randomEmail);
    }

    public void createAccount(){
        createAccountButton.click();
    }

    public boolean isDisplayed(){
        return createAccountButton.isDisplayed();
    }

    public boolean alertIsDisplayed() {
        return alertPopUp.isDisplayed();
    }

    public String getAlertMessage() {
        return alertPopUp.getText();
    }
}
