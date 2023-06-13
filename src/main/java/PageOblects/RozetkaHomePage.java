package PageOblects;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

public class RozetkaHomePage extends PageWithHeader {


    public RozetkaHomePage open() {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        Selenide.open("https://rozetka.com.ua/ua/");
        return this;
    }


}
