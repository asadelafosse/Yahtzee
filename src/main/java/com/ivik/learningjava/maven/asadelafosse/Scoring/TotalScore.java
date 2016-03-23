package com.ivik.learningjava.maven.asadelafosse.Scoring;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class TotalScore {

    public static int[] updateScores(ScoreSheet[][] scoreSheet) {

        int totalUpperScore = 0;
        for (int i = 0; i < 6; i++) {
            totalUpperScore += scoreSheet[0][i].fieldScore;
        }
        BonusUpperSection bonus = (BonusUpperSection) scoreSheet[0][6];
        totalUpperScore += bonus.determineUpperBonus(scoreSheet);

        int totalLowerScore = 0;
        for (int i = 0; i < 7; i++) {
            totalLowerScore += scoreSheet[1][i].fieldScore;
        }
        return new int[]{totalUpperScore, totalLowerScore, scoreSheet[2][0].fieldScore, totalUpperScore + totalLowerScore + scoreSheet[2][0].fieldScore};

    }
}
