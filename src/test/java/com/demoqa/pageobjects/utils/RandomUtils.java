package com.demoqa.pageobjects.utils;
import com.demoqa.pageobjects.pages.components.enums.GendersEnum;
import com.github.javafaker.Faker;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    private static Faker faker = new Faker();
    static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
           "October", "November", "December"};
    static String[] year = {"1984", "1975", "2006", "2000","1999"};


    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static <T extends Enum<?>> T getRandomEnum(Class<T> enumClass) {
        int index = getRandomInt(0,enumClass.getEnumConstants().length - 1);
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
    public static String RandomGender(){
        return getRandomEnum(GendersEnum.class).getGenders();
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
}
