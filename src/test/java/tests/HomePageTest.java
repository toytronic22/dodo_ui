package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import org.junit.jupiter.api.Tag;

import static io.qameta.allure.Allure.step;

@Owner("Alexey Martynov")
@Feature("Задачи в репозитории")
@Story("Просмотр созданных задач в репозитории")
@Link(value = "Тестинг", url = "https://github.com")


public class HomePageTest {
    HomePage homePage = new HomePage();

    @Test
    @Tag("dodo")
    @DisplayName("Check Title")
    public void openPage() {
        step("Открытие страницы - https://dodopizza.ru/", () -> {
            homePage.open();
        });
        step("Проверка локали Москва", () -> {
            homePage.getLocalityTitle()
                    .contains("Москва");
        });
    }

        @Test
        public void checkMainMenu() {
            new HomePage()
                    .open()
                    .checkMainMenu();
        }
    }