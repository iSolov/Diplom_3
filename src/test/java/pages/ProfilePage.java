package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Страница профиля.
 */
public class ProfilePage {
    public static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    @FindBy(how = How.XPATH, using = ".//a[@class='AppHeader_header__link__3D_hX'][@href='/']")
    private SelenideElement constructorPageLink;

    @FindBy(how = How.XPATH, using = ".//div[@class='AppHeader_header__logo__2D0X2']/a[@href='/']")
    private SelenideElement logoImage;

    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement logOutButton;

    public ConstructorPage constructorPageLinkClick(){
        constructorPageLink.click();
        return Selenide.page(ConstructorPage.class);
    }

    public ConstructorPage logoImageClick() {
        logoImage.click();
        return Selenide.page(ConstructorPage.class);
    }

    public LoginPage logout() {
        logOutButton.click();
        return Selenide.page(LoginPage.class);
    }

    public ProfilePage shouldLogOutButtonBeVisible() {
        logOutButton.shouldBe(Condition.visible);
        return this;
    }

    public ProfilePage checkVisibleConstructorPageLink() {
        constructorPageLink.shouldBe(Condition.visible);
        return this;
    }
}
