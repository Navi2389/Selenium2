package project8Selenide;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class NavigationMenuProject8 {

    private List<SelenideElement> navigationMenuItems = $$(By.xpath("//ul[@class='nav nav-multilevel main-menu']/li"));

    public void openNavigationMenuItem(String menuName) {
        navigationMenuItems.stream().filter(element -> element.getText().equals(menuName)).findFirst().get().hover();
    }
}
