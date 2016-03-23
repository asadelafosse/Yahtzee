package com.ivik.asadelafosse.Scoring;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class ScoreSheet {

    public ScoreSheet(){
        this.filled = false;
        this.countsForBonus = false;
        this.fieldDescription = "Test";
        this.fieldScore = 0;
        if (filled) {
            this.fieldScoreString = Integer.toString(fieldScore);
        } else {
            this.fieldScoreString = "";
        }
    }

    public boolean filled;
    public boolean countsForBonus;
    public String fieldDescription;
    public int fieldScore = 0;
    public String fieldScoreString = Integer.toString(fieldScore);

    public boolean qualifies(int[] rollResult, ExtraYahtzeeChecker check) {
        return false;
    }
    public boolean isAllowed(int[] rollResult, ExtraYahtzeeChecker check) {
        return true;
    }

    public void recordScore(int scorePoints){
        this.filled = true;
        this.fieldScore = scorePoints;
        this.fieldScoreString = Integer.toString(fieldScore);
    }

    public int scorePoints(int[] rollResult, boolean qualifies) {
        if (qualifies){
            return determineScore(rollResult);
        } else {
            return 0;
        }
    }

    public String determineScoreString(ScoreSheet scoreSheet) {
        if (scoreSheet.filled) {
            return Integer.toString(scoreSheet.fieldScore);
        } else {
            return "";
        }
    }

    public int determineScore(int[] rollResult){
        return 0;
    }
}
