package ru.dodopizza.tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.dodopizza.pages.HomePage;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("toytronic")
@Feature("UI тесты dodopizza.ru")
@Story("Главная страница dodopizza.ru")
@Tags({@Tag("ui")})

public class HomePageTest extends TestBase {
    HomePage homePage = new HomePage();
    @Test
    @Tag("dodo")
    @DisplayName("Check Location and Main Menu")
    public void checkLocationAndMainMenu() {
        step("Открытие страницы - https://dodopizza.ru/moscow", () -> {
            homePage.open();
        });
        step("Проверка локали Москва", () -> {
            assertTrue(homePage.getLocalityTitle().contains("Москва"));
        });
        step("Проверка главного меню", homePage::checkMainMenu);
    }
}
