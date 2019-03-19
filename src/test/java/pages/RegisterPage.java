package pages;

import model.User;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {

    @FindBy(id = "account-creation_form")
    private WebElement userForm;
    @FindBy(id = "customer_firstname")
    private WebElement firstName;
    @FindBy(id = "customer_lastname")
    private WebElement lastName;
    @FindBy(id = "passwd")
    private WebElement password;
    @FindBy(xpath = "//input[@name='address1']")
    private WebElement address;
    @FindBy(id = "city")
    private WebElement city;
    @FindBy(id = "uniform-id_state")
    private WebElement state;
    @FindBy(id = "postcode")
    private WebElement zipCode;
    @FindBy(id = "phone_mobile")
    private WebElement phone;
    @FindBy(xpath = "//option[contains(text(),'Alabama')]")
    private WebElement stateOption;
    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    public RegisterPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void fillUserData(User user) {
        webDriverWait.until(ExpectedConditions.visibilityOf(userForm));
        firstName.sendKeys(user.getName());
        lastName.sendKeys(user.getLastName());
        password.sendKeys(user.getAddress());
        address.sendKeys(user.getAddress());
        city.sendKeys(user.getCity());
        setState();
        zipCode.sendKeys(user.getPostalCode());
        phone.sendKeys(user.getMobilPhone());

    }

    public void registerUser(){
        registerButton.click();
    }

    private void setState(){
        state.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(stateOption)).click();
    }
}
