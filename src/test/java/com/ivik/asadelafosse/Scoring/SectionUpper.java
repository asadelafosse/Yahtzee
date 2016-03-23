package com.ivik.asadelafosse.Scoring;

/**
 * Created by Sebastien on 15-3-2016.
 */
public abstract class SectionUpper extends ScoreSheet {

    SectionUpper(){
        super();
        this.filled = false;
        this.countsForBonus = true;
        this.fieldDescription = "Upper";
    }

    boolean countsForBonus = true;



}
