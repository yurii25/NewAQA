package PageOblects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class GoogleHomePage {

    public static void goBackToHomePage() {
        $(By.id("logo")).click();
        $x("//img[@alt='Google']").shouldBe(Condition.visible);
        $x("//div[@class='SDkEP']").shouldBe(Condition.visible);
    }

    public GoogleHomePage open() {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        Selenide.open("https://www.google.com/");
        return this;
    }

    public GoogleSearchResultPage search(String locator) {
        $(By.name("q")).setValue(locator).pressEnter();
        return new GoogleSearchResultPage();
    }
}
