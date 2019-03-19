package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.components.HeadToolBar;

import java.util.List;

public class MainPage extends BasePage {

    @FindBy(xpath = "//a[@title='Women']")
    private WebElement womenSection;
    @FindBy(xpath = "//a[@title='List']")
    private WebElement listOption;

    public HeadToolBar headToolBar;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void SelectProduct(){
        webDriverWait.until(ExpectedConditions.visibilityOf(womenSection)).click();
        listOption.click();
    }

}
