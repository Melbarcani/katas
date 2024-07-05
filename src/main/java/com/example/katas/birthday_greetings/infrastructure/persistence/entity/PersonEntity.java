package com.example.katas.birthday_greetings.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class PersonEntity {

    @Id
    @GeneratedValue()
    private Long id;

    @Column
    private String lastName;

    @Column
    private String firstName;

    public String firstName() {
        return firstName;
    }
}
