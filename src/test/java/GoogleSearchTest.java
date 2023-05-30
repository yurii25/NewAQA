import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;


public class GoogleSearchTest {

    @Test
    public void verifyFirstResultLinkContainsKitten() {

        Configuration.browser = "firefox";
        Configuration.holdBrowserOpen = true;

        open("https://www.google.com/");

        $(By.name("q")).setValue("funny kitten").pressEnter();

        String expectedResult = $x("//h3[@class='GmE3X kWYf3c']")
                .shouldBe(Condition.exist)
                .getText();
        String actualResult = "kitten";

        Assert.assertTrue(expectedResult.contains(actualResult));
//        System.out.println(expectedResult);
//        System.out.println(actualResult);
    }


    @Test
    public void verifyDisplayedResultsQuantity() {

        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;

        open("https://www.google.com/");

        $(By.name("q")).setValue("funny kitten").pressEnter();

        ElementsCollection collection = $$x("//div[@class='DhN8Cf']").shouldHave(size(9));

//        System.out.println(collection.size());
//        Чому, якщо для collection забрати ".shouldHave(size(9))" метод, то "collection.size()" повертає 0?

    }


    @Test
    public void verifyUserIsAbleToNavigateBackToTheHomepage() {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;

        open("https://www.google.com/");

        $(By.name("q")).setValue("Selene").pressEnter();

        String expectedResult = $x("//h3[@class='GmE3X kWYf3c']")
                .shouldBe(Condition.exist)
                .getText();

        String actualResult = "Selene";

        Assert.assertTrue(expectedResult.contains(actualResult));
//        System.out.println(expectedResult);
//        System.out.println(actualResult);

        $(By.id("logo")).click();

        Assert.assertTrue(webdriver().driver().url().contains("https://www.google.com/webhp?hl="));

        $x("//img[@alt='Google']").shouldBe(Condition.visible);  //  //div[@class='SDkEP']

        $x("//div[@class='SDkEP']").shouldBe(Condition.visible);
    }
}
