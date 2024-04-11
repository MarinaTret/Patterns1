package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity(String locale) {
        var cities = new String[]{"Астрахань", "Кострома", "Краснодар", "Москва", "Ростов-на-Дону",
                "Салехард", "Самара", "Санкт-Петербург", "Саранск", "Саратов", "Севастополь", "Чебоксары",
                "Элиста", "Южно-Сахалинск", "Ярославль", "Абакан", "Екатеринбург", "Тамбов", "Хабаровск",
                "Владивосток", "Томск", "Петрозаводск", "Тюмень", "Благовещенск", "Йошкар-Ола", "Уфа",
                "Улан-Удэ", "Брянск","Нижний Новгород", "Великий Новгород"
        };
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static String generateWrongPhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.numerify("####");
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(locale),generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
