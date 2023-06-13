package PageOblects;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class SignInModal {

    public static void checkIfSignInModalDisplayed() {
        $x("//div[@class = 'modal__holder modal__holder_show_animation modal__holder--medium']")
                .shouldBe(Condition.visible);
    }

    public static void checkIfSignInModalNotDisplayed() {
        $x("//div[@class = 'modal__holder modal__holder_show_animation modal__holder--medium']")
                .shouldNotBe(Condition.visible);
    }

}
