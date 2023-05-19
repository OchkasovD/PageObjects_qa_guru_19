package com.demoqa.pageobjects.tests;
import com.demoqa.pageobjects.pages.RegistrationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class PageObjectsTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("remote")
    @DisplayName("Успешное заполнение формы")
    void successfulFillFormatTest() {
        step("Открыть форму", () -> {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Dmitry")
                .setLastName("Ochkasov")
                .setUserEmail("test@mail.ru")
                .setGender("Other")
                .setNumber("1234567890")
                .setBirthDate("27", "May", "1984")
                .setSubjects("Maths")
                .setHobby("Sports")
                .uploadPicture("images.png")
                .setCurrentAddress("Moscow")
                .setState("Haryana")
                .setCity("Panipat")
                .clickSubmit();
        });
        step("Проверить результат", () -> {
        //Проверям форму Thanks for submitting the form//
        registrationPage.verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name", "Dmitry Ochkasov")
                .verifyResult("Student Email", "test@mail.ru")
                .verifyResult("Gender", "Other")
                .verifyResult("Mobile", "1234567890")
                .verifyResult("Date of Birth", "27 May,1984")
                .verifyResult("Subjects", "Maths")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "images.png")
                .verifyResult("Address", "Moscow")
                .verifyResult("State and City", "Haryana Panipat");
        });

    }

}
