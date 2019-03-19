package pages.components;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class HeadToolBar extends BasePage {

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInButton;
    @FindBy(xpath = "//a[@class='account']")
    private WebElement accountButton;
    @FindBy(xpath = "//a[@title='View my shopping cart']")
    public WebElement shoppingCartButton;



    public HeadToolBar(WebDriver webDriver) {
        super(webDriver);
    }


    public void signInUser(){
        signInButton.click();
    }

    public String getLoggedUser(){
        return webDriverWait.until(ExpectedConditions.visibilityOf(accountButton)).getText();
    }
}
