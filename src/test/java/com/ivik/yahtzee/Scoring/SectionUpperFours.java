package com.ivik.yahtzee.Scoring;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class SectionUpperFours extends SectionUpper {

    public SectionUpperFours(){
        super();
        this.fieldDescription = "Fours";
    }

    public boolean qualifies(int[] rollResult, ExtraYahtzeeChecker check){
        return !((check.isMandatory && !check.isMandatoryFours) || check.isLowerSectionJoker);
    }

    public boolean isAllowed(int[]rollResult, ExtraYahtzeeChecker check) {
        if (check.isMandatory) {
            return check.isMandatoryFours;
        } else return !check.isLowerSectionJoker;
    }

    public int determineScore(int[] rollResult){
        return rollResult[3] * 4;
    }

}
