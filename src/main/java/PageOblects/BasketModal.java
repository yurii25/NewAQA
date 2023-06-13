package PageOblects;

import com.codeborne.selenide.SelenideElement;

public class BasketModal {
    public static String nameOfTheParticularProductInBasket(SelenideElement locator) {
        return locator.getText();
    }

    public static String priceOfTheParticularProductInBasket(SelenideElement locator) {
        return locator.getText();
    }
}
