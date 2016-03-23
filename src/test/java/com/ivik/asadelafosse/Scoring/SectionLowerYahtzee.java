package com.ivik.asadelafosse.Scoring;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class SectionLowerYahtzee extends SectionLower {

    public SectionLowerYahtzee(){
        super();
        this.fieldDescription = "Yahtzee";
    }


    public boolean qualifies(int[] rollResult, ExtraYahtzeeChecker check){
        for (int i : rollResult) {
            if (i == 5) {
                return true;
            }
        }
        return false;
    }

    public int determineScore(int[] rollResult){
        return 50;
    }
}
