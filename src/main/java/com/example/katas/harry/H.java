package com.example.katas.harry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class H {
    private static final Integer MAX_DISTINCT_BOOKS = 5;

    private static final double[] DISCOUNTS = {0, 1, 0.95, 0.90, 0.80, 0.75};

    public Double price(Map<Title, Integer> command) {
        List<Integer> counts = new ArrayList<>(command.values());
        return computeOptimumPrice(counts);
    }

    private static Double computeOptimumPrice(List<Integer> counts) {
        var minPrice = Double.MAX_VALUE;
        for (int i = 1; i < MAX_DISTINCT_BOOKS + 1; i++) {
            var price = 0.0;
            List<Integer> tempCounts = new ArrayList<>(counts);
            while (!tempCounts.isEmpty() && tempCounts.stream().anyMatch(c -> c > 0)) {
                var distinctBooks = 0;
                for (int j = 0; j < tempCounts.size() && distinctBooks < i; j++) {
                    if (tempCounts.get(j) > 0) {
                        tempCounts.set(j, tempCounts.get(j) - 1);
                        distinctBooks++;
                    }
                }
                price += distinctBooks * 8 * DISCOUNTS[distinctBooks];
            }
            minPrice = Math.min(minPrice, price);
        }
        return minPrice;
    }
}
