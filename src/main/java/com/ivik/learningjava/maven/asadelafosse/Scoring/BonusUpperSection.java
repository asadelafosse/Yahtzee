package com.ivik.learningjava.maven.asadelafosse.Scoring;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class BonusUpperSection extends ScoreSheet {

    BonusUpperSection(){
        super();
        filled = true;
        fieldDescription = "Upper Section Bonus";
    }
    boolean qualifies(int[] rollResult){
        return false;
    };

    int determineUpperBonus(ScoreSheet[][] scoreSheet){
        int totalUpperScore = 0;
        for (int i = 0; i < 6; i++) {
            totalUpperScore += scoreSheet[0][i].fieldScore;
            if (totalUpperScore >= 63) {
                scoreSheet[0][6].fieldScore = 35;
            }
        }
            return scoreSheet[0][6].fieldScore;
        }

    boolean checkUpperBonus(ScoreSheet[][] scoreSheet){
        boolean isUpperSectionFilledSoFar = true;
        for (int i = 0; i < 6; i++) {
            if (!scoreSheet[0][i].filled){
                isUpperSectionFilledSoFar = false;
            }
        }
        return isUpperSectionFilledSoFar;
    }

}
