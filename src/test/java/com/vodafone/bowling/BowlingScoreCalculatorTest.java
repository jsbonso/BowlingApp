package com.vodafone.bowling;

import com.vodafone.bowling.exception.BowlingScoreCalculatorException;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Created by jsbonso on 18/1/17.
 */
public class BowlingScoreCalculatorTest {

    @Test
    public void testTotalBowlingScoreCalculation() throws Exception {
        String input1 = "4 1 2 3";
        String input2 = "9 1 9 1";
        String input3 = "10 10 10 10 10 10 " +
                "10 10 10 10 10 10";

        BowlingScoreCalculator bowling = new BowlingScoreCalculator();

        Assert.assertEquals(10, bowling.calculateTotalScore(input1));
        Assert.assertEquals(29, bowling.calculateTotalScore(input2));
        Assert.assertEquals(300, bowling.calculateTotalScore(input3));
    }


    @Test(expected=BowlingScoreCalculatorException.class)
    public void testBowlingScoreForInvalidScore() throws Exception {
        String input1 = "11 1 2 3";

        BowlingScoreCalculator bowling = new BowlingScoreCalculator();
        bowling.calculateTotalScore(input1);
    }

}