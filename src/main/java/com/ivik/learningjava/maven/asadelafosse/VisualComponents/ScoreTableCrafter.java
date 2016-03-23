package com.ivik.learningjava.maven.asadelafosse.VisualComponents;

import com.ivik.learningjava.maven.asadelafosse.Scoring.ScoreSheet;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Created by Sebastien on 17-3-2016.
 */
public class ScoreTableCrafter {

    public static TableView upperScores(ScoreSheet[][] scoreSheet) {
        TableView scoreDisplay = new TableView();
        ObservableList upperData = ScoreTableComponent.createUpperData(scoreSheet);
        scoreDisplay.setItems(upperData);
        TableColumn name = new TableColumn("Upper Section");
        name.setMinWidth(250);
        name.setCellValueFactory(new PropertyValueFactory<ScoreTableEntry, String>("title"));

        TableColumn points = new TableColumn("Points");
        points.setMinWidth(100);
        points.setCellValueFactory(new PropertyValueFactory("score"));

        scoreDisplay.getColumns().setAll(name, points);
        scoreDisplay.setPrefHeight(223);
        scoreDisplay.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        return scoreDisplay;
    }
    public static TableView lowerScores(ScoreSheet[][] scoreSheet) {
        TableView scoreDisplay = new TableView();
        ObservableList lowerData = ScoreTableComponent.createLowerData(scoreSheet);
        scoreDisplay.setItems(lowerData);
        TableColumn name = new TableColumn("Lower Section");
        name.setMinWidth(250);
        name.setCellValueFactory(new PropertyValueFactory<ScoreTableEntry, String>("title"));

        TableColumn points = new TableColumn("Points");
        points.setMinWidth(100);
        points.setCellValueFactory(new PropertyValueFactory("score"));

        scoreDisplay.getColumns().setAll(name, points);
        scoreDisplay.setPrefHeight(223);
        scoreDisplay.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        return scoreDisplay;
    }

    public static TableView totalScores(ScoreSheet[][] scoreSheet) {
        TableView scoreDisplay = new TableView();
        ObservableList totalData = ScoreTableComponent.createTotalData(scoreSheet);
        scoreDisplay.setItems(totalData);
        TableColumn name = new TableColumn("Totals");
        name.setMinWidth(250);
        name.setCellValueFactory(new PropertyValueFactory<ScoreTableEntry, String>("title"));

        TableColumn points = new TableColumn("Points");
        points.setMinWidth(100);
        points.setCellValueFactory(new PropertyValueFactory("score"));

        scoreDisplay.getColumns().setAll(name, points);
        scoreDisplay.setPrefHeight(139);
        scoreDisplay.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        return scoreDisplay;
    }
}
