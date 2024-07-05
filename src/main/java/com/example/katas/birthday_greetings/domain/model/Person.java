package com.example.katas.birthday_greetings.domain.model;

import java.time.LocalDate;

public record Person(String lastName, String firstName, LocalDate birthdate, String mail) {
}
