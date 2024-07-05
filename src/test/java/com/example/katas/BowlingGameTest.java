package com.example.katas;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BowlingGameTest {

    @Test
    void shouldRun10RoundsAnd20Attempts() {
        List<Integer> baseScores = List.of(1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 5, 5, 4);
        var bowlingGame = new BowlingGame(baseScores);
        bowlingGame.playBowling();
        assertAll(() -> {
            assertThat(bowlingGame.getRounds()).isEqualTo(10);
            assertThat(bowlingGame.getAttempts()).isEqualTo(20);
        });
    }

    @Test
    void shouldHave3() {
        List<Integer> baseScores = List.of(1, 2);
        assertThat(play(baseScores)).isEqualTo(3);
    }

    @Test
    void shouldPlayAllRoundsAndHave() {
        List<Integer> baseScores = List.of(1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 5, 5);
        assertThat(play(baseScores)).isEqualTo(37);
    }

    @Test
    void shouldSum44WhenSpare() {
        List<Integer> baseScores = List.of(1, 9, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 5, 4);
        assertThat(play(baseScores)).isEqualTo(44);
    }


    @Test
    void shouldSum56WhenStrikeInSecondAttempt() {
        List<Integer> baseScores = List.of(0, 10, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 5, 4);
        assertThat(play(baseScores)).isEqualTo(46);
    }


    @Test
    void shouldSum56WhenStrikeInFirstAttempt() {
        List<Integer> baseScores = List.of(10, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 5, 4);
        assertThat(play(baseScores)).isEqualTo(46);
    }

    @Test
    void shouldSum56WhenStrikes() {
        List<Integer> baseScores = List.of(10, 1, 2, 1, 2, 10, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 5, 4);
        assertThat(play(baseScores)).isEqualTo(56);
    }

    @Test
    void shouldSum56WhenStrikesAndSpares() {
        List<Integer> baseScores = List.of(10, 1, 2, 1, 2, 10, 1, 2, 5, 5, 1, 2, 1, 2, 1, 2, 5, 4);
        assertThat(play(baseScores)).isEqualTo(64);
    }

    @Test
    void shouldSum56WhenStrikesAndSparesOneAfterOne() {
        List<Integer> baseScores = List.of(10, 5, 5, 1, 2, 5, 5, 10, 5, 5, 1, 2, 1, 2, 1, 2, 5, 4);
        assertThat(play(baseScores)).isEqualTo(102);
    }

    @Test
    void shouldPlayOneMoreAttemptWhenSpareAtLastRound() {
        List<Integer> baseScores = List.of(1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 5, 5,4);
        assertThat(play(baseScores)).isEqualTo(45);
    }

    @Test
    void shouldPlayTwoMoreAttemptsWhenStrikeAtLastRound() {
        List<Integer> baseScores = List.of(1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 10, 5,4);
        assertThat(play(baseScores)).isEqualTo(55);
    }

    private static int play(List<Integer> baseScores) {
        var bowlingGame = new BowlingGame(baseScores);
        return bowlingGame.playBowling();
    }
}