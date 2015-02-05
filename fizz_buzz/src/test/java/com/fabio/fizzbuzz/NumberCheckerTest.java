package com.fabio.fizzbuzz;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class NumberCheckerTest {

    NumberChecker checker;

    @Before
    public void setUp() {
        checker = new NumberChecker();
    }

    @Test
    public void returnsFizzForThree() {
        String result = checker.check(3);
        Assert.assertEquals("Fizz", result);
    }

    @Test
    public void returnsFizzForMultiplesOfThree() {
        int[] multiplesOfThree = new int[100];
        for (int i = 0; i < 100; i++) {
            multiplesOfThree[i] = (i+1) * 3;
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
       for (int i = 0; i < 100; i++){
           multipleOfFive[i] = (i+1) * 5;
       }

        ArrayList<String> results = new ArrayList<String>();

        for (int i = 0; i < 100; i++){
            results.add(checker.check(multipleOfFive[i]));
        }
        assertThat(results, everyItem(endsWith("Buzz")));
    }

    @Test
    public void returnsFizzBuzzForBoth() {
        int[] multipleOfBoth = new int[100];
        for (int i =0; i < 100; i++){
            multipleOfBoth[i] = ((i+1)*3)*5;
        }

        ArrayList <String> results = new ArrayList<String>();

        for (int i = 0; i < 100; i++){
            results.add(checker.check(multipleOfBoth[i]));
        }
        assertThat(results, everyItem(equalTo("Fizz Buzz")));
    }



    @Test
    public void returnsBuzzForTen() {
        String result = checker.check(10);
        Assert.assertEquals("Buzz", result);
    }

    @Test
    public void returnsFizzBuzzForFifiteen() {
        String result = checker.check(15);
        Assert.assertEquals("Fizz Buzz", result);
    }

    @Test
    public void returnsTheSameForOne() {
        String result = checker.check(1);
        Assert.assertEquals("1", result);
    }

}
