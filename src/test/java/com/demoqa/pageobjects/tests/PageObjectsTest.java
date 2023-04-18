package com.demoqa.pageobjects.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


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
        .setSubjects("Maths");

        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/images.png"));
        $("#currentAddress").sendKeys("Moscow");
        $("#submit").scrollIntoView(false);
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").scrollIntoView(false);
        $("#submit").click();
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
                .verifyResult("State and City", "Uttar Pradesh Lucknow");

    }

}
