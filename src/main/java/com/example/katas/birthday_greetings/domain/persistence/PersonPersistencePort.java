package com.example.katas.birthday_greetings.domain.persistence;

import com.example.katas.birthday_greetings.domain.model.Person;

import java.time.LocalDate;
import java.util.Optional;

public interface PersonPersistencePort {
    Optional<Person> retrievePersonPerDate(LocalDate date);
}
