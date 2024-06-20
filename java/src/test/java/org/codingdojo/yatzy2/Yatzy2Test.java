package org.codingdojo.yatzy2;

import org.codingdojo.YatzyCalculator;
import org.codingdojo.yatzy3.Yatzy3;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Yatzy2Test {

    static Stream<YatzyCalculator> yatzyProvider() {
        return Stream.of(new Yatzy2(), new Yatzy3());
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    public void chance_scores_sum_of_all_dice(YatzyCalculator calculator) {
        assertEquals(15, calculator.score(List.of(2, 3, 4, 5, 1), "CHANCE"));
        assertEquals(16, calculator.score(List.of(3, 3, 4, 5, 1), "CHANCE"));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    public void yatzy_scores_50(YatzyCalculator calculator) {
        assertEquals(50, calculator.score(List.of(4, 4, 4, 4, 4), "YATZY"));
        assertEquals(50, calculator.score(List.of(6, 6, 6, 6, 6), "YATZY"));
        assertEquals(0, calculator.score(List.of(6, 6, 6, 6, 3), "YATZY"));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    public void test_1s(YatzyCalculator yatzyCalculator) {
        assertEquals(1, yatzyCalculator.score(List.of(1, 2, 3, 4, 5), "ONES"));
        assertEquals(2, yatzyCalculator.score(List.of(1, 2, 1, 4, 5), "ONES"));
        assertEquals(0, yatzyCalculator.score(List.of(6, 2, 2, 4, 5), "ONES"));
        assertEquals(4, yatzyCalculator.score(List.of(1, 2, 1, 1, 1), "ONES"));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")

    public void twos(YatzyCalculator yatzyCalculator) {
        assertEquals(4, yatzyCalculator.score(List.of(1, 2, 3, 2, 6), "TWOS"));
        assertEquals(10, yatzyCalculator.score(List.of(2, 2, 2, 2, 2), "TWOS"));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")

    public void threes(YatzyCalculator yatzyCalculator) {
        assertEquals(6, yatzyCalculator.score(List.of(1, 2, 3, 2, 3), "THREES"));
        assertEquals(12, yatzyCalculator.score(List.of(2, 3, 3, 3, 3), "THREES"));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")

    public void fours(YatzyCalculator yatzyCalculator) {
        assertEquals(12, yatzyCalculator.score(List.of(4, 4, 4, 5, 5), "FOURS"));
        assertEquals(8, yatzyCalculator.score(List.of(4, 4, 5, 5, 5), "FOURS"));
        assertEquals(4, yatzyCalculator.score(List.of(4, 5, 5, 5, 5), "FOURS"));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    public void fives(YatzyCalculator yatzyCalculator) {
        assertEquals(10, yatzyCalculator.score(List.of(4, 4, 4, 5, 5), "FIVES"));
        assertEquals(15, yatzyCalculator.score(List.of(4, 4, 5, 5, 5), "FIVES"));
        assertEquals(20, yatzyCalculator.score(List.of(4, 5, 5, 5, 5), "FIVES"));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    public void sixes(YatzyCalculator yatzyCalculator) {
        assertEquals(0, yatzyCalculator.score(List.of(4, 4, 4, 5, 5), "SIXES"));
        assertEquals(6, yatzyCalculator.score(List.of(4, 4, 6, 5, 5), "SIXES"));
        assertEquals(18, yatzyCalculator.score(List.of(6, 5, 6, 6, 5), "SIXES"));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    public void pair(YatzyCalculator yatzyCalculator) {
        assertEquals(6, yatzyCalculator.score(List.of(3, 4, 3, 5, 6), "PAIR"));
        assertEquals(10, yatzyCalculator.score(List.of(5, 3, 3, 3, 5), "PAIR"));
        assertEquals(12, yatzyCalculator.score(List.of(5, 3, 6, 6, 5), "PAIR"));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    public void two_pair(YatzyCalculator yatzyCalculator) {
        assertEquals(16, yatzyCalculator.score(List.of(3, 3, 5, 4, 5), "TWO_PAIRS"));
        assertEquals(16, yatzyCalculator.score(List.of(3, 3, 5, 5, 5), "TWO_PAIRS"));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    public void three_of_a_kind(YatzyCalculator yatzyCalculator) {
        assertEquals(9, yatzyCalculator.score(List.of(3, 3, 3, 4, 5), "THREE_OF_A_KIND"));
        assertEquals(15, yatzyCalculator.score(List.of(5, 3, 5, 4, 5), "THREE_OF_A_KIND"));
        assertEquals(9, yatzyCalculator.score(List.of(3, 3, 3, 3, 5), "THREE_OF_A_KIND"));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    public void four_of_a_knd(YatzyCalculator yatzyCalculator) {
        assertEquals(12, yatzyCalculator.score(List.of(3, 3, 3, 3, 5), "FOUR_OF_A_KIND"));
        assertEquals(20, yatzyCalculator.score(List.of(5, 5, 5, 4, 5), "FOUR_OF_A_KIND"));
        assertEquals(12, yatzyCalculator.score(List.of(3, 3, 3, 3, 3), "FOUR_OF_A_KIND"));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    public void smallStraight(YatzyCalculator yatzyCalculator) {
        assertEquals(15, yatzyCalculator.score(List.of(1, 2, 3, 4, 5), "SMALL_STRAIGHT"));
        assertEquals(15, yatzyCalculator.score(List.of(2, 3, 4, 5, 1), "SMALL_STRAIGHT"));
        assertEquals(0, yatzyCalculator.score(List.of(1, 2, 2, 4, 5), "SMALL_STRAIGHT"));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    public void largeStraight(YatzyCalculator yatzyCalculator) {
        assertEquals(20, yatzyCalculator.score(List.of(6, 2, 3, 4, 5), "LARGE_STRAIGHT"));
        assertEquals(20, yatzyCalculator.score(List.of(2, 3, 4, 5, 6), "LARGE_STRAIGHT"));
        assertEquals(0, yatzyCalculator.score(List.of(1, 2, 2, 4, 5), "LARGE_STRAIGHT"));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    public void fullHouse(YatzyCalculator yatzyCalculator) {
        assertEquals(18, yatzyCalculator.score(List.of(6, 2, 2, 2, 6), "FULL_HOUSE"));
        assertEquals(0, yatzyCalculator.score(List.of(2, 3, 4, 5, 6), "FULL_HOUSE"));
    }

}
