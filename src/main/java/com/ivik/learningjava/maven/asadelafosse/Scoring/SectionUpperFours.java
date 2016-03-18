package com.ivik.learningjava.maven.asadelafosse.Scoring;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class SectionUpperFours extends SectionUpper {

    public SectionUpperFours(){
        super();
        this.fieldDescription = "Fours";
    }

    boolean qualifies(int[] rollResult, ExtraYahtzeeChecker check){
        return !((check.isMandatory && !check.isMandatoryFours) || check.isLowerSectionJoker);
    }

    public int determineScore(int[] rollResult){
        return rollResult[3] * 4;
    }

}
