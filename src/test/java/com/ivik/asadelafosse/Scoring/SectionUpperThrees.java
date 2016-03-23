package com.ivik.asadelafosse.Scoring;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class SectionUpperThrees extends SectionUpper {

    public SectionUpperThrees(){
        super();
        this.fieldDescription = "Threes";
    }

    public boolean qualifies(int[] rollResult, ExtraYahtzeeChecker check){
        return !((check.isMandatory && !check.isMandatoryThrees) || check.isLowerSectionJoker);
    }

    public boolean isAllowed(int[]rollResult, ExtraYahtzeeChecker check) {
        if (check.isMandatory) {
            return check.isMandatoryThrees;
        } else return !check.isLowerSectionJoker;
    }

    public int determineScore(int[] rollResult){
        return rollResult[2] * 3;
    }

}
