package com.nopcommerce.demo.utils;

import com.github.javafaker.Faker;

public class DataUtils {
    private static Faker faker;

    public static DataUtils getData() {
        return new DataUtils();
    }

    private DataUtils() {
        faker = new Faker();
    }

    public String getFirtName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getEmailAddress() {
        return faker.internet().emailAddress();
    }

    public String getFirstNameAddress() {
        return faker.address().firstName();
    }

    public String getPhoneNumber() {
        return faker.numerify("0#########");
    }

    public String getCity() {
        return faker.address().city();
    }

    public int getPin() {
        return faker.number().numberBetween(000000, 999999);
    }

    public String getRandomDOB() {
        Faker faker = new Faker();
        String dob = faker.date().birthday().toString();
        return dob.toString();
    }

    public int getDayNumber() {
        return faker.number().numberBetween(1, 28);
    }

    public int getMonthNumber() {
        return faker.number().numberBetween(1, 12);
    }

    public int getYearNumber() {
        return faker.number().numberBetween(1990, 2022);
    }

    public String getCompanyNameNumber() {
        return faker.company().name();
    }

    public String getCountry() {
        return faker.country().name();
    }

    public String getState() {
        return faker.address().state();
    }
}
