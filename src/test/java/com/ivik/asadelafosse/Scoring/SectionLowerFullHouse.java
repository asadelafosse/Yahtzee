package com.ivik.asadelafosse.Scoring;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class SectionLowerFullHouse extends SectionLower {

    public SectionLowerFullHouse(){
        super();
        this.fieldDescription = "Full House";
    }


    public boolean qualifies(int[] rollResult, ExtraYahtzeeChecker check) {
        if (check.isLowerSectionJoker){
            return true;
        } else if (check.isMandatory) {
            return false;
        } else {
            for (int i : rollResult) {
                if (i == 3) {
                    for (int j : rollResult) {
                        if (j == 2) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    public int determineScore(int[] rollResult){
        return 25;
    }
}
