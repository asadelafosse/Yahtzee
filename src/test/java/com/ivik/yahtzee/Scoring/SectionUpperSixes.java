package com.ivik.yahtzee.Scoring;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class SectionUpperSixes extends SectionUpper {

    public SectionUpperSixes(){
        super();
        this.fieldDescription = "Sixes";
    }

    public boolean qualifies(int[] rollResult, ExtraYahtzeeChecker check){
        return !((check.isMandatory && !check.isMandatorySixes) || check.isLowerSectionJoker);
    }

    public boolean isAllowed(int[]rollResult, ExtraYahtzeeChecker check) {
        if (check.isMandatory) {
            return check.isMandatorySixes;
        } else return !check.isLowerSectionJoker;
    }

    public int determineScore(int[] rollResult){
        return rollResult[5] * 6;
    }

}
