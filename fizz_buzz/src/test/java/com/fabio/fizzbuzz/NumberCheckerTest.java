package com.fabio.fizzbuzz;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class NumberCheckerTest {

    NumberChecker checker;

    @Before
    public void setUp() {
        checker = new NumberChecker();
    }

    @Test
    public void returnsFizzForMultiplesOfThree() {
        int[] multiplesOfThree = new int[100];
        for (int i = 0; i < 100; i++) {
            multiplesOfThree[i] = (i + 1) * 3;
        }

        ArrayList<String> results = new ArrayList<String>();

        for (int i = 0; i < 100; i++) {
            results.add(checker.check(multiplesOfThree[i]));
        }

        assertThat(results, everyItem(startsWith("Fizz")));
    }

    @Test
    public void returnsBuzzForMultiplesOfFive() {
        int[] multipleOfFive = new int[100];
        for (int i = 0; i < 100; i++) {
            multipleOfFive[i] = (i + 1) * 5;
        }

        ArrayList<String> results = new ArrayList<String>();

        for (int i = 0; i < 100; i++) {
            results.add(checker.check(multipleOfFive[i]));
        }

        assertThat(results, everyItem(endsWith("Buzz")));
    }

    @Test
    public void returnsFizzBuzzForMultipleForThreeAndFive() {
        int[] multiplesOfThreeAndFive = new int[100];
        for (int i = 0; i < 100; i++) {
            multiplesOfThreeAndFive[i] = ((i + 1) * 3) * 5;
        }

        ArrayList<String> results = new ArrayList<String>();

        for (int i = 0; i < 100; i++) {
            results.add(checker.check(multiplesOfThreeAndFive[i]));
        }
        assertThat(results, everyItem(equalTo("Fizz Buzz")));
    }

    @Test
    public void returnsSameNumberForNonMultiplesOfThreeOrFive() {
        List<Integer> nonMultiplesOfThreeAndFive = new ArrayList<Integer>();
        for (int i = 1; i <= 100; i++) {
            if ((i % 3 != 0) && (i % 5 != 0)) {
                nonMultiplesOfThreeAndFive.add(i);
            }
        }

        List<String> results = new ArrayList<String>();

        for (int i = 0; i < nonMultiplesOfThreeAndFive.size(); i++) {
            results.add(checker.check(nonMultiplesOfThreeAndFive.get(i)));
        }

        List<String> notMultipleOfBothStr = new ArrayList<String>();
        for (int result : nonMultiplesOfThreeAndFive) {
            notMultipleOfBothStr.add(String.valueOf(result));
        }

        assertThat(results, equalTo(notMultipleOfBothStr));

    }
}
