package com.demoqa.pageobjects.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pageobjects.pages.RegistrationPage;
import com.demoqa.pageobjects.pages.components.CalendarComponent;
import org.junit.jupiter.api.BeforeAll;




public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1024x700";
        Configuration.pageLoadStrategy = "eager";
    }

    RegistrationPage registrationPage = new RegistrationPage();

}