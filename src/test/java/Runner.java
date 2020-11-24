import static org.junit.Assert.assertEquals;

import client.Client;
import java.io.IOException;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import page.BasePage;
import page.RegistrationPage;
import steps.AuthSteps;
import tools.ConfigAssistant;

@RunWith(SerenityRunner.class)
public class Runner {

        BasePage basePage;
        RegistrationPage registrationPage;
        Client client;

        @Steps
        AuthSteps authSteps;

        @Managed
        static WebDriver driver;

        //Настройка перед тестами, импорт конфига
        @Before
        public void setup(){

            ConfigAssistant config = new ConfigAssistant();

            try {
                config.importConfig("prod");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Test
        @Title("Авторизация незарегистрированного пользователя")
        public void loginWithUnknownUser(){
            client = new Client().createNewCLient();

            authSteps.openMainPage();
            authSteps.login(client);

            //Проверка выпадения ошибки
            assertEquals("Неверный логин или пароль", basePage.errorMessage.getText());
        }

        @Test
        @Title("Успешная авторизация пользователя")
        public void loginWithExistedUser(){
            client = new Client("123123123@mail.ru", "12345678");

            authSteps.openMainPage();
            authSteps.login(client);

            //Открытие главной страницы, проверка на выпадение поп-апа, проверка успешности авторизации
            authSteps.openMainPage();
            basePage.checkIsWidgetAppears(driver);
            assertEquals(client.getEmail(), basePage.personalAccount.waitUntilVisible().getText().replaceAll(" ", ""));

        }

        @Test
        @Title("Регистрация нового пользователя")
        public void registerNewRandomUser(){
            authSteps.openMainPage();
            client = authSteps.registerNewRandomUser();

            //Проверка что регистрация успешна, пользователь авторизован в системе
            assertEquals("Успешная регистрация", registrationPage.errorMessage.getText());
            assertEquals("Ваши предпочтения", registrationPage.authLayoutHeading.getText());
            authSteps.goToMainPage();
            assertEquals(client.getEmail(), basePage.personalAccount.getText().replaceAll(" ", ""));
        }

        @Test
        @Title("Регистрация нового пользователя с паролем меньше 8 символов")
        public void registerUserWithShortPassword(){

            client = new Client("test@test.ru", "1234");
            authSteps.openMainPage();
            authSteps.registerNewUser(client);

            //Проверка выпадения ошибки
            assertEquals("Пароль должен быть не менее 8 символов длиной", basePage.errorMessage.getText());
    }
    }


