package com.ivik.learningjava.maven.asadelafosse.Scoring;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class SectionUpperAces extends SectionUpper {

    public SectionUpperAces(){
        super();
        this.fieldDescription = "Aces";
    }

    public boolean qualifies(int[] rollResult, ExtraYahtzeeChecker check){
        return !((check.isMandatory && !check.isMandatoryAces) || check.isLowerSectionJoker);
    }

    public int determineScore(int[] rollResult){
        return rollResult[0] * 1;
    }

}
