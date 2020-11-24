package page;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

//Базовый PageObject, описывающий общие для всех страниц элементы, все остальные страницы наследуются от него
public class BasePage extends PageObject {

    //Ссылка на переход в Личный кабинет\страницу авторизации в хедере
    @FindBy(className = "header__link")
    public WebElementFacade personalAccount;

    //Всплывающее сообщение об успехе\ошибке
    @FindBy(xpath = "//notice")
    public WebElementFacade errorMessage;

    //Всплывающий поп-ап
    @FindBy(className = "flocktory-widget")
    public WebElementFacade flocktory_widget;

    //Кнопка закрывания всплывающего поп-апа
    @FindBy(xpath = "//section/button", timeoutInSeconds = "5")
    public WebElementFacade closeButtonFlocktory_widget;

    //Логотип ЦУМ в хедере
    @FindBy(className = "header__logo-icon")
    public WebElementFacade headerLogo;

    //Выставление дефолтного URL, открытие главной страница
    public void initialize(){
        this.setDefaultBaseUrl(System.getProperty("tsum_url"));
        this.open();
    }

    //Проверка появления поп-апа на странице, если поп-ап открыт, закрытие его
    public void checkIsWidgetAppears(WebDriver driver){
        if(flocktory_widget.isDisplayed()){
            driver.switchTo().frame(flocktory_widget);
            closeButtonFlocktory_widget.click();
            driver.switchTo().defaultContent();
        }
    }

}
