package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(calculateTotalChecksum(readFile("inputday2.csv")));
    }

    private static int calculateTotalChecksum(ArrayList<String> ids) {
        Integer total = 0;

        for (String id : ids) {
            calculateIndividualChecksum(id);
        }

        return total;
    }

    private static HashMap<String, Integer> calculateIndividualChecksum(String id) {

        HashMap<String, Integer> trimmedCount = trimCounts(countCharacters(id));

        return trimmedCount;
    }

    private static HashMap<String, Integer> trimCounts(HashMap<String, Integer> countCharacters) {
        HashMap<String, Integer> tempCount = new HashMap<>(countCharacters);

        for (String key : tempCount.keySet()) {
            if (tempCount.get(key) == 1) {
                tempCount.remove(key);
            }
        }
        return tempCount;
    }

    private static HashMap<String, Integer> countCharacters(String id) {
        String[] characters = id.split("");
        HashMap<String, Integer> characterCount = new HashMap<>();

        for (String character : characters) {
            if (characterCount.containsKey(character)) {
                characterCount.put(character, characterCount.get(character) + 1);
            } else {
                characterCount.put(character, 1);
            }
        }
        return characterCount;
    }

    private static ArrayList<String> readFile(String filename) {
        Scanner s = null;
        try {
            s = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> list = new ArrayList<>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();
        return list;
    }


}
