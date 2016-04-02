package com.ivik.learningjava.maven.asadelafosse;

import com.ivik.learningjava.maven.asadelafosse.Scoring.ScoreSheet;
import com.ivik.learningjava.maven.asadelafosse.VisualComponents.ButtonCrafter;
import com.ivik.learningjava.maven.asadelafosse.VisualComponents.DiceVisuals;
import com.ivik.learningjava.maven.asadelafosse.VisualComponents.Checkboxes;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class Turn {

    final int NUMBEROFROLLS = 3;
    boolean rerollAll = false;
    boolean[] savedDice = {false, false, false, false, false};
    int rollCount = 0;
    ArrayList<Integer> myRoll = new ArrayList<Integer>(5);
    boolean thisTurnScored = false;

    public Turn(final Pane root, final ScoreSheet[][] scoreSheet, final Circle[][] DICEPIPS, final CheckBox[] checkboxes,
                final Button startNewTurn, final Button finish, final VBox oldVBox) throws InterruptedException {
        rollCount = 1;
                Thread.sleep(500);
        myRoll = Roll.rollTheDice();
        showDice(myRoll, DICEPIPS);
        Checkboxes.uncheckCheckboxes(checkboxes);
        Checkboxes.showCheckboxes(checkboxes);

        final Button nextRoll = new Button("Roll #" + (rollCount + 1) + "!");
        nextRoll.setTranslateX(550);
        nextRoll.setTranslateY(550);
        nextRoll.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                try {
                    Thread.sleep(500);
                } catch(InterruptedException e) {

                }
                rollCount++;
                for (int i = 0; i < 5; i++) {
                    savedDice[i] = checkboxes[i].isSelected();
                }
                myRoll = performRoll(myRoll, rollCount, savedDice);
                showDice(myRoll, DICEPIPS);
                if (rollCount == 3){
                    nextRoll.setVisible(false);
                    Checkboxes.hideCheckboxes(checkboxes);
                    thisTurnScored = true;
                }
                nextRoll.setText("Roll #" + (rollCount + 1) + "!");
            }
        });

        Group scoreButtons = new Group();
        final Button scoreAces = ButtonCrafter.scoreButton(0, 0, scoreSheet, myRoll, root, oldVBox, nextRoll, startNewTurn, finish, checkboxes, scoreButtons);
        final Button scoreTwos = ButtonCrafter.scoreButton(0, 1, scoreSheet, myRoll, root, oldVBox, nextRoll, startNewTurn, finish, checkboxes, scoreButtons);
        final Button scoreThrees = ButtonCrafter.scoreButton(0, 2, scoreSheet, myRoll, root, oldVBox, nextRoll, startNewTurn, finish, checkboxes, scoreButtons);
        final Button scoreFours = ButtonCrafter.scoreButton(0, 3, scoreSheet, myRoll, root, oldVBox, nextRoll, startNewTurn, finish, checkboxes, scoreButtons);
        final Button scoreFives = ButtonCrafter.scoreButton(0, 4, scoreSheet, myRoll, root, oldVBox, nextRoll, startNewTurn, finish, checkboxes, scoreButtons);
        final Button scoreSixes = ButtonCrafter.scoreButton(0, 5, scoreSheet, myRoll, root, oldVBox, nextRoll, startNewTurn, finish, checkboxes, scoreButtons);
        final Button scoreThreeOfAKind = ButtonCrafter.scoreButton(1, 0, scoreSheet, myRoll, root, oldVBox, nextRoll, startNewTurn, finish, checkboxes, scoreButtons);
        final Button scoreFourOfAKind = ButtonCrafter.scoreButton(1, 1, scoreSheet, myRoll, root, oldVBox, nextRoll, startNewTurn, finish, checkboxes, scoreButtons);
        final Button scoreFullHouse = ButtonCrafter.scoreButton(1, 2, scoreSheet, myRoll, root, oldVBox, nextRoll, startNewTurn, finish, checkboxes, scoreButtons);
        final Button scoreSmallStraight = ButtonCrafter.scoreButton(1, 3, scoreSheet, myRoll, root, oldVBox, nextRoll, startNewTurn, finish, checkboxes, scoreButtons);
        final Button scoreLargeStraight = ButtonCrafter.scoreButton(1, 4, scoreSheet, myRoll, root, oldVBox, nextRoll, startNewTurn, finish, checkboxes, scoreButtons);
        final Button scoreYahtzee = ButtonCrafter.scoreYahtzeeButton(1, 5, scoreSheet, myRoll, root, oldVBox, nextRoll, startNewTurn, finish, checkboxes, scoreButtons);
        final Button scoreChance = ButtonCrafter.scoreButton(1, 6, scoreSheet, myRoll, root, oldVBox, nextRoll, startNewTurn, finish, checkboxes, scoreButtons);
        scoreButtons.getChildren().addAll(scoreAces, scoreTwos, scoreThrees, scoreFours, scoreFives, scoreSixes,
                scoreThreeOfAKind, scoreFourOfAKind, scoreFullHouse, scoreSmallStraight, scoreLargeStraight, scoreYahtzee, scoreChance);
        root.getChildren().addAll(scoreButtons, nextRoll);

        if (rollCount == NUMBEROFROLLS - 1) {
            nextRoll.setVisible(false);
        }

        if (thisTurnScored){
            root.getChildren().removeAll(scoreButtons);
        }
    }


    public ArrayList<Integer> performRoll(ArrayList<Integer> myRoll, int rollCount, boolean[] savedDice) {

        if (rollCount == 1 || rerollAll) {
            myRoll.clear();
            myRoll = Roll.rollTheDice();
        } else {
            for (int i = 0; i < 5; i++) {
                if (!savedDice[i]) {
                    myRoll.remove(i);
                    myRoll.add(i, Roll.rollSingleDie());
                }
            }
        }
        rerollAll = false;
        return myRoll;
    }

    public static void showDice(ArrayList<Integer> myRoll, Circle[][] DICEPIPS) {
        for (int i = 0; i < 5; i++) {
            if (myRoll.get(i) == 1) {
                DiceVisuals.displayOne(DICEPIPS, i);
            }
            if (myRoll.get(i) == 2) {
                DiceVisuals.displayTwo(DICEPIPS, i);
            }
            if (myRoll.get(i) == 3) {
                DiceVisuals.displayThree(DICEPIPS, i);
            }
            if (myRoll.get(i) == 4) {
                DiceVisuals.displayFour(DICEPIPS, i);
            }
            if (myRoll.get(i) == 5) {
                DiceVisuals.displayFive(DICEPIPS, i);
            }
            if (myRoll.get(i) == 6) {
                DiceVisuals.displaySix(DICEPIPS, i);
            }

        }

    }
}
