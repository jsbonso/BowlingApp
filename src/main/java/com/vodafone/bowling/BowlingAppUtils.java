package com.vodafone.bowling;

import java.util.Arrays;

/**
 * Created by jsbonso on 18/1/17.
 */
public class BowlingAppUtils {

    private static String stringToArrayRegex = "\\s+";

    public static int[] stringToArray(String bowlingScores) {

        String[] scoresArray = bowlingScores.split(stringToArrayRegex);
        return Arrays.stream(scoresArray).mapToInt(Integer::parseInt).toArray();

    }
}
