package com.ivik.learningjava.maven.asadelafosse.Scoring;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class SectionLowerSmallStraight extends SectionLower {

    public SectionLowerSmallStraight(){
        super();
        this.fieldDescription = "Small Straight";
    }


    public boolean qualifies(int[] rollResult, ExtraYahtzeeChecker check) {
        if (check.isLowerSectionJoker){
            return true;
        } else if (check.isMandatory) {
            return false;
        } else {
            for (int i = 0; i < 3; i++) {
                if (rollResult[i] >= 1 && rollResult[i + 1] >= 1 && rollResult[i + 2] >= 1 && rollResult[i + 3] >= 1) {
                    return true;
                }
            }
            return false;
        }
    }

    public int determineScore(int[] rollResult){
        return 30;
    }
}
