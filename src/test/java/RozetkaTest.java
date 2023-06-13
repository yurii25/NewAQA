import PageOblects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;

/*
"- Open http://rozetka.com.ua home page
- Search for ‘iPhone’
- Verify that at least 5 result links are displayed and that each link text contains 'iPhone'
- Verify the 3rd product has a price, save the price
- Click on the 3rd product and verify that the stored price and price on product page is equal

- Open http://rozetka.com.ua home page
- Click on the user icon in the top right corner
- Verify that the login modal is displayed
- Close the login modal, verify it’s closed

- Open http://rozetka.com.ua home page
- Search for ‘dell’
- Verify that at least 10 result links are displayed
- Save the name and the price of 5th product, add it to the basket
- Verify the basket modal is opened and the price and name are correct

Create PR and assing toleksyn as reviewer."
 */
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
