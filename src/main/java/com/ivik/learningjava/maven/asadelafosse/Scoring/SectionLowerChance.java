package com.ivik.learningjava.maven.asadelafosse.Scoring;

import com.ivik.learningjava.maven.asadelafosse.RollEvaluator;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class SectionLowerChance extends SectionLower {

    public SectionLowerChance(){
        super();
        this.fieldDescription = "Chance";
    }

    boolean qualifies(int[] rollResult, ExtraYahtzeeChecker check) {
        return !check.isMandatory;
    }

    public int determineScore(int[] rollResult){
        return RollEvaluator.countAllDice(rollResult);
    }
}
