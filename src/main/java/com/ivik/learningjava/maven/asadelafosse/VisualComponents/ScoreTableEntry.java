package com.ivik.learningjava.maven.asadelafosse.VisualComponents;

import com.ivik.learningjava.maven.asadelafosse.Scoring.ScoreSheet;

/**
 * Created by Sebastien on 17-3-2016.
 */
public class ScoreTableEntry {
    public String title;
    public String score;

    public ScoreTableEntry(ScoreSheet scoreSheet){
        this.title = scoreSheet.fieldDescription;
        this.score = scoreSheet.determineScoreString(scoreSheet);
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

}
