package steps.stepsControllers;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.Matchers;
import org.junit.Assert;
import pages.BasePage;
import pages.MainPage;
import pages.ProductPage;
import pages.ShoppingCartPage;
import utils.ProductHelper;

public class AddProductController extends ScenarioSteps {

    private MainPage mainPage;
    private ProductPage productPage;
    private ShoppingCartPage shoppingCartPage;
    private BasePage basePage;

    @Step
    public void selectProductToAdd() {
        mainPage.SelectProduct();
    }

    @Step
    public void getSelectedProductInfo() {
        productPage.setProductInfo();
    }

    @Step
    public void addSelectedProduct() {
        productPage.addProductToCart();
    }

    @Step
    public void successfullyMessageShouldBeDisplayed(String operationMessage) {
        Assert.assertThat("The successgully message was not displayed: ",
                productPage.operationMessage.getText(), Matchers.containsString(operationMessage));
    }

    @Step
    public void addedProductShouldBe() {
        mainPage.headToolBar.shoppingCartButton.click();
        Assert.assertThat("The added product is no the same product in the cart:",
                shoppingCartPage.productName.getText(),Matchers.equalTo(ProductHelper.addedProduct.getName()));
        basePage.getDriver().close();
    }

    @Step
    public void shoppingCartHas(String entries) {
        mainPage.headToolBar.shoppingCartButton.click();
        Assert.assertThat("The shopping cart has not all the added products:",
               shoppingCartPage.numberOfProducts(), Matchers.equalTo(entries));
        basePage.getDriver().close();
    }

    @Step
    public void openShoppingCart() {
        mainPage.headToolBar.shoppingCartButton.click();
    }

    @Step
    public void deleteItemFromCart() {
        shoppingCartPage.deleteAddedItem();
    }

    @Step
    public void shoppingCartShouldBeEmpty(String emptyMessage) {
        Assert.assertThat("The product was not deleted from the cart: ",
                shoppingCartPage.getCartState(),Matchers.containsString(emptyMessage));
        basePage.getDriver().close();
    }
}
