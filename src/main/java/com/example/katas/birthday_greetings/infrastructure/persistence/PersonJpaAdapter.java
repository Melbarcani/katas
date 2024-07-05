package com.example.katas.birthday_greetings.infrastructure.persistence;

import com.example.katas.birthday_greetings.domain.model.Person;
import com.example.katas.birthday_greetings.domain.persistence.PersonPersistencePort;
import com.example.katas.birthday_greetings.infrastructure.persistence.entity.PersonEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
@Profile("local")
public class PersonJpaAdapter implements PersonPersistencePort {
    private final PersonJpaRepository personJpaRepository;

    public PersonJpaAdapter(PersonJpaRepository personJpaRepository) {
        this.personJpaRepository = personJpaRepository;
    }

    @Override
    public Optional<Person> retrievePersonPerDate(LocalDate date) {
        return personJpaRepository.findBy(date).map(PersonJpaAdapter::mapTo);
    }

    private static Person mapTo(PersonEntity entity){
        return null;
    }
}
