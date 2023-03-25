package tests;

import org.junit.jupiter.api.Test;
import pages.HomePage;

public class HomePageTest {

    @Test
    public void openPage() {
        new HomePage()
                .open()
                .getLocalityTitle()
                .contains("Москва");
    }

    @Test
    public void checkMainMenu() {
        new HomePage()
                .open()
                .checkMainMenu();
    }
}