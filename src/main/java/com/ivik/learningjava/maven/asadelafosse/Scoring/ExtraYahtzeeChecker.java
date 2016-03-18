package com.ivik.learningjava.maven.asadelafosse.Scoring;

/**
 * Created by Sebastien on 17-3-2016.
 */
public class ExtraYahtzeeChecker {

    boolean isMandatoryAces;
    boolean isMandatoryTwos;
    boolean isMandatoryThrees;
    boolean isMandatoryFours;
    boolean isMandatoryFives;
    boolean isMandatorySixes;
    boolean isMandatory;
    boolean isLowerSectionJoker;

    public ExtraYahtzeeChecker() {
        isMandatoryAces = false;
        isMandatoryTwos = false;
        isMandatoryThrees = false;
        isMandatoryFours = false;
        isMandatoryFives = false;
        isMandatorySixes = false;
        isMandatory = false;
        isLowerSectionJoker = false;
    }

    public static int determineYahtzeeKind(int[] roll) {
        for (int i = 0; i < 6; i++) {
            if (roll[i] == 5) {
                return i + 1;
            }
        }
        return 0;
    }
    public ExtraYahtzeeChecker processExtraYahtzee(int[] roll, ScoreSheet[][] scoreSheet, ExtraYahtzeeChecker check) {
        int yahtzeeKind = determineYahtzeeKind(roll);
        if (scoreSheet[1][5].qualifies(roll) && scoreSheet[1][5].filled && scoreSheet[1][5].fieldScore == 50) {
            scoreSheet[2][0].fieldScore += 100;
            check.isMandatory = true;
            if (yahtzeeKind == 1 && !scoreSheet[0][0].filled) {
                check.isMandatoryAces = true;
            } else if (yahtzeeKind == 2 && !scoreSheet[0][1].filled) {
                check.isMandatoryTwos = true;
            } else if (yahtzeeKind == 3 && !scoreSheet[0][2].filled) {
                check.isMandatoryThrees = true;
            } else if (yahtzeeKind == 4 && !scoreSheet[0][3].filled) {
                check.isMandatoryFours = true;
            } else if (yahtzeeKind == 5 && !scoreSheet[0][4].filled) {
                check.isMandatoryFives = true;
            } else if (yahtzeeKind == 6 && !scoreSheet[0][5].filled) {
                check.isMandatorySixes = true;
            } else {
                check.isMandatory = false;
                boolean isLowerSectionFilledSoFar = true;
                for (int i = 0; i < 7; i++) {
                    if (!scoreSheet[1][i].filled){
                        isLowerSectionFilledSoFar = false;
                    }
                }
                if (isLowerSectionFilledSoFar) {
                    check.isLowerSectionJoker = true;
                }
            }
        }
        return check;
    }

}
