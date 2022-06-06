package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Модель страницы с конструктором.
 */
public class ConstructorPage {
    public static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    /**
     * CSS-класс у выбранной вкладки.
     */
    public static final String CURRENT_TAB_CSS_LASS_NAME = "tab_tab_type_current__2BEPc";

    @FindBy(how = How.XPATH, using = ".//a[@class='AppHeader_header__link__3D_hX'][@href='/account']")
    private SelenideElement profilePageLink;

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginButton;

    @FindBy(how = How.XPATH,using = ".//div[span[text()='Булки']]")
    private SelenideElement bunsTab;

    @FindBy(how = How.XPATH,using = ".//div[span[text()='Соусы']]")
    private SelenideElement saucesTab;

    @FindBy(how = How.XPATH,using = ".//div[span[text()='Начинки']]")
    private SelenideElement fillingsTab;

    @Step("Клик по кнопке профиля.")
    public ProfilePage goToProfilePage(){
        profilePageLink.click();
        return Selenide.page(ProfilePage.class);
    }

    @Step("Клик по входа в аккаунт.")
    public LoginPage goToLoginPage(){
        loginButton.click();
        return Selenide.page(LoginPage.class);
    }

    @Step("Клик по вкладке соусов.")
    public ConstructorPage clickSouse() {
        saucesTab.click();
        return this;
    }

    @Step("Клик по вкладке начинок.")
    public ConstructorPage clickFilling() {
        fillingsTab.click();
        return this;
    }

    @Step("Клик по вкладке булочек.")
    public ConstructorPage clickBun() {
        bunsTab.click();
        return this;
    }

    @Step("Проверка выбранности вкладки с соусами.")
    public ConstructorPage shouldSouseTabBeSelected() {
        saucesTab.shouldBe(Condition.cssClass(CURRENT_TAB_CSS_LASS_NAME));
        return this;
    }

    @Step("Проверка выбранности вкладки с начинками.")
    public ConstructorPage shouldFillingTabBeSelected() {
        fillingsTab.shouldBe(Condition.cssClass(CURRENT_TAB_CSS_LASS_NAME));
        return this;
    }

    @Step("Проверка выбранности вкладки с булочками.")
    public ConstructorPage shouldBunTabBeSelected() {
        bunsTab.shouldBe(Condition.cssClass(CURRENT_TAB_CSS_LASS_NAME));
        return this;
    }
}
