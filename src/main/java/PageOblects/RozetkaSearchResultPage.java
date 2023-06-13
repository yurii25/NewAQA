package PageOblects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;


public class RozetkaSearchResultPage extends PageWithHeader {


    public static RozetkaSearchResultPage addToTheBasket(SelenideElement locator) {
        $(locator).click();
        return new RozetkaSearchResultPage();
    }

    public void verifyQuantityOfResults(Integer numberOfResults) {
        $$x("//div[@class='goods-tile ng-star-inserted']").shouldHave(sizeGreaterThanOrEqual(numberOfResults));
    }

    public String priceOfTheParticularSearhResult(SelenideElement locator) {
        return locator.getText();
    }

    public ProductPage openParticularProduct(SelenideElement locator) {

        $(locator).click();

        return new ProductPage();
    }

    public String nameOfTheParticularSearhResult(SelenideElement locator) {
        return locator.getText();
    }
}
