package PageOblects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.*;


public class RozetkaSearchResultPage extends PageWithHeader {


    public static RozetkaSearchResultPage addToTheBasket1(SelenideElement locator) {
        $(locator).click();
        return new RozetkaSearchResultPage();
    }

    public static RozetkaSearchResultPage addToTheBasket(Integer cartIconForParticularProduct ) {
        $x(String.format("(//button[@class='buy-button goods-tile__buy-button ng-star-inserted']) [%s]", cartIconForParticularProduct)).click();
        return new RozetkaSearchResultPage();
    }

    public void verifyQuantityOfResults(Integer numberOfResults) {
        $$x("//div[@class='goods-tile ng-star-inserted']").shouldHave(sizeGreaterThanOrEqual(numberOfResults));
    }

    public String priceOfTheParticularSearhResult(Integer productNumber) {
        return $x(String.format("(//div[@class='goods-tile ng-star-inserted']) [%s]", productNumber) +
                "//span[@class='goods-tile__price-value']").getText();
    }


    public ProductPage openParticularProduct(Integer productNumber) {

        $x(String.format("(//div[@class='goods-tile__inner']) [%s]", productNumber)).click();

        return new ProductPage();
    }


    public String nameOfTheParticularSearhResult(Integer productNumber) {
        return $x(String.format("(//a[@class='goods-tile__heading ng-star-inserted']) [%s]", productNumber)).getText();
    }
}
