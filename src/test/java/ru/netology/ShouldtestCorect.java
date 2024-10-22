package ru.netology;


import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.example.DataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ShouldtestCorect {



    @BeforeEach
    void setup(){
        open("http://localhost:9999");
    }

    @Test
    void houldReturnSuccessIfFieldsAreFilledInCorrectl(){

        $("[data-test-id='city'] [placeholder='Город']").setValue(DataGenerator.generateCity());
        $("[data-test-id='name'] [type = text]").setValue(DataGenerator.generateName());
        $("[data-test-id='phone'] [placeholder='+7 000 000 00 00']").setValue(DataGenerator.generatePhonenumber());
        $("[data-test-id=agreement]").click();
        $("[role=button] .button__content").click();
        $(withText("Успешно!")).shouldBe(Condition.visible);
        //$("[data-test-id='notification'] .notification__content")
           //     .shouldHave(Condition.exactText("Встреча успешно забронирована на " + DataGenerator.generateDate(3, "dd.MM.yyyy")));
    }
}
