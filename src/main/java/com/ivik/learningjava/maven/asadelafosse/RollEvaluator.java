package com.ivik.learningjava.maven.asadelafosse;


import java.util.ArrayList;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class RollEvaluator {

    public static int[] evaluateRoll(ArrayList<Integer> roll){
        int[] result = {0,0,0,0,0,0};
        for (int i = 0; i <= 6; i++){
            for (int j : roll) {
                if (j == i + 1) {
                    result[i]++;
                }
            }
        }
        return result;
    }

    public static int countAllOfOneKind(int[] roll, int kind){
        return kind * roll[kind - 1];
    }


    public static int countAllDice(int[] roll){
        int result = 0;
        for (int i = 0; i < roll.length; i++){
            result += countAllOfOneKind(roll, i + 1);
        }
        return result;
    }
}
