package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import java.util.List;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public SelenideElement logo = $(".logo");

    public SelenideElement menuItem = $x(".//ul[@class='menu__list']//a[@class='link'][1]");

    public ElementsCollection headerMenuItems = $$x(".//ul[@class='menu__list']//a[@class='link']");

    @Step("Открытие главной страницы")
    public void openPage(){open(baseUrl);}

    @Step("Получение списка заголовков меню хедера")
    public List<String>getHeaderMenuItems(){return headerMenuItems.texts();}

    @Step("Клик по логотипу в хедере")
    public void clickLogo(){
        logo.click();
    }

    @Step("Клик по пункту меню хедера")
    public void clickHeaderMenuItem(String menu){
    $x(".//ul[@class='menu__list']//a[contains(text(),'"+menu+"')]").click();}

    @Step("Наведение курсора на пункт меню хедера")
    public void hoverHeaderMenuItem(){
        $x(".//ul[@class='menu__list']//a[@class='link'][1]").hover();
    }
}
