package com.ivik.asadelafosse.VisualComponents;

import com.ivik.asadelafosse.Scoring.BonusUpperSection;
import com.ivik.asadelafosse.Scoring.ExtraYahtzeeChecker;
import com.ivik.asadelafosse.Scoring.ScoreSheet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

/**
 * Created by Sebastien on 22-3-2016.
 */
public class ButtonCrafter {

    public static Button scoreButton(final int i, final int j, final ScoreSheet[][] scoreSheet, final ArrayList<Integer> myRoll,
                                     final Pane root, final VBox oldVBox, final Button nextRoll, final Button startNewTurn,
                                     final Button finish, final CheckBox[] checkboxes, final Group scoreButtons){
        final Button scoreSomething = new Button("Score");
        int[] evaluatedRoll = RollEvaluator.evaluateRoll(myRoll);
        ExtraYahtzeeChecker check = ExtraYahtzeeChecker.processExtraYahtzee(evaluatedRoll, scoreSheet, new ExtraYahtzeeChecker());
        if (scoreSheet[i][j].filled || !scoreSheet[i][j].isAllowed(evaluatedRoll, check)){
            scoreSomething.setVisible(false);
        }
        scoreSomething.setTranslateX(375);
        scoreSomething.setTranslateY(50 + 243*i + 28*j);
        scoreSomething.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                int[] evaluatedRoll = RollEvaluator.evaluateRoll(myRoll);
                ExtraYahtzeeChecker check = ExtraYahtzeeChecker.processExtraYahtzee(evaluatedRoll, scoreSheet, new ExtraYahtzeeChecker());
                scoreSheet[i][j].recordScore(scoreSheet[i][j].scorePoints(evaluatedRoll, scoreSheet[i][j].qualifies(evaluatedRoll, check)));
                scoreSheet[0][6].recordScore(BonusUpperSection.determineUpperBonus(scoreSheet));
                if (scoreSheet[1][5].qualifies(evaluatedRoll, new ExtraYahtzeeChecker()) && scoreSheet[1][5].filled && scoreSheet[1][5].fieldScore == 50) {
                    scoreSheet[2][0].fieldScore += 100;
                }
                scoreSomething.setVisible(false);
                root.getChildren().remove(oldVBox);
                TableView upperScores = ScoreTableCrafter.upperScores(scoreSheet);
                TableView lowerScores = ScoreTableCrafter.lowerScores(scoreSheet);
                TableView totalScores = ScoreTableCrafter.totalScores (scoreSheet);
                final VBox vbox = new VBox(20);
                vbox.setPadding(new Insets(25, 25, 25, 25));
                vbox.getChildren().addAll(upperScores, lowerScores, totalScores);
                root.getChildren().add(vbox);
                nextRoll.setVisible(false);
                Checkboxes.hideCheckboxes(checkboxes);
                scoreButtons.setVisible(false);
                Game.turnCounter++;
                if (Game.turnCounter == Game.NUMBEROFTURNS){
                    finish.setVisible(true);
                } else {
                    startNewTurn.setVisible(true);
                }
            }
        });
        return scoreSomething;
    }

    public static Button scoreYahtzeeButton(final int i, final int j, final ScoreSheet[][] scoreSheet, final ArrayList<Integer> myRoll,
                                            final Pane root, final VBox oldVBox, final Button nextRoll, final Button startNewTurn,
                                            final Button finish, final CheckBox[] checkboxes, final Group scoreButtons){
        final Button scoreSomething = new Button("Score");
        if (scoreSheet[i][j].filled){
            scoreSomething.setVisible(false);
        }
        scoreSomething.setTranslateX(375);
        scoreSomething.setTranslateY(50 + 243*i + 28*j);
        scoreSomething.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                int[] evaluatedRoll = RollEvaluator.evaluateRoll(myRoll);
                ExtraYahtzeeChecker check = new ExtraYahtzeeChecker();
                scoreSheet[i][j].recordScore(scoreSheet[i][j].scorePoints(evaluatedRoll, scoreSheet[i][j].qualifies(evaluatedRoll, check)));
                scoreSheet[0][6].recordScore(BonusUpperSection.determineUpperBonus(scoreSheet));
                scoreSomething.setVisible(false);
                root.getChildren().remove(oldVBox);
                TableView upperScores = ScoreTableCrafter.upperScores(scoreSheet);
                TableView lowerScores = ScoreTableCrafter.lowerScores(scoreSheet);
                TableView totalScores = ScoreTableCrafter.totalScores (scoreSheet);
                final VBox vbox = new VBox(20);
                vbox.setPadding(new Insets(25, 25, 25, 25));
                vbox.getChildren().addAll(upperScores, lowerScores, totalScores);
                root.getChildren().add(vbox);
                nextRoll.setVisible(false);
                Checkboxes.hideCheckboxes(checkboxes);
                scoreButtons.setVisible(false);
                Game.turnCounter++;
                if (Game.turnCounter == Game.NUMBEROFTURNS){
                    finish.setVisible(true);
                } else {
                    startNewTurn.setVisible(true);
                }
            }
        });
        return scoreSomething;
    }
}
