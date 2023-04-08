package ru.dodopizza.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.dodopizza.pages.MainMenu;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("toytronic")
@Feature("UI тесты dodopizza.ru")
@Story("Главная страница dodopizza.ru")
@Tags({@Tag("ui")})

public class MainMenuTest extends TestBase {
    MainMenu mainMenu = new MainMenu();
    @Test
    @DisplayName("Check Main Menu Titles")
    public void checkLocationAndMainMenu() {
        step("Открытие страницы - https://dodopizza.ru/moscow", () -> {
            mainMenu.open();
        });
        step("Проверка всех пунктов меню", () -> {
            mainMenu.checkMainMenu();
        });
    }
}
