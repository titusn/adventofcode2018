package day1;

import Service.FileService;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        System.out.println(findFrequencyPart1(readFile("input.csv")));
        System.out.println(findFrequencyPart2(readFile("input.csv")));
    }

    private static int findFrequencyPart1(ArrayList<Integer> frequencyChanges) {
        Integer total = 0;

        for (Integer change : frequencyChanges) {
            total += change;
        }

        return total;
    }

    private static int findFrequencyPart2(ArrayList<Integer> frequencyChanges) {
        Integer total = 0;
        ArrayList<Integer> frequencyHistory = new ArrayList<>();
        boolean frequencyFound = false;

        while (!frequencyFound) {
            for (Integer change: frequencyChanges) {
                if (frequencyHistory.contains(total)) {
                    frequencyFound = true;
                    break;
                } else {
                    frequencyHistory.add(total);
                    total += change;
                }
            }
        }

        return total;
    }

}
