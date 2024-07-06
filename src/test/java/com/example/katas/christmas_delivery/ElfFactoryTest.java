package com.example.katas.christmas_delivery;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElfFactoryTest {

    @Test
    void shouldCreateTypeOfElf(){
        var elfFactory = new ElfFactory();
        Assertions.assertThat(elfFactory.createElf()).isInstanceOf(Elf.class);
    }

}