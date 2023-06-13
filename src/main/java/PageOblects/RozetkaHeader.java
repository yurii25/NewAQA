package PageOblects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RozetkaHeader {

    public RozetkaSearchResultPage search(String input) {
        $(By.name("search")).setValue(input).pressEnter();
        return new RozetkaSearchResultPage();
    }
}
