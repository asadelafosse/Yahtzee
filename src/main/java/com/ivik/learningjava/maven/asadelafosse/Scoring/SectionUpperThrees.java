package com.ivik.learningjava.maven.asadelafosse.Scoring;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class SectionUpperThrees extends SectionUpper {

    public SectionUpperThrees(){
        super();
        this.fieldDescription = "Threes";
    }

    boolean qualifies(int[] rollResult, ExtraYahtzeeChecker check){
        return !((check.isMandatory && !check.isMandatoryThrees) || check.isLowerSectionJoker);
    }

    public int determineScore(int[] rollResult){
        return rollResult[2] * 3;
    }

}
