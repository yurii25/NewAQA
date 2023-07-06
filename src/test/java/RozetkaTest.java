import PageOblects.*;
import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.*;

public class RozetkaTest {

    @BeforeClass
    public void beforeTestClass(){
        System.out.println("The Rozetka tests started");
    }

    @AfterClass
    public void afterTestClass(){
        System.out.println("The Rozetka tests ended");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("The single test has started");
    }

    @AfterMethod
    public void afterMethod() {
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void verifyProductSearchDetails() {
        var resultPage = new RozetkaHomePage()
                .open()
                .getHeader()
                .search("iphone");

        resultPage.verifyQuantityOfResults(5);

        var priceOnTheSearchResultsPage = resultPage.priceOfTheParticularSearhResult(3);

        resultPage.openParticularProduct(3);

        var priceOnTheProductPage = ProductPage.getProductPrice();

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
                .priceOfTheParticularSearhResult(5);

        var nameOnTheSearchResultsPage = resultPage
                .nameOfTheParticularSearhResult(5);

        RozetkaSearchResultPage.addToTheBasket(5);

        resultPage.clickOnBasketIcon();

        var priceOnTheBasketModal = BasketModal.priceOfTheParticularProductInBasket();

        var nameOnTheBasketModal = BasketModal.nameOfTheParticularProductInBasket();

        Assert.assertEquals(priceOnTheSearchResultsPage, priceOnTheBasketModal);
        Assert.assertEquals(nameOnTheSearchResultsPage, nameOnTheBasketModal);
    }
}
