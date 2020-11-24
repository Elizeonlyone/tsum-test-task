package page;

import client.Client;
import org.jetbrains.annotations.NotNull;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class RegistrationPage extends BasePage {

    LoginPage loginPage;

    //Поле ввода эл. почты
    @FindBy(xpath = "//auth-register/form/div[1]/input")
    public WebElementFacade emailField;

    //Поле ввода пароля
    @FindBy(xpath = "//auth-register/form/div[2]/input")
    public WebElementFacade passwordField;

    //Кнопка "Зарегистрироваться"
    @FindBy(xpath = "//button[text()='Зарегистрироваться']")
    public WebElementFacade registrationButton;

    //Заголовок второго уровня на странице после успешной регистрации
    @FindBy(xpath = "//auth-layout/div/div[2]")
    public WebElementFacade authLayoutHeading;

    //Открытие страницы регистрации через переход на страницу авторизации
    public void openRegistrationPage(){
        personalAccount.click();
        loginPage.goToRegistrationPage();
    }

    //Заполнение всех полей на странице регистрации, на вход принимает объект Client
    public void fillAllFields(@NotNull Client client){
        emailField.sendKeys(client.getEmail());
        passwordField.sendKeys(client.getPassword());
    }
}
