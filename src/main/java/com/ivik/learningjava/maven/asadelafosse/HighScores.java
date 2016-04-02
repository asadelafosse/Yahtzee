package com.ivik.learningjava.maven.asadelafosse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Sebastien on 1-4-2016.
 */
public class HighScores {

    public static ArrayList<ArrayList<String>> retrieveHighScores(String fileName){
        ArrayList<ArrayList<String>> csvSeparatedFinal = new ArrayList();
        ArrayList<String> csvAsString = new ArrayList();
        try {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        boolean hasNextLine = true;
        String aLine;

        while (hasNextLine) {
            aLine = reader.readLine();
            if (aLine != null) {
                csvAsString.add(aLine);
            } else {
                hasNextLine = false;
            }
        }
        reader.close();
    } catch(IOException e) {
            while (csvSeparatedFinal.size() < 10){
                ArrayList<String> emptyScore = new ArrayList<String>(0);
                emptyScore.add("");
                emptyScore.add("0");
                csvSeparatedFinal.add(emptyScore);
            }
            return csvSeparatedFinal;
        }



        for (int i = 0; i <= csvAsString.size() - 1; i++) {
            int commaCounter = 0;
            String unseparatedLine = csvAsString.get(i);
            String[] separatedLine;
            for (int j = 0; j < unseparatedLine.length(); j++){
                if (unseparatedLine.charAt(j) == ','){
                    commaCounter++;
                }
            }
            if (commaCounter == 1) {
                separatedLine = unseparatedLine.split(",");
            } else {
                separatedLine = new String[]{"", "0"};
            }

            ArrayList<String> csvSeparatedByLine = new ArrayList();
            Collections.addAll(csvSeparatedByLine, separatedLine);
            csvSeparatedFinal.add(i, csvSeparatedByLine);
        }

        csvSeparatedFinal = sortArray(csvSeparatedFinal, compareScore);

        if (csvSeparatedFinal.size() > 10) {
            csvSeparatedFinal.subList(10, csvSeparatedFinal.size()).clear();
            return csvSeparatedFinal;
        } else {
            while (csvSeparatedFinal.size() < 10){
                ArrayList<String> emptyScore = new ArrayList<String>(0);
                emptyScore.add("");
                emptyScore.add("0");
                csvSeparatedFinal.add(emptyScore);
            }
            return csvSeparatedFinal;
        }
    }

    public static Comparator compareScore = new Comparator() {

        public int compare(Object score1AsString, Object score2AsString) {
            int score1 = Integer.parseInt((String) score1AsString);
            int score2 = Integer.parseInt((String) score2AsString);
            if (score1 < score2) {
                return 1;
            } else if (score1 > score2) {
                return -1;
            } else return 0;
        }
    };

    public static ArrayList<ArrayList<String>> sortArray(ArrayList<ArrayList<String>> input, Comparator comp) {
        ArrayList<String> temp;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i <= input.size() - 2; i++) {
                int decider = comp.compare(input.get(i).get(1), input.get(i + 1).get(1));
                if (decider == 1) {
                    temp = input.get(i);
                    input.set(i, input.get(i + 1));
                    input.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
        return input;
    }
}
