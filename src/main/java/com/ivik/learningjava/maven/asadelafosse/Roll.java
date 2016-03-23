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
}
