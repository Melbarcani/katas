package com.example.katas.fizzbuzz;

public class FizzBuzz {
    public String run(int input) {
        var limit = input + 1;
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i < limit; i++) {
            Integer a = i;
            switch (a) {
                case Integer b when b % 15 == 0 -> builder.append("fizzbuzz").append(" ");
                case Integer b when b % 5 == 0 -> builder.append("buzz").append(" ");
                case Integer b when b % 3 == 0 -> builder.append("fizz").append(" ");
                case Integer b -> builder.append(b).append(" ");
            }
        }
        return builder.substring(0, builder.length() - 1);
    }
}
