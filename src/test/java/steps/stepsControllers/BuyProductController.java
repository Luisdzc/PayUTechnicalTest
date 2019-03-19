package steps.stepsControllers;

import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.Matchers;
import org.junit.Assert;
import pages.BasePage;
import pages.ShoppingCartPage;

public class BuyProductController extends ScenarioSteps {

    private ShoppingCartPage shoppingCartPage;
    private BasePage basePage;


    public void proceedToCheckout() {
        shoppingCartPage.makeCheckout();
    }

    public void addressDetailShouldBeDisplayed() {
        Assert.assertThat("The address details was not displayed: ",
                shoppingCartPage.addressDetailsIsDisplayed(), Matchers.equalTo(true));
        basePage.getDriver().close();
    }

    public void executeCompleteCheckout() {
        shoppingCartPage.executeCompleteCheckout();
    }

    public void confirmOrder() {
        shoppingCartPage.confirmOrder();
    }

    public void successBuyMessageShouldBe(String confirmationMessage) {
        Assert.assertThat("The order process fails:" ,
                shoppingCartPage.getConfirmationMessage(), Matchers.equalTo(confirmationMessage));
        basePage.getDriver().close();
    }
}
