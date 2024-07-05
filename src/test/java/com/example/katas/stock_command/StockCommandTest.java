package com.example.katas.stock_command;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class StockCommandTest {

    @Test
    void shouldCommandAvailableArticles(){
        Map<String, Integer> currentStock = generateDefaultCurrentStock();
        Map<String, Integer> availableArticles = generateDefaultAvailable();

        StockCommand stockCommand = new StockCommand();
        stockCommand.command(currentStock, availableArticles);

        Map<String, Integer> expectedCommand = createExpected();

        Assertions.assertThat(stockCommand.getNewCommand()).isEqualTo(expectedCommand);
    }

    private static Map<String, Integer> generateDefaultAvailable() {
        Map<String, Integer> availableArticles = new HashMap<>();
        availableArticles.put("Article1", 100);
        availableArticles.put("Article2", 80);
        availableArticles.put("Article3", 3);
        availableArticles.put("Article4", 50);
        availableArticles.put("Article5", 60);
        availableArticles.put("Article6", 55);
        availableArticles.put("Article7", 75);
        availableArticles.put("Article8", 85);
        availableArticles.put("Article9", 95);
        availableArticles.put("Article10", 50);
        return availableArticles;
    }

    private static Map<String, Integer> generateDefaultCurrentStock() {
        Map<String, Integer> currentStock = new HashMap<>();
        currentStock.put("Article1", 50);
        currentStock.put("Article2", 30);
        currentStock.put("Article3", 20);
        currentStock.put("Article4", 60);
        currentStock.put("Article5", 10);
        currentStock.put("Article6", 15);
        currentStock.put("Article7", 25);
        currentStock.put("Article8", 35);
        currentStock.put("Article9", 40);
        currentStock.put("Article10", 5);
        return currentStock;
    }

    private static Map<String, Integer> createExpected() {
        Map<String, Integer> expectedCommand = new HashMap<>();
        expectedCommand.put("Article1", 50);
        expectedCommand.put("Article2", 30);
        expectedCommand.put("Article3", 3);
        expectedCommand.put("Article4", 50);
        expectedCommand.put("Article5", 10);
        expectedCommand.put("Article6", 15);
        expectedCommand.put("Article7", 25);
        expectedCommand.put("Article8", 35);
        expectedCommand.put("Article9", 40);
        expectedCommand.put("Article10", 5);
        return expectedCommand;
    }
}