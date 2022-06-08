package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Страница регистрации.
 */
public class RegistrationPage {
    public static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/register";

    @FindBy(xpath = ".//input[@class='text input__textfield text_type_main-default']")
    private ElementsCollection fields;

    @FindBy(xpath = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registrationButton;

    @FindBy(xpath = ".//p[text()='Некорректный пароль']")
    private SelenideElement passwordError;

    @FindBy(xpath = ".//a[text()='Войти']")
    private SelenideElement enterLink;

    private SelenideElement getNameField(){
        return fields.get(0);
    }

    private SelenideElement getEmailField(){
        return fields.get(1);
    }

    private SelenideElement getPasswordField(){
        return fields.get(2);
    }

    @Step("Заполнение формы регистрации.")
    public RegistrationPage fillRegistrationForm(User user){
        getNameField().sendKeys(user.getName());
        getEmailField().sendKeys(user.getEmail());
        getPasswordField().sendKeys(user.getPassword());
        return this;
    }

    @Step("Подтверждение регистрации.")
    public LoginPage confirmRegistration(){
        registrationButton.click();
        return Selenide.page(LoginPage.class);
    }

    @Step("Клик по кнопке входа.")
    public LoginPage enterLinkClick(){
        enterLink.click();
        return Selenide.page(LoginPage.class);
    }

    @Step("Получение признака видимости сообщения об ошибке пароля.")
    public boolean isPasswordErrorVisible(){
        return passwordError.is(Condition.visible);
    }
}
