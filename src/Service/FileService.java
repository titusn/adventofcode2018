package Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileService {
    public static ArrayList<Integer> readFile(String filename) {
        Scanner s = null;
        try {
            s = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (s.hasNext()){
            list.add(Integer.parseInt(s.next()));
        }
        s.close();
        return list;
    }

}
