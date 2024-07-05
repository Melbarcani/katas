package com.example.katas.birthday_greetings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;

@SpringBootTest
class BirthdayGreetingsIT {

    @Test
    @DisplayName("""
            Given a request with birthdate
            When request is triggered
            A greetings message is responded""")
    void shouldTriggerGreetings() {
        var response = given()
                .get("/greetings");
        Assertions.assertThat(response).isInstanceOf(String.class);
    }
}
