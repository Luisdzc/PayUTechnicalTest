package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage extends BasePage {



    public AccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getAccountUrlPage(){
        return getDriver().getCurrentUrl();
    }
}
