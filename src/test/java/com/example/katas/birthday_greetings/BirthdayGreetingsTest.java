package com.example.katas.birthday_greetings;

import com.example.katas.birthday_greetings.domain.model.Person;
import com.example.katas.birthday_greetings.domain.persistence.PersonPersistencePort;
import com.example.katas.birthday_greetings.infrastructure.persistence.InResourcesTxtAdapter;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BirthdayGreetingsTest {

    @Test
    void shouldBirthdayWhenDateIs(){
        // Given
        var date = LocalDate.of(1982,10,8);
        PersonPersistencePort personPersistencePort = mock(InResourcesTxtAdapter.class);
        when(personPersistencePort.retrievePersonPerDate(date)).thenReturn(Optional.of(new Person(
                "Doe", "John", date, "john.doe@foobar.com"
        )));
        var birthdayGreetings = new BirthdayGreetings(personPersistencePort);
        // When
        var message = birthdayGreetings.send(date);

        // Then
        assertThat(message).isEqualTo("""
                Subject: Happy birthday!
                                
                Happy birthday, dear Doe!
                """);
    }

}