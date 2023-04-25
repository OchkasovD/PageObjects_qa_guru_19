package com.demoqa.pageobjects.utils;
import com.demoqa.pageobjects.pages.components.enums.*;
import java.util.concurrent.ThreadLocalRandom;
import com.github.javafaker.Faker;



public class RandomUtils {
    private static Faker faker = new Faker();
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

    public static String RandomFirstName() {
        return faker.name().firstName();
    }

    public static String RandomLastName() {
        return faker.name().lastName();
    }

    public static String RandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String RandomGender() {
        return faker.options().option(genders);
    }

    public static String RandomPhone() {
        return faker.numerify("##########");
    }

    public static String RandomDay() {
        int day = getRandomInt(1, 30);
        if (day < 10) {
            return "0" + Integer.toString(day);
        } else {
            return Integer.toString(day);
        }
    }

    public static String RandomMonth() {
        return faker.options().option(months);
    }

    public static String RandomYear() {
        return faker.options().option(year);
    }

    public static String RandomSubjects() {
        return getRandomEnum(SubjectsEnum.class).getSubjects();
    }

    public static String RandomHobbies() {
        return getRandomEnum(HobbiesEnum.class).getHobbies();
    }

    public static String RandomAddress() {
        return faker.address().fullAddress();

    }

    public static String RandomState() {
        return faker.options().option(state);
    }
    public static String RandomCity(String state){
        String city;
        if (state == "NCR") {
            city = faker.options().option(cityForNCR);
            return city;
        } else if (state == "Uttar Pradesh") {
            city = faker.options().option(cityForUttarPradesh);
            return city;
        } else if (state == "Haryana") {
            city = faker.options().option(cityForHaryana);
            return city;
        } else if (state == "Rajasthan"){
            city = faker.options().option(cityForRajasthan);
            return city;
        }
        return null;
    }
}