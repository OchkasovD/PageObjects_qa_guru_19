package com.demoqa.pageobjects.tests;
import com.demoqa.pageobjects.testData.RegistrationPageData;
import org.junit.jupiter.api.Test;
import com.demoqa.pageobjects.pages.RegistrationPage;
import static com.demoqa.pageobjects.testData.RegistrationPageData.*;


public class PageObjectsGenerateDataTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationPageData registrationPageData = new RegistrationPageData();

    @Test
    void successfulFillFormatTest() {

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

    }

}
