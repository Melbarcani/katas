package com.example.katas.anagram;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AnagramTest {

    @Test
    void anagramTest(){
        var list = Anagram.convert();
        System.out.println(list);
        assertThat(list).contains("glean");
        assertThat(list).contains("angel");
    }

}