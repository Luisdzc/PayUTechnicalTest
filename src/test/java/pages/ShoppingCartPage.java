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
}
