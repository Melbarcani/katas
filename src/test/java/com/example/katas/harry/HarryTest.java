package com.example.katas.harry;

import com.example.katas.harry.H;
import com.example.katas.harry.Harry;
import com.example.katas.harry.Title;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static com.example.katas.harry.Title.*;
import static org.assertj.core.api.Assertions.assertThat;

class HarryTest {

    private H harry;
    private Map<Title, Integer> command;

    @BeforeEach
    void setup(){
        harry = new H();
        command = new EnumMap<>(Title.class);
    }

    @Test
    void oneCopyShouldBeBoughtAt8(){
        command.put(ORDER_OF_THE_PHOENIX, 1);
        assertThat(harry.price(command)).isEqualTo(8);
    }

    @Test
    void twoShouldHaveDiscount5Percent(){
        command.put(CHAMBER_OF_SECRETS, 1);
        command.put(GOBLET_OF_FIRE,1);
        assertThat(harry.price(command)).isEqualTo(15.2);
    }

    @Test
    void thereeShouldHave10Percent(){
        command.put(CHAMBER_OF_SECRETS, 1);
        command.put(GOBLET_OF_FIRE,1);
        command.put(SORCERERS_STONE,1);
        assertThat(harry.price(command)).isEqualTo(21.6);
    }

    @Test
    void fourDiscount20(){
        command.put(CHAMBER_OF_SECRETS, 1);
        command.put(GOBLET_OF_FIRE,1);
        command.put(SORCERERS_STONE,1);
        command.put(ORDER_OF_THE_PHOENIX, 1);

        assertThat(harry.price(command)).isEqualTo(25.60);
    }

    @Test
    void fiveDiscount25(){
        command.put(CHAMBER_OF_SECRETS, 1);
        command.put(GOBLET_OF_FIRE,1);
        command.put(SORCERERS_STONE,1);
        command.put(ORDER_OF_THE_PHOENIX, 1);
        command.put(PRISONER_OF_AZKABAN, 1);

        assertThat(harry.price(command)).isEqualTo(30);
    }

    @Test
    void fourBooks3DifferentTitles(){
        command.put(CHAMBER_OF_SECRETS, 1);
        command.put(GOBLET_OF_FIRE,1);
        command.put(SORCERERS_STONE,2);

        assertThat(harry.price(command)).isEqualTo(29.6);
    }

    @Test
    void melange(){
        command.put(SORCERERS_STONE, 2);
        command.put(CHAMBER_OF_SECRETS, 2);
        command.put(PRISONER_OF_AZKABAN, 2);
        command.put(GOBLET_OF_FIRE, 1);
        command.put(ORDER_OF_THE_PHOENIX, 1);

        assertThat(harry.price(command)).isEqualTo(51.2);
    }
}