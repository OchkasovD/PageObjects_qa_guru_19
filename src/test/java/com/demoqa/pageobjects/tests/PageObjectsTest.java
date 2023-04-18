package com.demoqa.pageobjects.tests;
import org.junit.jupiter.api.Test;

public class PageObjectsTest extends TestBase {

    @Test
    void successfulFillFormatTest () {
        registrationPage.openPage()
        .setFirstName("Dmitry")
        .setLastName("Ochkasov")
        .setUserEmail("test@mail.ru")
        .setGender("Other")
        .setNumber("1234567890")
        .setBirthDate("27","May","1984")
        .setSubjects("Maths")
        .setHobby("Sports")
        .uploadPicture("images.png")
        .setCurrentAddress("Moscow")
        .setState("Haryana")
        .setCity("Panipat")
        .clickSubmit();
        //Проверям форму Thanks for submitting the form//
        registrationPage.verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name","Dmitry Ochkasov")
                .verifyResult("Student Email", "test@mail.ru")
                .verifyResult("Gender", "Other")
                .verifyResult("Mobile", "1234567890")
                .verifyResult("Date of Birth", "27 May,1984")
                .verifyResult("Subjects", "Maths")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "images.png")
                .verifyResult("Address", "Moscow")
                .verifyResult("State and City", "Haryana Panipat");

    }

}
