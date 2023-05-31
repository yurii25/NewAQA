import PageOblects.GoogleHomePage;
import PageOblects.GoogleSearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.webdriver;

public class PageObjectGoogleSearchTest {

    @Test
    public void verifyFirstResultLinkContainsKitten_PO() {
        var searchResultPage = new GoogleHomePage().open().search("funny kittens");
        Assert.assertTrue(searchResultPage.getFirstSearchResultText().contains("kitten"));
    }

    @Test
    public void verifyDisplayedResultsQuantity_PO() {
        new GoogleHomePage().open().search("funny kittens");
        GoogleSearchResultPage.getDisplayedResultsQuantity(9);
    }

    @Test
    public void verifyUserIsAbleToNavigateBackToTheHomepage_PO() {
        var searchResultPage = new GoogleHomePage().open().search("Selene");
        Assert.assertTrue(searchResultPage.getFirstSearchResultText().contains("Selene"));
        GoogleHomePage.goBackToHomePage();
        Assert.assertTrue(webdriver().driver().url().contains("https://www.google.com/webhp?hl="));

    }
}
