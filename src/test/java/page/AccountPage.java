package page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

//Страница личного кабинета у авторизованного пользователя
public class AccountPage extends BasePage{

    @FindBy(xpath = "//personal-menu/div/ul/li[6]/a[text()=' Выход ']")
    public WebElementFacade logoutButton;

}
