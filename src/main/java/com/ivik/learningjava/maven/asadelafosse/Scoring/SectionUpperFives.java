package com.ivik.learningjava.maven.asadelafosse.Scoring;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class SectionUpperFives extends SectionUpper {

    public SectionUpperFives(){
        super();
        this.fieldDescription = "Fives";
    }

    boolean qualifies(int[] rollResult, ExtraYahtzeeChecker check){
        return !((check.isMandatory && !check.isMandatoryFives) || check.isLowerSectionJoker);
    }

    public int determineScore(int[] rollResult){
        return rollResult[4] * 5;
    }

}
