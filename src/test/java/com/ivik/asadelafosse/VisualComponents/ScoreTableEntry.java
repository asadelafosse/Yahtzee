package com.ivik.asadelafosse.VisualComponents;

import com.ivik.asadelafosse.Scoring.ScoreSheet;

/**
 * Created by Sebastien on 17-3-2016.
 */
public class ScoreTableEntry {
    public String title;
    public String score;

    public ScoreTableEntry(ScoreSheet scoreSheet){
        this.title = scoreSheet.fieldDescription;
        this.score = scoreSheet.fieldScoreString;
    }

    public ScoreTableEntry(String title, int score){
        this.title = title;
        this.score = Integer.toString(score);
    }

    public String getTitle() {
        return title;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
