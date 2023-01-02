package com.nopcommerce.demo.feature;

import com.github.javafaker.Faker;

public class RunTest {
    public static void main(String[] args) {
        Faker faker = new Faker();
//        System.out.println(faker.phoneNumber().cellPhone([0-9]);
//        System.out.println(faker.instance().expression("84|0[3|5|7|8|9])+([0-9]{8}");
        System.out.println(faker.numerify("0#########"));
    }
}
