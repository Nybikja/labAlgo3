package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Wchain {
    private final List<String> words = new ArrayList<>();
    private final List<String> foundWords = new ArrayList<>();

    private void writeStrings(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scannerfile = new Scanner(file);

        while (scannerfile.hasNextLine()) {
            words.add(scannerfile.nextLine());
        }
    }

    public Wchain(String path) throws FileNotFoundException {
        writeStrings(path);
        Comparator<String> stringLengthComparator = (o1, o2) -> Integer.compare(o2.length(), o1.length());
        words.sort(stringLengthComparator);
        System.out.println(words);
    }

    public void wchain() {
        String start = words.get(0);
        int counter = 0;
        int k = 0;
        String temp = words.get(k);

        for(int i = 0; i< words.size();i++){
            if(start.contains(temp)){
                foundWords.add(temp);
                start = words.get(k);
                if(i == words.size() - 1)
                    break;
            }
            temp = words.get(++k);
        }
        for (int i = 0;i<foundWords.size();i++) {
            if(foundWords.get(0).length() - foundWords.get(i).length() == i){
                counter++;
                System.out.println(foundWords.get(i));
            }
        }
        writeFile(counter);
    }

    private void writeFile(int counter) {
        try {
            FileWriter myWriter = new FileWriter("out.txt");
            myWriter.write("Counter: " + counter);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) throws FileNotFoundException {
        String path = "/Users/stepanvaschyshyn/Downloads/JavaClub4-Team3 2/algoLab6/src/com/company/logs";
        Wchain w = new Wchain(path);
        w.wchain();
    }
}
