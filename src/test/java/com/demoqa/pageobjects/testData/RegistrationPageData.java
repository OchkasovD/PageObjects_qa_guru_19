package com.demoqa.pageobjects.testData;
import static  com.demoqa.pageobjects.utils.RandomUtils.*;

public class RegistrationPageData {

    public static String firstName = RandomFirstName(),
            lastName = RandomLastName(),
            userEmail = RandomEmail(),
            userGender = RandomGender(),
            phoneNumber = RandomPhone(),
            dayValue = RandomDay(),
            monthsValue = RandomMonth(),
            yearValue = RandomYear(),
            subjectValue = RandomSubjects(),
            hobbiesValue = RandomHobbies(),
            uploadPicture = "images.png",
            currentAddress = RandomAddress(),
            stateValue = RandomState(),
            cityValue = RandomCity(stateValue);

}
