package com.ivik.asadelafosse.Scoring;

import com.ivik.asadelafosse.RollEvaluator;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class SectionLowerChance extends SectionLower {

    public SectionLowerChance(){
        super();
        this.fieldDescription = "Chance";
    }

    public boolean qualifies(int[] rollResult, ExtraYahtzeeChecker check) {
        return !check.isMandatory;
    }

    public int determineScore(int[] rollResult){
        return RollEvaluator.countAllDice(rollResult);
    }
}
