package com.demoqa.pageobjects.utils;
import com.demoqa.pageobjects.pages.components.enums.*;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import com.github.javafaker.Faker;



public class RandomUtils {
    public static Faker faker = new Faker();
    static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December"};
    static String[] genders = {"Male", "Female", "Other"};
    static String[] year = {"1984", "1975", "2006", "2000", "1999"};
    static String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
    static String[] cityForNCR = {"Delhi", "Gurgaon", "Noida"};
    static String[] cityForUttarPradesh = {"Agra", "Lucknow", "Merrut"};
    static String[] cityForHaryana = {"Karnal", "Panipat"};
    static String[] cityForRajasthan = {"Jaipur", "Jaiselmer"};


    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static <T extends Enum<?>> T getRandomEnum(Class<T> enumClass) {
        int index = getRandomInt(0, enumClass.getEnumConstants().length - 1);
        return enumClass.getEnumConstants()[index];

    }

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomGender() {
        return faker.options().option(genders);
    }

    public static String getRandomPhone() {
        return faker.numerify("##########");
    }

    public static String getRandomDay() {
        int day = getRandomInt(1, 30);
        if (day < 10) {
            return "0" + day;
        } else {
            return Integer.toString(day);
        }
    }

    public static String getRandomMonth() {
        return faker.options().option(months);
    }

    public static String getRandomYear() {
        return faker.options().option(year);
    }

    public static String getRandomSubjects() {
        return getRandomEnum(SubjectsEnum.class).getSubjects();
    }

    public static String getRandomHobbies() {
        return getRandomEnum(HobbiesEnum.class).getHobbies();
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();

    }

    public static String getRandomState() {
        return faker.options().option(state);
    }
    public static String getRandomCity(String state){
        String city;
        if (Objects.equals(state, "NCR")) {
            city = faker.options().option(cityForNCR);
            return city;
        } else if (Objects.equals(state, "Uttar Pradesh")) {
            city = faker.options().option(cityForUttarPradesh);
            return city;
        } else if (Objects.equals(state, "Haryana")) {
            city = faker.options().option(cityForHaryana);
            return city;
        } else if (Objects.equals(state, "Rajasthan")){
            city = faker.options().option(cityForRajasthan);
            return city;
        }
        return null;
    }
}