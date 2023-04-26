package com.demoqa.pageobjects.testData;
import com.github.javafaker.Faker;

public class TextBoxPageData {
    public static Faker faker = new Faker();
    public static String userName = faker.name().firstName(),
            userEmail = faker.internet().emailAddress(),
            currentAddress = faker.address().fullAddress(),
            permanentAddress = faker.address().fullAddress();
                  }
