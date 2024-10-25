package ru.netology;


import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.example.DataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Все поля заполненны корректно")
    void ShouldReturnSuccessIfFieldsAreFilledCorrectl(){

        $("[data-test-id='city'] [placeholder='Город']").setValue(DataGenerator.generateCorectCity());
        $("[data-test-id='name'] [type = text]").setValue(DataGenerator.generateCorectName());
        $("[data-test-id='phone'] [placeholder='+7 000 000 00 00']").setValue(DataGenerator.generateCorectPhonenumber());
        $("[data-test-id=agreement]").click();
        $("[role=button] .button__content").click();
        $(withText("Успешно!")).shouldBe(Condition.visible);
        $("[role=button] .button__content").click();
        $(withText("Перепланировать")).click();
    }

    @Test
    @DisplayName("Ошибка при неправильноуказанном городе")
    public void shouldReturnErrorMessageIfCityInvalid() {

        $("[data-test-id='city'] [placeholder='Город']").setValue(DataGenerator.generateInCorectCity());
        $("[data-test-id='name'] [type=text]").setValue(DataGenerator.generateCorectName());
        $("[data-test-id='phone'] [type=tel]").setValue(DataGenerator.generateCorectPhonenumber());
        $("[data-test-id=agreement]").click();
        $("[role=button] .button__content").click();
        $("[data-test-id='city'].input_invalid .input__sub").shouldBe(visible).
                shouldHave(exactText("Доставка в выбранный город недоступна"));
    }

    @Test
    @DisplayName("Фамилия содержит дефис")
    void shouldReturnSuccsesfulyIfNameOrSurnameHaveDefise(){
        $("[data-test-id='city'] [placeholder='Город']").setValue(DataGenerator.generateCorectCity());
        $("[data-test-id='name'] [type=text]").setValue(DataGenerator.generateCorectName() + "-");
        $("[data-test-id='phone'] [type=tel]").setValue(DataGenerator.generateCorectPhonenumber());
        $("[data-test-id=agreement]").click();
        $("[role=button] .button__content").click();
        $(withText("Успешно!")).shouldBe(Condition.visible);
        $("[role=button] .button__content").click();
        $(withText("Перепланировать")).click();
    }

    @Test
    @DisplayName("Нажвание города содержит дефис")
    void shouldReturnSuccsesfulyIfCityHaveDefise(){
        $("[data-test-id='city'] [placeholder='Город']").setValue("Ростов-на-дону");
        $("[data-test-id='name'] [type=text]").setValue(DataGenerator.generateCorectName());
        $("[data-test-id='phone'] [type=tel]").setValue(DataGenerator.generateCorectPhonenumber());
        $("[data-test-id=agreement]").click();
        $("[role=button] .button__content").click();
        $(withText("Успешно!")).shouldBe(Condition.visible);
        $("[role=button] .button__content").click();
        $(withText("Перепланировать")).click();


    }
}
