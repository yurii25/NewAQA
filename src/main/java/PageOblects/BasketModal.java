package PageOblects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BasketModal {
    public static String nameOfTheParticularProductInBasket() {
        return $x("//div[@class='cart-product__main']").getText();
    }

    public static String priceOfTheParticularProductInBasket() {
        return $x("//div[@class='cart-receipt__sum-price']").getText();
    }
}
