package com.example.katas.bank_ocr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KataBankOCR {
    public void convert(String input) {
        List<String> chars = new ArrayList<>();
        input.lines().forEach(l -> System.out.println(l.length()));
        input.lines().forEach(l -> {
            for (int i = 0; i < l.toCharArray().length; i++) {
                chars.add(l.charAt(i) + "");
            }
        });
        record Number(String chars) {
            Number {
                if (chars.length() != 9) {
                    throw new RuntimeException("There is an error in input");
                }
            }
        }
        List<Number> numbers = new ArrayList<>();
        var counter = 0;
        System.out.println(chars.size());
        for (int i = 0; i < 30; i += 3) {
            var j = i + 30;
            var k = i + 60;
            numbers.add(
                    new Number(
                            ""
                                    + chars.get(i) + chars.get(i + 1) + chars.get(i + 2)
                                    + chars.get(j) + chars.get(j + 1) + chars.get(j + 2)
                                    + chars.get(k) + chars.get(k + 1) + chars.get(k + 2)));
            counter++;
        }
        if (numbers.get(0).equals(new Number("     |  |"))) {
            System.out.println(1);
        }
        System.out.println(counter);
    }
}
