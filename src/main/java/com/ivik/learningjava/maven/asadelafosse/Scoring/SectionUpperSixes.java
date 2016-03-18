package com.ivik.learningjava.maven.asadelafosse.Scoring;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class SectionUpperSixes extends SectionUpper {

    public SectionUpperSixes(){
        super();
        this.fieldDescription = "Sixes";
    }

    boolean qualifies(int[] rollResult, ExtraYahtzeeChecker check){
        return !((check.isMandatory && !check.isMandatorySixes) || check.isLowerSectionJoker);
    }

    public int determineScore(int[] rollResult){
        return rollResult[5] * 6;
    }

}
