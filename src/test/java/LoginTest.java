import client.UsersApiClient;
import io.qameta.allure.junit4.DisplayName;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.ConstructorPage;
import pages.LoginPage;
import pages.RegistrationPage;
import pages.RestorePasswordPage;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

/**
 * Тест входа пользователя.
 */
public class LoginTest {
    private final UsersApiClient usersApiClient = new UsersApiClient();

    private ConstructorPage constructorPage = open(ConstructorPage.PAGE_URL, ConstructorPage.class);

    @Before
    public void setUp() {
        browser = "chrome";
    }

    @After
    public void afterTest() {
        usersApiClient.deleteCreatedUsers();
    }

    /**
     * Получает случайного нового пользователя и регистрирует его.
     */
    public User getNewUser() {
        User user = User.getRandomUser();
        usersApiClient.register(user);
        usersApiClient.login(user);
        return user;
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной.")
    public void shouldLoginByLoginButtonTest() {
        open(ConstructorPage.PAGE_URL, ConstructorPage.class)
                .goToLoginPage();

        webdriver().shouldHave(url(LoginPage.PAGE_URL));
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет».")
    public void shouldLoginByUserCabinetTest() {
        open(ConstructorPage.PAGE_URL, ConstructorPage.class)
                .goToProfilePage();

        webdriver().shouldHave(url(LoginPage.PAGE_URL));
    }

    @Test
    @DisplayName("Вход через ссылку в форме регистрации.")
    public void shouldLoginByRegistrationButtonTest() {
        open(RegistrationPage.PAGE_URL, RegistrationPage.class)
                .enterLinkClick();

        webdriver().shouldHave(url(LoginPage.PAGE_URL));
    }

    @Test
    @DisplayName("Вход через восстановление пароля.")
    public void shouldLoginByRestorePasswordButtonTest() {
        open(RestorePasswordPage.PAGE_URL, RestorePasswordPage.class)
                .enterLinkClick();

        webdriver().shouldHave(url(LoginPage.PAGE_URL));
    }

    @Test
    @DisplayName("Вход через восстановление пароля.")
    public void shouldLoginNewUserTest() {
        open(LoginPage.PAGE_URL, LoginPage.class)
                .fillLoginPage(getNewUser())
                .loginButtonClick();

        webdriver().shouldHave(url(ConstructorPage.PAGE_URL));
    }
}
