package com.ivik.asadelafosse.Scoring;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class SectionUpperFives extends SectionUpper {

    public SectionUpperFives(){
        super();
        this.fieldDescription = "Fives";
    }

    public boolean qualifies(int[] rollResult, ExtraYahtzeeChecker check){
        return !((check.isMandatory && !check.isMandatoryFives) || check.isLowerSectionJoker);
    }

    public boolean isAllowed(int[]rollResult, ExtraYahtzeeChecker check) {
        if (check.isMandatory) {
            return check.isMandatoryFives;
        } else return !check.isLowerSectionJoker;
    }

    public int determineScore(int[] rollResult){
        return rollResult[4] * 5;
    }

}
