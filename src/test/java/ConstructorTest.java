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
    @DisplayName("Проверка переключения вкладок.")
    public void shouldLoginByLoginButtonTest() {
        // Последовательное переключение вкладок (выбранная вкладка должна содержать определенный стиль).
        constructorPage
                .clickSouse()
                .shouldSouseTabBeSelected()
                .clickFilling()
                .shouldFillingTabBeSelected()
                .clickBun()
                .shouldBunTabBeSelected();
    }
}
