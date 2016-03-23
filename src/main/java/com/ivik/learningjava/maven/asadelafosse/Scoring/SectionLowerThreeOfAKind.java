package com.ivik.learningjava.maven.asadelafosse.Scoring;

import com.ivik.learningjava.maven.asadelafosse.RollEvaluator;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class SectionLowerThreeOfAKind extends SectionLower {

    public SectionLowerThreeOfAKind(){
        super();
        this.fieldDescription = "Three of a Kind";
    }


    public boolean qualifies(int[] rollResult, ExtraYahtzeeChecker check) {
        if (check.isMandatory) {
            return false;
        } else {
            for (int i : rollResult) {
                if (i >= 3) {
                    return true;
                }
            }
            return false;
        }
    }

    public int determineScore(int[] rollResult){
        return RollEvaluator.countAllDice(rollResult);
    }
}
