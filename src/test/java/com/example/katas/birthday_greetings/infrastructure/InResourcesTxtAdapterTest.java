package com.example.katas.birthday_greetings.infrastructure;

import com.example.katas.birthday_greetings.domain.model.Person;
import com.example.katas.birthday_greetings.domain.persistence.PersonPersistencePort;
import com.example.katas.birthday_greetings.infrastructure.persistence.InResourcesTxtAdapter;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class InResourcesTxtAdapterTest {

    @Test
    void shouldReturnPersonFromData(){
        PersonPersistencePort personPersistencePort = new InResourcesTxtAdapter();
        var date = LocalDate.of(1982,10,8);
        var people = personPersistencePort.retrievePersonPerDate(date);
        assertThat(people).isPresent();
        assertThat(people.get()).isEqualTo(new Person("Doe", "John", date, "john.doe@foobar.com"));
    }

}