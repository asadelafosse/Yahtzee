package com.ivik.learningjava.maven.asadelafosse;

import com.ivik.learningjava.maven.asadelafosse.VisualComponents.DiceVisuals;
import com.ivik.learningjava.maven.asadelafosse.Scoring.ScoreSheet;
import com.ivik.learningjava.maven.asadelafosse.VisualComponents.Checkboxes;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Pane;
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


    public Turn(final Pane root, final ScoreSheet[][] scoreSheet, final Circle[][] DICEPIPS, final CheckBox[] checkboxes, final Button startNewTurn) throws InterruptedException {
        rollCount = 1;
                Thread.sleep(1000);
        myRoll = Roll.rollTheDice();
        showDice(myRoll, DICEPIPS);
        Checkboxes.uncheckCheckboxes(checkboxes);
        Checkboxes.showCheckboxes(checkboxes);

        final Button nextRoll = new Button("Roll #" + (rollCount + 1) + "!");
        nextRoll.setTranslateX(550);
        nextRoll.setTranslateY(550);
        nextRoll.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                rollCount++;
                for (int i = 0; i < 5; i++) {
                    savedDice[i] = checkboxes[i].isSelected();
                    System.out.print(savedDice[i] + " ");
                }
                myRoll = performRoll(myRoll, rollCount, savedDice);
                showDice(myRoll, DICEPIPS);
                if (rollCount == 3){
                    nextRoll.setVisible(false);
                    Checkboxes.hideCheckboxes(checkboxes);
                    startNewTurn.setVisible(true);
                }
                nextRoll.setText("Roll #" + (rollCount + 1) + "!");
            }
        });
        root.getChildren().add(nextRoll);

        if (rollCount == NUMBEROFROLLS - 1) {
            nextRoll.setVisible(false);
        }
        Group scoreButtons = new Group();
        final Button scoreAces = new Button("Score");
        scoreAces.setTranslateX(375);
        scoreAces.setTranslateY(50);
        scoreAces.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                scoreSheet[0][0].fieldScore = scoreSheet[0][0].determineScore(RollEvaluator.evaluateRoll(myRoll));
                scoreSheet[0][0].fill();
                scoreAces.setVisible(false);
                System.out.println(scoreSheet[0][0].fieldScore);
            }
        });
        scoreButtons.getChildren().addAll(scoreAces);
        root.getChildren().addAll(scoreButtons);


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
        System.out.println(myRoll);
        return myRoll;
    }

        //Collections.sort(myRoll);

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




    //call javafx input new untouchedDice method & reroll all button






        int[] rollResult = RollEvaluator.evaluateRoll(myRoll);
        //if (rollResult.scoreSheet[1][5].) {
        //    ExtraYahtzeeChecker check = new ExtraYahtzeeChecker();
        //}


        // call scoring method

        //TotalScore.updateScores(scoreSheet);

        // call score redrawing method

    //}

    static ArrayList<Integer> saveSelectedScore(ArrayList<Integer> diceRoll, boolean[] selectedDice){
        ArrayList<Integer> savedDice = new ArrayList<Integer>();
        for (int i = 0; i < selectedDice.length; i++) {
            if (selectedDice[i]) {
                savedDice.add(diceRoll.get(i));
            }
        }
        return savedDice;
    }



}
