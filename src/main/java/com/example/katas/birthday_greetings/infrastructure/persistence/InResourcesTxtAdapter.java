package com.example.katas.birthday_greetings.infrastructure.persistence;

import com.example.katas.birthday_greetings.domain.model.Person;
import com.example.katas.birthday_greetings.domain.persistence.PersonPersistencePort;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class InResourcesTxtAdapter implements PersonPersistencePort {

    public static final int FIREST_DATA_LINE = 1;

    @Override
    public Optional<Person> retrievePersonPerDate(LocalDate date) {
        ClassLoader loader = InResourcesTxtAdapter.class.getClassLoader();
        Optional<Person> person = Optional.empty();
        try {
            Path path = Paths.get(Objects.requireNonNull(loader.getResource("kata/birthday_greetings/birthday_greetings.txt").toURI()));
            List<String> lines = Files.lines(path).toList();
            for (int i = FIREST_DATA_LINE; i < lines.size(); i++) {
                String[] personDetails = lines.get(i).split(",");
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDate foundDate = LocalDate.parse(personDetails[2].trim(), dateTimeFormatter);
                if (foundDate.isEqual(date)) {
                    person = Optional.of(new Person(
                            personDetails[0].trim(),
                            personDetails[1].trim(),
                            LocalDate.parse(personDetails[2].trim(), dateTimeFormatter),
                            personDetails[3].trim()));
                }
            }

        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
        return person;
    }
}
