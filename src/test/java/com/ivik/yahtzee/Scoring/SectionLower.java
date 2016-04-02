package com.ivik.yahtzee.Scoring;

/**
 * Created by Sebastien on 15-3-2016.
 */
public abstract class SectionLower extends ScoreSheet {

    SectionLower() {
        super();
        this.fieldDescription = "Lower";
    }

    public boolean isAllowed(int[]rollResult, ExtraYahtzeeChecker check) {
        if (check.isMandatory) {
            return false;
        } else return true;
    }

}
