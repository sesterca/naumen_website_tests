package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configurations.Credentials;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    @BeforeAll
    public static void setUp(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        Credentials credits = ConfigFactory.create(Credentials.class);
        String baseUrl = System.getProperty("baseUrl", "https://www.naumen.ru/");
        String browser = System.getProperty("browser", "CHROME");
        String browserSize = System.getProperty("browserSize", "1920x1080");
        String remote = System.getProperty("remote","selenoid.autotests.cloud");
        String login = credits.login();
        String password = credits.password();

        Configuration.baseUrl = baseUrl;
        Configuration.browser = browser;
        Configuration.browserPosition = "0x0";
        Configuration.browserSize = browserSize;
        Configuration.remote = "https://" + login + ":" + password + "@" + remote + "/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments(){
        Attachments.screenshotAs("Screenshot");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();

        closeWebDriver();
    }
}
