package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.TimeOuts.LONG_TIME_OUT;

public class BasePage extends PageObject {


    public WebDriverWait webDriverWait;

    public BasePage(WebDriver webDriver) {
        super(webDriver);
        this.webDriverWait = new WebDriverWait(getDriver(), LONG_TIME_OUT);
    }


    public void OpenMainPage (String mainPageUrl){
        openAt(mainPageUrl);
    }
}
