package com.ivik.yahtzee.VisualComponents;

import javafx.scene.control.CheckBox;
import javafx.scene.shape.Rectangle;

import java.awt.*;

/**
 * Created by Sebastien on 18-3-2016.
 */
public class Checkboxes {


    public static CheckBox[] drawCheckbox(Rectangle[] dice) {
        CheckBox[] boxes = new CheckBox[5];
        for (int i = 0; i < 5; i++) {
            CheckBox box = new CheckBox();
            box.setTranslateX(dice[i].getX() + 40);
            box.setTranslateY(dice[i].getY() + 125);
            box.setMinWidth(20);
            box.setMinHeight(20);
            box.setVisible(false);
            boxes[i] = box;
        }
        return boxes;

    }

    public static void showCheckboxes(CheckBox[] checkboxes){
        for (int i = 0; i < 5; i++){
            checkboxes[i].setVisible(true);
        }
    }

    public static void hideCheckboxes(CheckBox[] checkboxes){
        for (int i = 0; i < 5; i++){
            checkboxes[i].setVisible(false);
        }
    }

    public static void uncheckCheckboxes(CheckBox[] checkboxes){
        for (int i = 0; i < 5; i++){
            checkboxes[i].setSelected(false);
        }
    }
}
