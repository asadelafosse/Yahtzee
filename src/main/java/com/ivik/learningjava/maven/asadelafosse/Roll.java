package com.ivik.learningjava.maven.asadelafosse;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class Roll {

    public static int rollSingleDie(){
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

    public static ArrayList<Integer> rollTheDice(){
        ArrayList<Integer> rollResult = new ArrayList();
        for (int i = 0; i < 5; i++){
            rollResult.add(rollSingleDie());
        }
        return rollResult;
    }

    /*public static ArrayList<Integer> rerollSomeDice(boolean[] untouchedDice){
        ArrayList<Integer> rollResult = new ArrayList();
        for (int i = 0; i < 5; i++){
            if (!untouchedDice[i]){
                continue;
            }
            rollResult.add(rollSingleDie());
        }
        return rollResult;
    }

    public ArrayList<Integer> performFirstRoll = rollTheDice();

    public ArrayList<Integer> performConsecutiveRoll(boolean[] untouchedDice){
        return rerollSomeDice(untouchedDice);
    }*/


}
