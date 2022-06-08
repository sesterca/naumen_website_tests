
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.EnumSource;
import pages.BaseTest;
import pages.CssAttributes;
import pages.MainPage;
import pages.Pages;

import java.util.List;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPageTests extends BaseTest {

    @Severity(SeverityLevel.MINOR)
    @Test
    @DisplayName("При клике по логотипу в хедере переход на главную страницу")
    public void clickLogoGoToMainPageTest(){
        MainPage mainPage = new MainPage();
        mainPage.openPage();
        mainPage.clickLogo();
        assertThat(url()).isEqualTo(baseUrl);
    }

    @Severity(SeverityLevel.MINOR)
    @Test
    @DisplayName("Структура меню хедера")
    public void headerStructureTest(){
        MainPage mainPage = new MainPage();
        mainPage.openPage();
        List<String> actualHeaderMenuItems = mainPage.getHeaderMenuItems();
        List<String> expectedHeaderMenuItems = List.of("ПРОДУКТЫ", "УСЛУГИ", "КЛИЕНТЫ", "ПАРТНЕРЫ", "О НАС", "ПРЕСС-ЦЕНТР", "КАРЬЕРА");
        assertThat(actualHeaderMenuItems).isEqualTo(expectedHeaderMenuItems);
    }

    @Severity(SeverityLevel.CRITICAL)
    @EnumSource(Pages.class)
    @ParameterizedTest
    @DisplayName("Переход по пункту меню хедера")
    public void linkHeaderMenuTest(Pages pages){
        MainPage mainPage = new MainPage();
        mainPage.openPage();
        mainPage.clickHeaderMenuItem(pages.menuName);
        assertThat(url().substring(21)).isEqualTo(pages.pageUrl);
    }

    @Severity(SeverityLevel.TRIVIAL)
    @Test
    @DisplayName("Ховер пункта меню при наведении курсора")
    public void hoverMenu(){
        MainPage mainPage = new MainPage();
        mainPage.openPage();
        mainPage.hoverHeaderMenuItem();
        assertThat(mainPage.menuItem.getCssValue("color"))
                .isEqualTo(CssAttributes.HOVER_COLOR.attributeValue);
    }
}
