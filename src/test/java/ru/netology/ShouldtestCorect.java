package ru.netology;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class ShouldtestCorect {

    @BeforeEach
    void setup(){
        open("http://localhost:9999");
    }

    @Test
    void houldReturnSuccessIfFieldsAreFilledInCorrectl(){

    }
}
