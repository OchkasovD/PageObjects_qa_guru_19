package com.demoqa.pageobjects.testData;


import java.util.Locale;
import static  com.demoqa.pageobjects.utils.RandomUtils.*;


public class RegistrationPageData {

    public static String firstName = RandomFirstName(),
            lastName = RandomLastName(),
            userEmail = RandomEmail(),
            userGender = RandomGender(),
            phoneNumber = RandomPhone(),
            dayValue = RandomDay(),
            monthsValue = RandomMonth(),
            yearValue = RandomYear();

         //    subjectValue = getRandomSubjects(),
         //    hobbiesValue = getRandomHobbies(),
         //    uploadPicture = "image.png",
         //     currentAddress = faker.address().fullAddress(),
         //     stateValue = getRandomState(),
    //       cityValue = getRandomCity(stateValue);


}
