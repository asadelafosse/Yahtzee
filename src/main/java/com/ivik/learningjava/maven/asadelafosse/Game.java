package com.ivik.learningjava.maven.asadelafosse;

import com.ivik.learningjava.maven.asadelafosse.Scoring.ScoreSheet;
import com.ivik.learningjava.maven.asadelafosse.VisualComponents.DiceVisuals;
import com.ivik.learningjava.maven.asadelafosse.Scoring.ScoreExecutor;
import com.ivik.learningjava.maven.asadelafosse.VisualComponents.Checkboxes;
import com.ivik.learningjava.maven.asadelafosse.VisualComponents.ScoreTableCrafter;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class Game extends Application{

    static final int NUMBEROFTURNS = 13;

    public void start(Stage primaryStage) throws Exception {

        final Pane root = new Pane();
        Scene scene = new Scene(root, 800, 1000);
        scene.setFill(Color.GREEN);
        primaryStage.setTitle("Yahtzee Solitaire");

        final ScoreSheet[][] scoreSheet = ScoreExecutor.createScoreSheet();

        TableView upperScores = ScoreTableCrafter.upperScores(scoreSheet);
        TableView lowerScores = ScoreTableCrafter.lowerScores(scoreSheet);
        TableView totalScores = ScoreTableCrafter.totalScores (scoreSheet);

        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(25, 25, 25, 25));;
        vbox.getChildren().addAll(upperScores, lowerScores, totalScores);

        final Rectangle[] drawnDice = DiceVisuals.drawDice();

        Group dice = new Group();
        Rectangle die1 = drawnDice[0];
        Rectangle die2 = drawnDice[1];
        Rectangle die3 = drawnDice[2];
        Rectangle die4 = drawnDice[3];
        Rectangle die5 = drawnDice[4];
        dice.getChildren().addAll(die1, die2, die3, die4, die5);

        final Group checkboxes = new Group();
        final CheckBox[] drawnCheckboxes = Checkboxes.drawCheckbox(drawnDice);
        CheckBox box1 = drawnCheckboxes[0];
        final Tooltip tooltip1 = new Tooltip("Save this result.");
        box1.setTooltip(tooltip1);
        box1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov,
                                Boolean old_val, Boolean new_val) {
            }
        });
        CheckBox box2 = drawnCheckboxes[1];
        final Tooltip tooltip2 = new Tooltip("Save this result.");
        box2.setTooltip(tooltip2);
        box2.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov,
                                Boolean old_val, Boolean new_val) {
            }
        });
        CheckBox box3 = drawnCheckboxes[2];
        final Tooltip tooltip3 = new Tooltip("Save this result.");
        box3.setTooltip(tooltip3);
        box3.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov,
                                Boolean old_val, Boolean new_val) {
            }
        });
        CheckBox box4 = drawnCheckboxes[3];
        final Tooltip tooltip4 = new Tooltip("Save this result.");
        box4.setTooltip(tooltip4);
        box4.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov,
                                Boolean old_val, Boolean new_val) {
            }
        });
        CheckBox box5 = drawnCheckboxes[4];
        final Tooltip tooltip5 = new Tooltip("Save this result.");
        box5.setTooltip(tooltip5);
        box5.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov,
                                Boolean old_val, Boolean new_val) {
            }
        });
        checkboxes.getChildren().addAll(box1, box2, box3, box4, box5);


        Group allPips = new Group();
        Group pips1 = new Group();
        Circle[] centerPips = new Circle[5];
        for (int i = 0; i < 5; i++) {
            Circle pip = DiceVisuals.drawCenterPip(drawnDice, i);
            centerPips[i] = pip;
            centerPips[i].setVisible(false);
        }
        Circle centerPip1 = centerPips[0];
        Circle centerPip2 = centerPips[1];
        Circle centerPip3 = centerPips[2];
        Circle centerPip4 = centerPips[3];
        Circle centerPip5 = centerPips[4];
        pips1.getChildren().addAll(centerPip1, centerPip2, centerPip3, centerPip4, centerPip5);

        Group pips2 = new Group();
        Circle[] topLeftPips = new Circle[5];
        for (int i = 0; i < 5; i++) {
            Circle pip = DiceVisuals.drawTopLeftPip(drawnDice, i);
            topLeftPips[i] = pip;
            topLeftPips[i].setVisible(true);
        }
        Circle topLeftPip1 = topLeftPips[0];
        Circle topLeftPip2 = topLeftPips[1];
        Circle topLeftPip3 = topLeftPips[2];
        Circle topLeftPip4 = topLeftPips[3];
        Circle topLeftPip5 = topLeftPips[4];
        pips2.getChildren().addAll(topLeftPip1, topLeftPip2, topLeftPip3, topLeftPip4, topLeftPip5);

        Group pips3 = new Group();
        Circle[] centerLeftPips = new Circle[5];
        for (int i = 0; i < 5; i++) {
            Circle pip = DiceVisuals.drawCenterLeftPip(drawnDice, i);
            centerLeftPips[i] = pip;
            centerLeftPips[i].setVisible(true);
        }
        Circle centerLeftPip1 = centerLeftPips[0];
        Circle centerLeftPip2 = centerLeftPips[1];
        Circle centerLeftPip3 = centerLeftPips[2];
        Circle centerLeftPip4 = centerLeftPips[3];
        Circle centerLeftPip5 = centerLeftPips[4];
        pips3.getChildren().addAll(centerLeftPip1, centerLeftPip2, centerLeftPip3, centerLeftPip4, centerLeftPip5);

        Group pips4 = new Group();
        Circle[] bottomLeftPips = new Circle[5];
        for (int i = 0; i < 5; i++) {
            Circle pip = DiceVisuals.drawBottomLeftPip(drawnDice, i);
            bottomLeftPips[i] = pip;
            bottomLeftPips[i].setVisible(true);
        }
        Circle bottomLeftPip1 = bottomLeftPips[0];
        Circle bottomLeftPip2 = bottomLeftPips[1];
        Circle bottomLeftPip3 = bottomLeftPips[2];
        Circle bottomLeftPip4 = bottomLeftPips[3];
        Circle bottomLeftPip5 = bottomLeftPips[4];
        pips4.getChildren().addAll(bottomLeftPip1, bottomLeftPip2, bottomLeftPip3, bottomLeftPip4, bottomLeftPip5);

        Group pips5 = new Group();
        Circle[] topRightPips = new Circle[5];
        for (int i = 0; i < 5; i++) {
            Circle pip = DiceVisuals.drawTopRightPip(drawnDice, i);
            topRightPips[i] = pip;
            topRightPips[i].setVisible(true);
        }
        Circle topRightPip1 = topRightPips[0];
        Circle topRightPip2 = topRightPips[1];
        Circle topRightPip3 = topRightPips[2];
        Circle topRightPip4 = topRightPips[3];
        Circle topRightPip5 = topRightPips[4];
        pips5.getChildren().addAll(topRightPip1, topRightPip2, topRightPip3, topRightPip4, topRightPip5);

        Group pips6 = new Group();
        Circle[] centerRightPips = new Circle[5];
        for (int i = 0; i < 5; i++) {
            Circle pip = DiceVisuals.drawCenterRightPip(drawnDice, i);
            centerRightPips[i] = pip;
            centerRightPips[i].setVisible(true);
        }
        Circle centerRightPip1 = centerRightPips[0];
        Circle centerRightPip2 = centerRightPips[1];
        Circle centerRightPip3 = centerRightPips[2];
        Circle centerRightPip4 = centerRightPips[3];
        Circle centerRightPip5 = centerRightPips[4];
        pips6.getChildren().addAll(centerRightPip1, centerRightPip2, centerRightPip3, centerRightPip4, centerRightPip5);

        Group pips7 = new Group();
        Circle[] bottomRightPips = new Circle[5];
        for (int i = 0; i < 5; i++) {
            Circle pip = DiceVisuals.drawBottomRightPip(drawnDice, i);
            bottomRightPips[i] = pip;
            bottomRightPips[i].setVisible(true);
        }
        Circle bottomRightPip1 = bottomRightPips[0];
        Circle bottomRightPip2 = bottomRightPips[1];
        Circle bottomRightPip3 = bottomRightPips[2];
        Circle bottomRightPip4 = bottomRightPips[3];
        Circle bottomRightPip5 = bottomRightPips[4];
        pips7.getChildren().addAll(bottomRightPip1, bottomRightPip2, bottomRightPip3, bottomRightPip4, bottomRightPip5);

        allPips.getChildren().addAll(pips1, pips2, pips3, pips4, pips5, pips6, pips7);
        final Circle[][] DICEPIPS = {centerPips, topLeftPips, centerLeftPips, bottomLeftPips, topRightPips, centerRightPips, bottomRightPips};

        final Button startnewTurn = new Button("New Turn!");
        startnewTurn.setTranslateX(550);
        startnewTurn.setTranslateY(550);
        startnewTurn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                startnewTurn.setVisible(false);
                try {Turn thisTurn = new Turn(root, scoreSheet, DICEPIPS, drawnCheckboxes, startnewTurn);}
                catch (InterruptedException e){}
            }
        });

        root.getChildren().addAll(vbox, dice, allPips, startnewTurn, checkboxes);

        primaryStage.setScene(scene);
        primaryStage.show();
        //schermopbouw

        //for (int turnCount = 0; turnCount < NUMBEROFTURNS; turnCount++){
        //    Turn thisTurn = new Turn(scoreSheet);
        //}

        //endofgame
    }

    public static void main(String[] args) {
        launch(args);
    }
}
