package com.example.katas.birthday_greetings.domain;

import com.example.katas.birthday_greetings.domain.model.Person;

public class GreetingCreator {

    public static final String MESSAGE_TEMPLATE_LAST_NAME = """
            Subject: Happy birthday!
                            
            Happy birthday, dear %s!
            """;

    public static String createFromBirthdayTemplate(Person person) {
        return MESSAGE_TEMPLATE_LAST_NAME.formatted(person.lastName());
    }
}
