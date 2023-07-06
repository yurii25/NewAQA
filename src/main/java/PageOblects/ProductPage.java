package PageOblects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage {
    public static String getProductPrice() {

        return $x("//p[@class='product-price__big product-price__big-color-red']").getText();
    }
}
