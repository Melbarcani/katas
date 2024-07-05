package com.example.katas.anagram;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Anagram {
    public static List<String> convert() {
        List<String> words = chargeText();
        Set<String> anagram = new TreeSet<>();

        for (int i = 0; i < words.size() - 1; i++) {
            var currentWord = words.get(i);
            var currentSize = currentWord.length();
            for (int j = i + 1; j < words.size(); j++) {
                if (currentSize != words.get(j).length()) {
                    break;
                }
                var str1 = currentWord.toCharArray();
                var str2 = words.get(j).toCharArray();

                Arrays.sort(str1);
                Arrays.sort(str2);
                if (Arrays.equals(str1, str2)) {
                    anagram.add(currentWord);
                    anagram.add(words.get(j));
                }
            }
        }
        return anagram.stream().toList();
    }


    private static List<String> chargeText() {
        ClassLoader loader = Anagram.class.getClassLoader();
        String[] words;
        try {
            Path path = Paths.get(Objects.requireNonNull(loader.getResource("kata/anagram/wordsList.txt")).toURI());
            String allWords = new String(Files.readAllBytes(path));
            words = allWords.split("\s+");
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return Arrays.stream(words).toList();
    }
}
