package com.example.katas.harry;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.katas.harry.Title.CHAMBER_OF_SECRETS;
import static com.example.katas.harry.Title.GOBLET_OF_FIRE;
import static com.example.katas.harry.Title.ORDER_OF_THE_PHOENIX;
import static com.example.katas.harry.Title.PRISONER_OF_AZKABAN;
import static com.example.katas.harry.Title.SORCERERS_STONE;

public class Harry {

    public static double price(Map<Title, Integer> booksNumber) {
        List<Integer> counts = new ArrayList<>(booksNumber.values());
        return findOptimalPrice(counts);
    }

    private static double findOptimalPrice(List<Integer> counts) {
        double[] discounts = {0, 1, 0.95, 0.90, 0.80, 0.75};
        int maxDistinctBooks = 5;
        double minPrice = Double.MAX_VALUE;

        for (int i = 1; i <= maxDistinctBooks; i++) {
            double price = 0;
            List<Integer> tempCounts = new ArrayList<>(counts);
            while (!tempCounts.isEmpty() && tempCounts.stream().anyMatch(tempC -> tempC > 0)) {
                int distinctBooks = 0;
                for (int j = 0; j < tempCounts.size() && distinctBooks < i; j++) {
                    if (tempCounts.get(j) > 0) {
                        tempCounts.set(j, tempCounts.get(j) - 1);
                        distinctBooks++;
                    }
                }
                price += distinctBooks * 8 * discounts[distinctBooks];
            }
            minPrice = Math.min(minPrice, price);
        }

        return minPrice;
    }

enum HarryPotterBook {
    SORCERERS_STONE("Harry Potter à l'école des sorciers"),
    CHAMBER_OF_SECRETS("Harry Potter et la Chambre des secrets"),
    PRISONER_OF_AZKABAN("Harry Potter et le Prisonnier d'Azkaban"),
    GOBLET_OF_FIRE("Harry Potter et la Coupe de feu"),
    ORDER_OF_THE_PHOENIX("Harry Potter et l'Ordre du Phénix");

    private final String title;

    HarryPotterBook(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}}
/*
    public Double buy(Map<Title, Integer> booksNumber) {
        var boucle = booksNumber.values().stream().max(Integer::compareTo).orElse(0);
        var minPrice = Double.MAX_VALUE;
        for (int j = 0; j < boucle; j++) {
            var copy = new EnumMap<>(booksNumber);
            List<Integer> differentBooks = new ArrayList<>();
            for (int i = 0; i < boucle - j; i++) {
                differentBooks.add(i, 0);
                var stage = i;
                copy.entrySet().stream().filter(k -> k.getValue() > 0).forEach(v -> {
                    differentBooks.set(stage, differentBooks.get(stage) + 1);
                    v.setValue(v.getValue() - 1);
                });
            }
            var optionalPrice = differentBooks.stream().map(Harry::giveMeThePrice).reduce(0.0, Double::sum);
            minPrice = minPrice > optionalPrice ? optionalPrice : minPrice;
        }
        return minPrice;
    }

    private static Double giveMeThePrice(Integer booksNumber) {
        return switch (booksNumber) {
            case 1 -> (booksNumber * (double) BASIC_PRICE);
            case 2 -> booksNumber * BASIC_PRICE * 0.95;
            case 3 -> booksNumber * BASIC_PRICE * 0.90;
            case 4 -> booksNumber * BASIC_PRICE * 0.80;
            case 5 -> booksNumber * BASIC_PRICE * 0.75;
            default -> throw new RuntimeException("unknown number");
        };
    }*/

