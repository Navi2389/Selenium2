package project8Selenide;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPageProject8 {
    public NavigationMenuProject8 navigationMenu;

    public MainPageProject8() {
        this.navigationMenu = new NavigationMenuProject8();
    }

    private SelenideElement geekBrainsHomeButton = $(By.xpath("//a[@title='Geekbrains']"));
}
