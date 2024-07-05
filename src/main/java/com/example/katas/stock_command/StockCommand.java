package com.example.katas.stock_command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockCommand {

    private final Map<String, Integer> newCommand;

    public StockCommand() {
        this.newCommand = new HashMap<>();
    }

    public void command(Map<String, Integer> currentStock, Map<String, Integer> availableArticles) {
        currentStock.forEach((key, value) -> {
            var articleToBuy = availableArticles.get(key);
            if (articleToBuy != null && availableArticles.get(key) > 0) {
                var bought = articleToBuy > value ? value : articleToBuy;
                newCommand.put(key, bought);
            }
        });
    }

    public Map<String, Integer> getNewCommand() {
        return newCommand;
    }
}
