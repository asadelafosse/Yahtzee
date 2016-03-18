package com.ivik.learningjava.maven.asadelafosse.VisualComponents;

import com.ivik.learningjava.maven.asadelafosse.Scoring.ScoreSheet;
import com.ivik.learningjava.maven.asadelafosse.Scoring.TotalScore;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastien on 17-3-2016.
 */
public class ScoreTableComponent {

    /*public ObservableList<ScoreTableComponent> upperSectionData = FXCollections.observableArrayList(
            new ScoreTableComponent(scoreSheet[0])

    );
*/

    public static ScoreTableEntry createSheetLine(ScoreSheet scoreSheet){
        ScoreTableEntry sheetLine = new ScoreTableEntry(scoreSheet);
        return sheetLine;
    }

    public static ObservableList<ScoreTableEntry> createUpperData(ScoreSheet[][] scoreSheet) {
        List output = new ArrayList();
        for (int i = 0; i < 7; i++) {
            output.add(createSheetLine(scoreSheet[0][i]));
        }
        return FXCollections.observableArrayList(output);
    }

    public static ObservableList<ScoreTableEntry> createLowerData(ScoreSheet[][] scoreSheet) {
        List output = new ArrayList();
        for (int i = 0; i < 7; i++) {
            output.add(createSheetLine(scoreSheet[1][i]));
        }
        return FXCollections.observableArrayList(output);
    }

    public static ObservableList<ScoreTableEntry> createTotalData(ScoreSheet[][] scoreSheet) {
        List output = new ArrayList();
        int[] totals = TotalScore.updateScores(scoreSheet);
        output.add(new ScoreTableEntry("Upper Section Total", totals[0]));
        output.add(new ScoreTableEntry("Lower Section Total", totals[1]));
        output.add(new ScoreTableEntry("Grand Total", totals[2]));
        return FXCollections.observableArrayList(output);
    }
}
