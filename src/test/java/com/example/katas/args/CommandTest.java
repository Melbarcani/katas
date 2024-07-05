package com.example.katas.args;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CommandTest {

    private Command command;
    @BeforeEach
    void setup(){
        command = new Command();
    }
    @Test
    void shouldWorkWithoutArgs(){
        assertThat(command.listArgs()).isEmpty();
    }

    @Test
    void tArgShouldBeBoolean(){
        command.run("-t");
    }

}