package com.demoqa.pageobjects.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pageobjects.pages.RegistrationPage;
import com.demoqa.pageobjects.pages.TextBoxPage;
import org.junit.jupiter.api.BeforeAll;




public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    RegistrationPage registrationPage = new RegistrationPage();
    TextBoxPage textBoxPage = new TextBoxPage();

}