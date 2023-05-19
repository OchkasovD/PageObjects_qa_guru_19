package com.demoqa.pageobjects.tests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import com.demoqa.pageobjects.pages.RegistrationPage;
import static com.demoqa.pageobjects.testData.RegistrationPageData.*;
import static com.demoqa.pageobjects.testData.RegistrationFormFieldsView.*;
import static io.qameta.allure.Allure.step;


public class PageObjectsGenDataTest extends RemoteTestBase {
    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    @Tag("remote")
    @DisplayName("Успешное заполнение формы")
    void successfulFillFormatTest() {
        step("Открыть форму", () -> {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setNumber(phoneNumber)
                .setBirthDate(dayValue, monthsValue, yearValue)
                .setSubjects(subjectValue)
                .setHobby(hobbiesValue)
                .uploadPicture(uploadPicture)
                .setCurrentAddress(currentAddress)
                .setState(stateValue)
                .setCity(cityValue)
                .clickSubmit();
        });
        step("Проверить результат", () -> {
        //Проверям форму Thanks for submitting the form//
        registrationPage.verifyRegistrationResultsModalAppears()
                .verifyResult(studentNameField, (firstName+" "+lastName))
                .verifyResult(studentEmailField, userEmail)
                .verifyResult(genderField, userGender)
                .verifyResult(mobileField, phoneNumber)
                .verifyResult(dateBirthField, dayValue+ " " + monthsValue + "," + yearValue)
                .verifyResult(subjectsField, subjectValue)
                .verifyResult(hobbiesField, hobbiesValue)
                .verifyResult(pictureField, uploadPicture)
                .verifyResult(addressField, currentAddress)
                .verifyResult(stateCityField, (stateValue + " " + cityValue));
        });
    }

}
