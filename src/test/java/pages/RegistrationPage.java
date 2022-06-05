package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import models.User;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Страница регистрации.
 */
public class RegistrationPage {
    public static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/register";

    @FindBy(how = How.XPATH, using = ".//input[@class='text input__textfield text_type_main-default']")
    private ElementsCollection fields;

    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registrationButton;

    @FindBy(how = How.XPATH,using = ".//p[text()='Некорректный пароль']")
    private SelenideElement passwordError;

    @FindBy(how = How.XPATH,using = ".//a[text()='Войти']")
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

    public RegistrationPage fillRegistrationForm(User user){
        getNameField().sendKeys(user.getName());
        getEmailField().sendKeys(user.getEmail());
        getPasswordField().sendKeys(user.getPassword());
        return this;
    }

    public LoginPage confirmRegistration(){
        registrationButton.click();
        return Selenide.page(LoginPage.class);
    }

    public LoginPage enterLinkClick(){
        enterLink.click();
        return Selenide.page(LoginPage.class);
    }

    public boolean isPasswordErrorVisible(){
        return passwordError.is(Condition.visible);
    }
}
