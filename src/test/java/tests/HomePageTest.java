package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("Alexey Martynov")
@Feature("Задачи в репозитории")
@Story("Просмотр созданных задач в репозитории")
@Link(value = "Тест dodo_ui", url = "https://github.com/toytronic22/dodo_ui")

public class HomePageTest extends TestBase2 {
    HomePage homePage = new HomePage();
    @Test
    @Tag("dodo")
    @DisplayName("Check Location and Main Menu")
    public void checkLocationAndMainMenu() {
//        HomePage homePage = new HomePage().open();
        step("Открытие страницы - https://dodopizza.ru/moscow", () -> {
            open("/");
        });
        step("Проверка локали Москва", () -> {
            assertTrue(homePage.getLocalityTitle().contains("Москва"));
        });
        step("Проверка главного меню", homePage::checkMainMenu);
    }
}
