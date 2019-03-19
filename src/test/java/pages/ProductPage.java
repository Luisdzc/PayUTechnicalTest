package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ProductHelper;

import java.util.List;


public class ProductPage extends BasePage {

    @FindBy(xpath = "//div[@class='product-container']")
    private List<WebElement> productsList;
    @FindBy(xpath = "//span[@id='layer_cart_product_title']")
    public WebElement productNameDetail;
    @FindBy(xpath = "//span[@id='layer_cart_product_price']")
    public WebElement productPriceDetail;
    @FindBy(xpath = "//div[@class='layer_cart_product col-xs-12 col-md-6']//h2[1]")
    public WebElement operationMessage;
    @FindBy(xpath = "//div[@id='layer_cart']//div[@class='clearfix']")
    private WebElement addedProductPopUp;
    @FindBy(xpath = "//span[@class='cross']")
    private WebElement closeProductInfoButton;

    private By productName = By.xpath(".//a[@class='product-name']");
    private By productPrice = By.xpath(".//span[@class='price product-price']");
    private By addButton = By.xpath(".//a[@title='Add to cart']");

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void addProductToCart(){
        productsList.get(0).findElement(addButton).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(addedProductPopUp));
        closeProductInfoButton.click();

    }

    public void setProductInfo() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(productsList));
        String productTitle = productsList.get(0).findElement(productName).getText();
        String productValue = productsList.get(0).findElement(productPrice).getText();
        ProductHelper.buildProductInfo(productTitle,productValue);
    }
}
