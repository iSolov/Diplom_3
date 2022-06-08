import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.ConstructorPage;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.open;

/**
 * Тест конструктора.
 */
public class ConstructorTest {
    ConstructorPage constructorPage = open(ConstructorPage.PAGE_URL, ConstructorPage.class);

    @Before
    public void setUp() {
        browser = "chrome";
    }

    @Test
    @DisplayName("Должна быть возможность выбрать вкладку с соусами.")
    public void shouldSouseTabSeSelectedTest() {
        constructorPage
                .clickSouse()
                .shouldSouseTabBeSelected();
    }

    @Test
    @DisplayName("Должна быть возможность выбрать вкладку с начинками.")
    public void shouldFillingTabSeSelectedTest() {
        constructorPage
                .clickFilling()
                .shouldFillingTabBeSelected();
    }

    @Test
    @DisplayName("Должна быть возможность выбрать вкладку с булочками.")
    public void shouldBunTabSeSelectedTest() {
        constructorPage
                .clickSouse()
                .clickBun()
                .shouldBunTabBeSelected();
    }
}
