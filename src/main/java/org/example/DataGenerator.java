package org.example;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    public static String generateCorectName() {
        Faker faker = new Faker(new Locale("ru"));

        // Генерируем случайные имя и фамилию
        String Name = faker.name().name();
        return Name;
    }

    public static String generateCorectCity(){
        Random random = new Random();
        String[] properNoun = {"Москва", "Владивосток", "Майкоп"};
        int cityIndex = random.nextInt(properNoun.length);
        return properNoun[cityIndex];
    }

    public static String generateCorectPhonenumber(){
        Faker faker = new Faker(new Locale("ru"));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static String generateInCorectName() {
        Faker faker = new Faker();

        // Генерируем случайные имя и фамилию
        String Name = faker.name().name();
        return Name;
    }

    public static String generateInCorectCity(){
        Random random = new Random();
        String[] properNoun = {"Париж", "Лондон", "Долгопрудный"};
        int cityIndex = random.nextInt(properNoun.length);
        return properNoun[cityIndex];
    }

    public static String generateInCorectPhonenumber(){
        Faker faker = new Faker();
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static String generateDate(long addDays, String pattern){
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }



}