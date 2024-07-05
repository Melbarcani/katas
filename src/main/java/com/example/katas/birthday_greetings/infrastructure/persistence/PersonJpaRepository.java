package com.example.katas.birthday_greetings.infrastructure.persistence;

import com.example.katas.birthday_greetings.domain.model.Person;
import com.example.katas.birthday_greetings.infrastructure.persistence.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Repository
public interface PersonJpaRepository extends JpaRepository<Long, PersonEntity> {
    Optional<PersonEntity> findBy(LocalDate birthDate);
}
