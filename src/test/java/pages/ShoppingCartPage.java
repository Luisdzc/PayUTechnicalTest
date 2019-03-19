package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartPage extends BasePage{

    @FindBy(xpath = "//td//p[@class='product-name']")
    public WebElement productName;
    @FindBy(xpath = "//td//input[@class='cart_quantity_input form-control grey']")
    private WebElement productQuantity;
    @FindBy(xpath = "//td[@class='cart_delete text-center']//div")
    private WebElement deleteButton;
    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private WebElement emptyCartMessage;
    @FindBy(xpath = "//p//a[@title='Proceed to checkout']")
    private WebElement checkoutButton;
    @FindBy(xpath = "//li[@class='address_title']")
    private WebElement addresInfo;
    @FindBy(xpath = "//button[@name='processAddress']")
    private WebElement addresCheckoutButton;
    @FindBy(xpath = "//label[@for='cgv']")
    private WebElement conditionsTermsButton;
    @FindBy(xpath = "//button[@name='processCarrier']")
    private WebElement carrierCheckoutButton;
    @FindBy(xpath = "//a[@title='Pay by bank wire']")
    private WebElement payMentOption;
    @FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
    private WebElement confrimOrderButton;
    @FindBy(xpath = "//p//strong[@class='dark']")
    private WebElement confirmationMessage;

    public ShoppingCartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String numberOfProducts(){
       return webDriverWait.until(ExpectedConditions.visibilityOf(productQuantity)).getAttribute("value");
    }

    public void deleteAddedItem() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
    }

    public String getCartState() {
        try {
            Thread.sleep(3000); //TODO find way to wait for delete action to end
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return webDriverWait.until(ExpectedConditions.visibilityOf(emptyCartMessage)).getText();
    }

    public void makeCheckout() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }

    public boolean addressDetailsIsDisplayed(){
        return addresInfo.isDisplayed();
    }

    public void executeCompleteCheckout() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addresCheckoutButton)).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(conditionsTermsButton)).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(carrierCheckoutButton)).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(payMentOption)).click();
    }

    public String getConfirmationMessage(){
        return webDriverWait.until(ExpectedConditions.visibilityOf(confirmationMessage)).getText();
    }

    public void confirmOrder() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(confrimOrderButton)).click();
    }
}
