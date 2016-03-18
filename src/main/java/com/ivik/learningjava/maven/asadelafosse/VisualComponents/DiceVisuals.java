package com.ivik.learningjava.maven.asadelafosse.VisualComponents;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * Created by Sebastien on 17-3-2016.
 */
public class DiceVisuals {

    public static Rectangle[] drawDice() {

        Rectangle[] dice = new Rectangle[5];
        for (int i = 0; i < 5; i++) {
            Rectangle die = new Rectangle(100 * i + 50 * (i + 1), 800, 100, 100);
            die.setArcHeight(50);
            die.setArcWidth(50);
            die.setFill(Color.BEIGE);
            die.setStroke(Color.BLACK);
            dice[i] = die;
        }
        return dice;
    }

    public static Circle drawDicePip(double x, double y){
        Circle pip = new Circle(x, y, 10);
        pip.setFill(Color.BLACK);
        return pip;
    }
    public static Circle drawCenterPip(Rectangle[] dice, int dieNumber){
        return drawDicePip(dice[dieNumber].getX() + 50, dice[dieNumber].getY() + 50);
    }

    public static Circle drawTopLeftPip(Rectangle[] dice, int dieNumber) {
        return drawDicePip(dice[dieNumber].getX() + 25, dice[dieNumber].getY() + 25);
    }

    public static Circle drawCenterLeftPip(Rectangle[] dice, int dieNumber){
        return drawDicePip(dice[dieNumber].getX() + 25, dice[dieNumber].getY() + 50);
    }

    public static Circle drawBottomLeftPip(Rectangle[] dice, int dieNumber) {
        return drawDicePip(dice[dieNumber].getX() + 25, dice[dieNumber].getY() + 75);
    }

    public static Circle drawTopRightPip(Rectangle[] dice, int dieNumber) {
        return drawDicePip(dice[dieNumber].getX() + 75, dice[dieNumber].getY() + 25);
    }

    public static Circle drawCenterRightPip(Rectangle[] dice, int dieNumber) {
        return drawDicePip(dice[dieNumber].getX() + 75, dice[dieNumber].getY() + 50);
    }

    public static Circle drawBottomRightPip(Rectangle[] dice, int dieNumber) {
        return drawDicePip(dice[dieNumber].getX() + 75, dice[dieNumber].getY() + 75);
    }

    public static Circle[][] displayOne(Circle[][] DicePips, int dieNumber){
        for (int pipPosition = 0; pipPosition < 7; pipPosition++) {
            if (pipPosition == 0) {
                DicePips[pipPosition][dieNumber].setVisible(true);
            } else {
                DicePips[pipPosition][dieNumber].setVisible(false);
            }
        }
        return DicePips;
    }

    public static Circle[][] displayTwo(Circle[][] DicePips, int dieNumber){
        for (int pipPosition = 0; pipPosition < 7; pipPosition++) {
            if (pipPosition == 1 || pipPosition == 6) {
                DicePips[pipPosition][dieNumber].setVisible(true);
            } else {
                DicePips[pipPosition][dieNumber].setVisible(false);
            }
        }
        return DicePips;
    }

    public static Circle[][] displayThree(Circle[][] DicePips, int dieNumber){
        for (int pipPosition = 0; pipPosition < 7; pipPosition++) {
            if (pipPosition == 0 || pipPosition == 1 || pipPosition == 6) {
                DicePips[pipPosition][dieNumber].setVisible(true);
            } else {
                DicePips[pipPosition][dieNumber].setVisible(false);
            }
        }
        return DicePips;
    }

    public static Circle[][] displayFour(Circle[][] DicePips, int dieNumber){
        for (int pipPosition = 0; pipPosition < 7; pipPosition++) {
            if (pipPosition == 1 || pipPosition == 3 || pipPosition == 4 || pipPosition == 6) {
                DicePips[pipPosition][dieNumber].setVisible(true);
            } else {
                DicePips[pipPosition][dieNumber].setVisible(false);
            }
        }
        return DicePips;
    }

    public static Circle[][] displayFive(Circle[][] DicePips, int dieNumber){
        for (int pipPosition = 0; pipPosition < 7; pipPosition++) {
            if (pipPosition == 0 ||pipPosition == 1 || pipPosition == 3 || pipPosition == 4 || pipPosition == 6) {
                DicePips[pipPosition][dieNumber].setVisible(true);
            } else {
                DicePips[pipPosition][dieNumber].setVisible(false);
            }
        }
        return DicePips;
    }

    public static Circle[][] displaySix(Circle[][] DicePips, int dieNumber){
        for (int pipPosition = 0; pipPosition < 7; pipPosition++) {
            if (pipPosition == 0) {
                DicePips[pipPosition][dieNumber].setVisible(false);
            } else {
                DicePips[pipPosition][dieNumber].setVisible(true);
            }
        }
        return DicePips;
    }
}
