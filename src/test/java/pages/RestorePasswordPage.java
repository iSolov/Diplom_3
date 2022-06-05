package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Страница восстановления пароля.
 */
public class RestorePasswordPage {
    public static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    @FindBy(how = How.LINK_TEXT, using = "Войти")
    private SelenideElement loginButton;

    public LoginPage enterLinkClick() {
        loginButton.click();
        return Selenide.page(LoginPage.class);
    }
}
