package com.example.katas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BowlingGame {
    private static final Random r = new Random();
    private static final int MAX_TOUR = 10;
    public static final int MAX_ROUNDS = 2;
    private static final int TEN = 10;
    private int rounds;
    private int attempts;

    private final List<Integer> baseScores;

    public BowlingGame(List<Integer> baseScores) {
        this.baseScores = new ArrayList<>(baseScores);
    }

    public int playBowling() {
        var score = 0;
        var isSpare = false;
        boolean doubleStrike = false;
        boolean isStrike = false;
        boolean isAMoreAttempt = false;
        while (rounds < MAX_TOUR && !baseScores.isEmpty()) {
            var currentScore = 0;
            for (int i = 0; i < MAX_ROUNDS; i++) {
                if (isStrike) {
                    doubleStrike = true;
                    isStrike = false;
                }
                var attemptScore = getScore();
                ++attempts;
                if (attemptScore == TEN) {
                    isStrike = true;
                    currentScore += attemptScore;
                    break;
                }
                currentScore += attemptScore;
                if (isSpare) {
                    currentScore *= 2;
                    isSpare = false;
                }
                if(isAMoreAttempt){
                    break;
                }
            }
            if (currentScore == TEN && !isStrike) {
                isSpare = true;
            }
            if (doubleStrike) {
                currentScore *= 2;
                doubleStrike = false;
            }
            score += currentScore;
            ++rounds;
            if (isSpare && rounds == MAX_TOUR) {
                isAMoreAttempt = true;
                --rounds;
            }
            if(isStrike && rounds == MAX_TOUR){
                --rounds;
            }
        }
        return score;
    }

    private int getScore() {
        return baseScores.remove(0);
    }

    public int getRounds() {
        return rounds;
    }

    public int getAttempts() {
        return attempts;
    }
}
