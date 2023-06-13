package PageOblects;

import com.codeborne.selenide.BasicAuthCredentials;

import static com.codeborne.selenide.Selenide.$x;

public abstract class PageWithHeader {
    private RozetkaHeader header = new RozetkaHeader();

    public RozetkaHeader getHeader() {
        return header;
    }

    public SignInModal clickOnAccountIcon() {
        $x("(//button[@class='header__button ng-star-inserted']) [1]").click();
        return new SignInModal();
    }

    public RozetkaHomePage closeSignInModal(){
        $x("//button[@class = 'modal__close']").click();
        return new RozetkaHomePage();
    }

    public BasketModal clickOnBasketIcon() {
        $x("//button[@class='header__button ng-star-inserted header__button--active']").click();
        return new BasketModal();
    }
}
