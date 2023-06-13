package PageOblects;

import com.codeborne.selenide.SelenideElement;

public class ProductPage {
    public static String getProductPrice(SelenideElement locator) {
        return locator.getText();
    }
}
