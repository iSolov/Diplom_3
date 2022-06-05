package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import models.User;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Страница авторизации.
 */
public class LoginPage {
    public static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/login";

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement loginButton;

    @FindBy(how = How.XPATH, using = ".//input[@type='text']")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = ".//input[@type='password']")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = ".//a[@class='Auth_link__1fOlj'][@href='/register']")
    private SelenideElement registrationLink;

    @FindBy(how = How.LINK_TEXT, using = "Восстановить пароль")
    private SelenideElement restorePassword;

    public LoginPage fillLoginPage(User user){
        emailField.scrollTo();
        emailField.setValue(user.getEmail());

        passwordField.scrollTo();
        passwordField.sendKeys(user.getPassword());

        return this;
    }


    public ConstructorPage loginButtonClick(){
        loginButton.shouldBe(Condition.exist);
        loginButton.scrollTo();
        loginButton.click();
        return Selenide.page(ConstructorPage.class);
    }


    public RegistrationPage goToRegistration(){
        registrationLink.click();
        return Selenide.page(RegistrationPage.class);
    }

    public LoginPage shouldPageBeReady(){
        emailField.click();
        emailField.shouldBe(Condition.exist);
        passwordField.click();
        passwordField.shouldBe(Condition.exist);

        loginButton.shouldBe(Condition.exist);
        registrationLink.shouldBe(Condition.exist);
        return this;
    }

    public RestorePasswordPage restorePassword() {
        restorePassword.click();
        return Selenide.page(RestorePasswordPage.class);
    }


}
