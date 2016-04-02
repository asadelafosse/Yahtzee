package com.ivik.asadelafosse.VisualComponents;

import com.ivik.learningjava.maven.asadelafosse.VisualComponents.ScoreTableEntry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastien on 2-4-2016.
 */
public class HighScoreTableCrafter {

    public static TableView highScoreTable(ArrayList<ArrayList<String>> input) {
        TableView scoreDisplay = new TableView();
        ObservableList data = highScoreTableData(input);
        scoreDisplay.setItems(data);
        TableColumn name = new TableColumn("Name");
        name.setMinWidth(250);
        name.setCellValueFactory(new PropertyValueFactory<HighScoreTableEntry, String>("name"));

        TableColumn points = new TableColumn("Score");
        points.setMinWidth(100);
        points.setCellValueFactory(new PropertyValueFactory<HighScoreTableEntry, String>("score"));

        scoreDisplay.getColumns().setAll(name, points);
        scoreDisplay.setPrefHeight(139);
        scoreDisplay.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        return scoreDisplay;
    }

    public static ObservableList<ScoreTableEntry> highScoreTableData(ArrayList<ArrayList<String>> input) {
            List output = new ArrayList();
            for (int i = 0; i < 10; i++) {
                output.add(new HighScoreTableEntry(input.get(i)));
            }
            return FXCollections.observableArrayList(output);
        }
}
