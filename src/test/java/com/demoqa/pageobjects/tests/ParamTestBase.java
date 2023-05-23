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

public class ParamTestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
        String[] browserAndVersion = System.getProperty("browser", "chrome:100.0").split(":");
        Configuration.browser = browserAndVersion[0];
        Configuration.browserVersion = browserAndVersion[1];
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.pageLoadStrategy = "eager";

        Configuration.remote = String.format("https://%s:%s@%s",
                System.getProperty("selenoidLogin", "user1"),
                System.getProperty("selenoidPassword", "1234"),
                System.getProperty("selenoidUrl", "https://selenoid.autotests.cloud/wd/hub").replace("https://", "")
        );

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
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

