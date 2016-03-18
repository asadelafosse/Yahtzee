package com.ivik.learningjava.maven.asadelafosse.Scoring;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class SectionUpperTwos extends SectionUpper {

    public SectionUpperTwos(){
        super();
        this.fieldDescription = "Twos";
    }

    boolean qualifies(int[] rollResult, ExtraYahtzeeChecker check){
        return !((check.isMandatory && !check.isMandatoryTwos) || check.isLowerSectionJoker);
    }

    public int determineScore(int[] rollResult){
        return rollResult[1] * 2;
    }

}
