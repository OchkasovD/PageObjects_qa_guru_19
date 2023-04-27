package com.demoqa.pageobjects.testData;
import static  com.demoqa.pageobjects.utils.RandomUtils.*;

public class RegistrationPageData {

    public static String firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            userEmail = getRandomEmail(),
            userGender = getRandomGender(),
            phoneNumber = getRandomPhone(),
            dayValue = getRandomDay(),
            monthsValue = getRandomMonth(),
            yearValue = getRandomYear(),
            subjectValue = getRandomSubjects(),
            hobbiesValue = getRandomHobbies(),
            uploadPicture = "images.png",
            currentAddress = getRandomAddress(),
            stateValue = getRandomState(),
            cityValue = getRandomCity(stateValue);

}
