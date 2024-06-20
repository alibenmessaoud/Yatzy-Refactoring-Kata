package org.codingdojo.yatzy1;

import java.util.Arrays;

public class Yatzy1 {
    protected int[] dice;

    public Yatzy1() {
        dice = new int[]{1, 1, 1, 1, 1};
    }

    public Yatzy1(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[]{d1, d2, d3, d4, d5};
        validateDice(dice);
    }

    public int chance() {
        return Arrays.stream(dice).sum();
    }

    public int yatzy() {
        return Arrays.stream(getCounts(dice))
            .anyMatch(count -> count == 5) ? 50 : 0;
    }

    public int ones() {
        return compareAndSumByValue(1, dice);
    }

    public int twos() {
        return compareAndSumByValue(2, dice);
    }

    public int threes() {
        return compareAndSumByValue(3, dice);
    }

    public int fours() {
        return compareAndSumByValue(4, dice);
    }

    public int fives() {
        return compareAndSumByValue(5, dice);
    }

    public int sixes() {
        return compareAndSumByValue(6, dice);
    }

    public int scorePair() {
        int[] counts = getCounts(dice);
        return scoreByNumber(counts, 2);
    }

    public int fourOfAKind() {
        int[] counts = getCounts(dice);
        return scoreByNumber(counts, 4);
    }

    public int threeOfAKind() {
        int[] counts = getCounts(dice);
        return scoreByNumber(counts, 3);
    }

    public int twoPair() {
        int[] counts = getCounts(dice);
        int pairCount = 0;
        int score = 0;
        for (int i = 5; i >= 0; i--) {
            if (counts[i] >= 2) {
                pairCount++;
                score += (i + 1);
            }
        }
        if (pairCount == 2) {
            return score * 2;
        } else {
            return 0;
        }
    }


    public int smallStraight() {
        int[] tallies = getCounts(dice);
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1) {
            return 15;
        }
        return 0;
    }

    public int largeStraight() {
        int[] tallies = getCounts(dice);
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1) {
            return 20;
        }
        return 0;
    }

    public int fullHouse() {
        int[] tallies = getCounts(dice);
        FoundValue foundValueOf2 = getByValue(tallies, 2);
        FoundValue foundValueOf3 = getByValue(tallies, 3);
        if (foundValueOf2.value() && foundValueOf3.value()) {
            return foundValueOf2.index() * 2 + foundValueOf3.index() * 3;
        } else {
            return 0;
        }
    }

    private static int compareAndSumByValue(int value, int[] dice) {
        return Arrays.stream(dice).filter(die -> die == value).map(die -> value).sum();
    }

    private static int scoreByNumber(int[] counts, int number) {
        for (int i = 5; i >= 0; i--) {
            if (counts[i] >= number) {
                return (i + 1) * number;
            }
        }
        return 0;
    }

    /**
     * Counts the occurrences of each value in the array.
     * @param dice int array of values
     * @return array
     */
    private static int[] getCounts(int[] dice) {
        int[] counts = new int[6];
        for (int die : dice) {
            counts[die - 1]++;
        }
        return counts;
    }

    private static FoundValue getByValue(int[] tallies, int value) {
        boolean foundValue = false;
        int indexOfFoundValue = 0;
        for (int i = 0; i < 6; i += 1) {
            if (tallies[i] == value) {
                foundValue = true;
                indexOfFoundValue = i + 1;
            }
        }
        return new FoundValue(foundValue, indexOfFoundValue);
    }

    private record FoundValue(boolean value, int index) {
    }

    /**
     * Validate the dice array.
     * Each die value should be between 1 and 6.
     * @param dice int array of values
     */
    private void validateDice(int[] dice) {
        if (Arrays.stream(dice).anyMatch(die -> die < 1 || die > 6)) {
            throw new IllegalArgumentException("All dice must have values between 1 and 6.");
        }
    }
}



