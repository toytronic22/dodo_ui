package ru.dodopizza.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.dodopizza.pages.MenuPage;
import static io.qameta.allure.Allure.step;

@Owner("toytronic")
@Feature("UI тесты dodopizza.ru")
@Story("Главная страница dodopizza.ru")
@Tags({@Tag("ui")})

public class MenuPageTest extends TestBase {
    MenuPage menuPage = new MenuPage();
    @Test
    @DisplayName("Check Main Menu Titles")
    public void checkLocationAndMainMenu() {
        step("Открытие страницы - https://dodopizza.ru/moscow", () -> {
            menuPage.open();
        });
        step("Проверка всех пунктов меню", () -> {
            menuPage.checkMainMenu();
        });
    }
}
