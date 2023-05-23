package com.demoqa.pageobjects.tests;
import com.demoqa.pageobjects.pages.TextBoxPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.demoqa.pageobjects.testData.TextBoxPageData.*;
import static io.qameta.allure.Allure.step;


public class BoxTestsGenDataTest extends ParamTestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    @Test
    @Tag("smoke")
    @DisplayName("Успешное заполнение формы")
    void successfulFillFormTest() {
        step("Заполнить форму", () -> {
        textBoxPage.openPage()
                .setFullName(userName)
                .setEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmit();
        });
        step("Проверить результат", () -> {
        textBoxPage.verifyOutputName(userName)
                .verifyOutputEmail(userEmail)
                .verifyOutputCurrentAddress(currentAddress)
                .verifyOutputPermanentAddress(permanentAddress);
        });
    }
}