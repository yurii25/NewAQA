package PageOblects;


import com.codeborne.selenide.Condition;


import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

public class GoogleSearchResultPage {

    public static void getDisplayedResultsQuantity(int expextedResultsquantity) {
        $$x("//div[@class='DhN8Cf']").shouldHave(size(expextedResultsquantity));
    }

    public String getFirstSearchResultText() {

        String result = $x("//h3[@class='GmE3X kWYf3c']")
                .shouldBe(Condition.visible)
                .getText();
        return result;
    }
}
