package com.ivik.yahtzee.Scoring;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class BonusUpperSection extends ScoreSheet {

    BonusUpperSection(){
        super();
        filled = true;
        fieldDescription = "Upper Section Bonus";
    }
    public boolean qualifies(int[] rollResult){
        return false;
    };

    public static int determineUpperBonus(ScoreSheet[][] scoreSheet){
        int totalUpperScore = 0;
        for (int i = 0; i < 6; i++) {
            totalUpperScore += scoreSheet[0][i].fieldScore;
            if (totalUpperScore >= 63) {
                return 35;
            }
        }
            return 0;
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
