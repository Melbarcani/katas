package com.example.katas.birthday_greetings;

import com.example.katas.birthday_greetings.domain.GreetingCreator;
import com.example.katas.birthday_greetings.domain.persistence.PersonPersistencePort;

import java.time.LocalDate;

public class BirthdayGreetings {

    public final PersonPersistencePort personPersistencePort;

    public BirthdayGreetings(PersonPersistencePort personPersistencePort) {
        this.personPersistencePort = personPersistencePort;
    }

    public String send(LocalDate date) {
        var person = personPersistencePort.retrievePersonPerDate(date);
        return person.map(GreetingCreator::createFromBirthdayTemplate).orElseThrow(RuntimeException::new);
    }
}
