package org.codingdojo;

import org.codingdojo.yatzy1.Yatzy1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;


public class Yatzy1Test {

    @Test
    void should_throw_exception_when_invalid_dice_values() {
        assertThrowsExactly(IllegalArgumentException.class, () -> new Yatzy1(10, 1, 1, 1, 1));
    }

    @Test
    void should_score_5_when_use_default_constructor() {
        assertEquals(5, new Yatzy1().chance());
        assertEquals(5, new Yatzy1().ones());
        assertEquals(0, new Yatzy1().threes());
    }

    @Test
    public void should_score_sum_of_all_dice_when_call_chance() {
        assertEquals(15, new Yatzy1(2, 3, 4, 5, 1).chance());
        assertEquals(16, new Yatzy1(3, 3, 4, 5, 1).chance());
    }

    @Test
    public void should_score_50_or_0_when_call_yatzy() {
        assertEquals(50, new Yatzy1(4, 4, 4, 4, 4).yatzy());
        assertEquals(50, new Yatzy1(6, 6, 6, 6, 6).yatzy());
        assertEquals(0, new Yatzy1(6, 6, 6, 6, 3).yatzy());
    }

    @Test
    public void should_score_sum_of_one_values_when_call_ones() {
        assertEquals(0, new Yatzy1(6, 2, 2, 4, 5).ones());
        assertEquals(1, new Yatzy1(1, 2, 3, 4, 5).ones());
        assertEquals(2, new Yatzy1(1, 2, 1, 4, 5).ones());
        assertEquals(4, new Yatzy1(1, 2, 1, 1, 1).ones());
    }

    @Test
    public void should_score_sum_of_two_values_when_call_tows() {
        assertEquals(0, new Yatzy1(1, 1, 3, 4, 6).twos());
        assertEquals(4, new Yatzy1(1, 2, 3, 2, 6).twos());
        assertEquals(10, new Yatzy1(2, 2, 2, 2, 2).twos());
    }

    @Test
    public void should_score_sum_of_three_values_when_call_threes() {
        assertEquals(0, new Yatzy1(1, 2, 1, 2, 4).threes());
        assertEquals(6, new Yatzy1(1, 2, 3, 2, 3).threes());
        assertEquals(12, new Yatzy1(2, 3, 3, 3, 3).threes());
    }

    @Test
    public void should_score_sum_of_four_values_when_call_fours() {
        assertEquals(0, new Yatzy1(2, 5, 5, 5, 5).fours());
        assertEquals(4, new Yatzy1(4, 5, 5, 5, 5).fours());
        assertEquals(8, new Yatzy1(4, 4, 5, 5, 5).fours());
        assertEquals(12, new Yatzy1(4, 4, 4, 5, 5).fours());
    }

    @Test
    public void should_score_sum_of_five_values_when_call_fives() {
        assertEquals(0, new Yatzy1(4, 4, 4, 2, 3).fives());
        assertEquals(10, new Yatzy1(4, 4, 4, 5, 5).fives());
        assertEquals(15, new Yatzy1(4, 4, 5, 5, 5).fives());
        assertEquals(20, new Yatzy1(4, 5, 5, 5, 5).fives());
    }

    @Test
    public void should_score_sum_of_six_values_when_call_sixes() {
        assertEquals(0, new Yatzy1(4, 4, 4, 5, 5).sixes());
        assertEquals(6, new Yatzy1(4, 4, 6, 5, 5).sixes());
        assertEquals(18, new Yatzy1(6, 5, 6, 6, 5).sixes());
    }

    @Test
    public void should_score_sum_of_one_pair_when_call_pair() {
        assertEquals(6, new Yatzy1(3, 4, 3, 5, 6).scorePair());
        assertEquals(10, new Yatzy1(5, 3, 3, 3, 5).scorePair());
        assertEquals(12, new Yatzy1(5, 3, 6, 6, 5).scorePair());
    }

    @Test
    public void should_score_sum_of_two_pair_when_call_two_pair() {
        assertEquals(16, new Yatzy1(3, 3, 5, 4, 5).twoPair());
        assertEquals(16, new Yatzy1(3, 3, 5, 5, 5).twoPair());
    }

    @Test
    public void should_score_sum_of_three_of_numbers_when_call_three_of_kind() {
        assertEquals(9, new Yatzy1(3, 3, 3, 4, 5).threeOfAKind());
        assertEquals(9, new Yatzy1(3, 3, 3, 3, 5).threeOfAKind());
        assertEquals(15, new Yatzy1(5, 3, 5, 4, 5).threeOfAKind());
    }

    @Test
    public void should_score_sum_of_four_of_numbers_when_call_four_of_kind() {
        assertEquals(12, new Yatzy1(3, 3, 3, 3, 5).fourOfAKind());
        assertEquals(20, new Yatzy1(5, 5, 5, 4, 5).fourOfAKind());
        assertEquals(9, new Yatzy1(3, 3, 3, 3, 3).threeOfAKind());
    }

    @Test
    public void should_score_15_when_call_small_straight_with_values_from_1_to_5() {
        assertEquals(15, new Yatzy1(1, 2, 3, 4, 5).smallStraight());
        assertEquals(15, new Yatzy1(2, 3, 4, 5, 1).smallStraight());
        assertEquals(0, new Yatzy1(1, 2, 2, 4, 5).smallStraight());
    }

    @Test
    public void should_score_20_when_call_large_straight_with_values_from_2_to_6() {
        assertEquals(20, new Yatzy1(6, 2, 3, 4, 5).largeStraight());
        assertEquals(20, new Yatzy1(2, 3, 4, 5, 6).largeStraight());
        assertEquals(0, new Yatzy1(1, 2, 2, 4, 5).largeStraight());
    }

    @Test
    public void should_score_when_call_full_house() {
        assertEquals(18, new Yatzy1(6, 2, 2, 2, 6).fullHouse());
        assertEquals(0, new Yatzy1(2, 3, 4, 5, 6).fullHouse());
    }
}
