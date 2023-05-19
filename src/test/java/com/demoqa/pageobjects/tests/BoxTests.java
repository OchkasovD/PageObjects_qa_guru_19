package com.demoqa.pageobjects.tests;
import com.demoqa.pageobjects.pages.TextBoxPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class BoxTests extends RemoteTestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    @Tag("remote")
    @DisplayName("Успешное заполнение формы")
    void successfulFillFormTest() {
        step("Заполнить форму", () -> {
        textBoxPage.openPage()
                .setFullName("Name")
                .setEmail("mail@mail.com")
                .setCurrentAddress("street")
                .setPermanentAddress("street1")
                .clickSubmit();
        });
        step("Проверить результат", () -> {
        textBoxPage.verifyOutputName("Name")
                .verifyOutputEmail("mail@mail.com")
                .verifyOutputCurrentAddress("street")
                .verifyOutputPermanentAddress("street1");
        });
    }
}