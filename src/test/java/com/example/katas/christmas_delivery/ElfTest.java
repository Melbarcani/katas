package com.example.katas.christmas_delivery;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class ElfTest {

    @Test
    void shouldWait2seconds(){
        Elf elf = new Elf();
        LocalDateTime before = LocalDateTime.now();
        elf.givesPresent(new Present("present1"));
        var after = LocalDateTime.now();
        Duration duration = Duration.between(before, after);
        assertThat(duration).isGreaterThan(Duration.ofSeconds(2));
    }

}