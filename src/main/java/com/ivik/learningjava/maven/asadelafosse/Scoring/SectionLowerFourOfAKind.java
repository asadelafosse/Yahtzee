package com.ivik.learningjava.maven.asadelafosse.Scoring;

import com.ivik.learningjava.maven.asadelafosse.RollEvaluator;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class SectionLowerFourOfAKind extends SectionLower {

    public SectionLowerFourOfAKind(){
        super();
        this.fieldDescription = "Four of a Kind";
    }


    boolean qualifies(int[] rollResult, ExtraYahtzeeChecker check){
        if (check.isMandatory) {
            return false;
        } else {
            for (int i : rollResult) {
                if (i >= 4) {
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
