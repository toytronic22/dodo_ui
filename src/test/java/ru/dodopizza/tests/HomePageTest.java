package ru.dodopizza.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.dodopizza.pages.HomePage;

import static io.qameta.allure.Allure.step;

@Owner("toytronic")
@Feature("UI тесты dodopizza.ru")
@Story("Главная страница dodopizza.ru")
@Tags({@Tag("ui")})

public class HomePageTest extends TestBase {
    HomePage homePage = new HomePage();
    @Test
    @DisplayName("Check Locality")
    public void checkLocality() {
        step("Открытие страницы - https://dodopizza.ru/moscow", () -> {
            homePage.open();
        });
        step("Проверка локали", () -> {
            homePage.verifyLocation("Москва");
        });
    }
}
