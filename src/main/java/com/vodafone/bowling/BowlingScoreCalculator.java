package com.vodafone.bowling;

import com.vodafone.bowling.exception.BowlingScoreCalculatorException;

import static com.vodafone.bowling.BowlingAppUtils.stringToArray;
/**
 * Created by jsbonso on 18/1/17.
 */
public class BowlingScoreCalculator {

    private final static int perfectScore = 10;
    private final static String illegalScoreErrMsg = "Illegal score. Should be 0-10 points only";

    public int calculateTotalScore(String bowlingScores) throws BowlingScoreCalculatorException{
        int[] scoresArray = BowlingAppUtils.stringToArray(bowlingScores);
        int index = 0;
        int sum = 0;

        while (index < scoresArray.length) {
            int hits = scoresArray[index];
            if (hits < perfectScore) {

                int thisRound = hits + scoresArray[index + 1];

                if (thisRound > perfectScore)
                    throw new BowlingScoreCalculatorException(illegalScoreErrMsg);

                sum += thisRound;
                if (thisRound == perfectScore && (index + 2) < scoresArray.length) {
                    int oneThrowAtNextRound = scoresArray[index + 2];
                    sum += oneThrowAtNextRound;
                }
                index += 2;

            } else if (hits == perfectScore) {
                sum += scoresArray[index];

                if (index + 1 < scoresArray.length)
                    sum += scoresArray[index + 1];

                if (index + 2 < scoresArray.length)
                    sum += scoresArray[index + 2];

                index += 1;

            }else{
                throw new BowlingScoreCalculatorException(illegalScoreErrMsg);
            }

            if (index >= perfectScore)
                break;

        }
        return sum;
    }
}