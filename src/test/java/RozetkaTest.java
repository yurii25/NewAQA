import PageOblects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
public class RozetkaTest {

    @Test
    public void verifyProductSearchDetails() {
        var resultPage = new RozetkaHomePage()
                .open()
                .getHeader()
                .search("iphone");

        resultPage.verifyQuantityOfResults(5);

        var priceOnTheSearchResultsPage = resultPage
                .priceOfTheParticularSearhResult($x("(//div[@class='goods-tile ng-star-inserted']) [3] " +
                        "//span[@class='goods-tile__price-value']"));

        resultPage.openParticularProduct($x("(//div[@class='goods-tile__inner']) [3] "));

        var priceOnTheProductPage = ProductPage.getProductPrice($x("//p[@class='product-price__big product-price__big-color-red']"));

        Assert.assertEquals(priceOnTheProductPage, priceOnTheSearchResultsPage);
    }

    @Test
    public void verifyLoginModal() {
        var homePage = new RozetkaHomePage().open();
        homePage.clickOnAccountIcon();

        SignInModal.checkIfSignInModalDisplayed();

        homePage.closeSignInModal();
        SignInModal.checkIfSignInModalNotDisplayed();
    }

    @Test
    public void verifyProductSearchDetailsAndBasketInfo() {
        var resultPage = new RozetkaHomePage()
                .open()
                .getHeader()
                .search("dell");

        resultPage.verifyQuantityOfResults(10);

        var priceOnTheSearchResultsPage = resultPage
                .priceOfTheParticularSearhResult($x("(//span[@class='goods-tile__price-value']) [6]"));

        var nameOnTheSearchResultsPage = resultPage
                .nameOfTheParticularSearhResult($x("(//a[@class='goods-tile__heading ng-star-inserted']) " +
                        "[6]"));

        RozetkaSearchResultPage.addToTheBasket($x("(//button[@class='buy-button goods-tile__buy-button " +
                "ng-star-inserted']) [6]"));

        resultPage.clickOnBasketIcon();

        var priceOnTheBasketModal = BasketModal.priceOfTheParticularProductInBasket(
                $x("//div[@class='cart-receipt__sum-price']"));

        var nameOnTheBasketModal = BasketModal.nameOfTheParticularProductInBasket(
                $x("//div[@class='cart-product__main']"));

        Assert.assertEquals(priceOnTheSearchResultsPage, priceOnTheBasketModal);
        Assert.assertEquals(nameOnTheSearchResultsPage, nameOnTheBasketModal);
    }
}
