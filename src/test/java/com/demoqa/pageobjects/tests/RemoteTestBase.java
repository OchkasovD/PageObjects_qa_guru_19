package com.demoqa.pageobjects.tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.pageobjects.Helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.Map;

public class RemoteTestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";


        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub"; // адрес селенойда, где запускаются тесты

        //задаем для selenoid набор опций
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true, //чтобы отображалось в селенейде, что внутри просиходит
                "enableVideo", true //чтобы писалась запись видео
        ));

        Configuration.browserCapabilities = capabilities;
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}
