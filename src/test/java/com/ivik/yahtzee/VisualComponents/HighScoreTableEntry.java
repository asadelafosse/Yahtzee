package com.ivik.yahtzee.VisualComponents;

import java.util.ArrayList;

/**
 * Created by Sebastien on 2-4-2016.
 */
public class HighScoreTableEntry {
    public String name;
    public String score;

    public HighScoreTableEntry(ArrayList<String> playerEndScore) {
        this.name = playerEndScore.get(0);
        this.score = playerEndScore.get(1);
    }

    public HighScoreTableEntry(String title, int score) {
        this.name = title;
        this.score = Integer.toString(score);
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }
}
