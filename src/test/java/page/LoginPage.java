package page;

import client.Client;
import org.jetbrains.annotations.NotNull;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

//Страница авторизации
public class LoginPage extends BasePage {

    //Поле ввода эл. почты
    @FindBy(xpath = "//auth-login/form/div[1]/input")
    public WebElementFacade emailField;

    //Поле ввода пароля
    @FindBy(xpath = "//auth-login/form/div[2]/input")
    public WebElementFacade passwordField;

    //Кнопка "Войти"
    @FindBy(xpath = "//button[text()='Войти ']")
    public WebElementFacade logInButton;

    //Кнопка переключения на регистрацию пользователя
    @FindBy(xpath = "//auth-layout/div/div[3]/p[text()=' Регистрация ']")
    public WebElementFacade switchToRegistration;

    //Метод открытия страницы авторизации из хедера
    public void openLoginPage(){
        personalAccount.click();
    }

    //Заполнение всех полей на странице авторизации, на вход принимает объект Client
    public void fillAllFields(@NotNull Client client){
        emailField.sendKeys(client.getEmail());
        passwordField.sendKeys(client.getPassword());
    }

    //Переключение на страницу регистрации
    public void goToRegistrationPage(){
        switchToRegistration.click();
    }


}
