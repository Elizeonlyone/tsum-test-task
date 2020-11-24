package steps;

import client.Client;
import net.thucydides.core.annotations.Step;
import page.AccountPage;
import page.BasePage;
import page.LoginPage;
import page.RegistrationPage;

//Шаги, связанные с авторизацией\регистрацией
public class AuthSteps {

    LoginPage loginPage;
    BasePage basePage;
    AccountPage accountPage;
    RegistrationPage registrationPage;

    @Step("Открытие главной страницы")
    public void openMainPage(){
        basePage.initialize();
    }

    @Step("Открытие главной страницы")
    public void goToMainPage(){
        basePage.headerLogo.click();
    }

    @Step("Авторизация пользователя {0}")
    public void login(Client client){
        loginPage.openLoginPage();
        loginPage.fillAllFields(client);
        loginPage.logInButton.click();
    }

    @Step("Регистрация нового случайного пользователя")
    public Client registerNewRandomUser(){
        Client client = new Client().createNewCLient();
        registrationPage.openRegistrationPage();
        registrationPage.fillAllFields(client);
        registrationPage.registrationButton.click();
        return client;
    }

    @Step("Регистрация нового пользователя")
    public void registerNewUser(Client client){
        registrationPage.openRegistrationPage();
        registrationPage.fillAllFields(client);
        registrationPage.registrationButton.click();
    }

    @Step("Выход пользователя из аккаунта")
    public void logout(){
        basePage.personalAccount.click();
        accountPage.logoutButton.click();
    }
}
