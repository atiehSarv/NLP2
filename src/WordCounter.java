

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.*;

public  class WordCounter {

    private Cleaning cleaningUp = new Cleaning();
    private HashMap<String , Integer> map ;
    public  HashMap<String, Integer> getMap(){
        return  map;
    }


    public String counter(String inputfile) throws FileNotFoundException, IOException {

        String CleanedUpfile = cleaningUp.cleanUp(inputfile);
        int numberOfWords = cleaningUp.tokenCounter(inputfile+"clearedUp");
     //   System.out.print(CleanedUpfile);
        System.out.print(numberOfWords);
        InputStream CleanedUpFile = getClass().getResourceAsStream(CleanedUpfile);
        BufferedReader readFile = new BufferedReader(new InputStreamReader(CleanedUpFile));
        PrintWriter file = null;
        file = new PrintWriter(new BufferedWriter(new  FileWriter(  "C:/Users/Heydari/IdeaProjects/phase1NLP2/src/"+inputfile+"countWordsMap")));
        String inputLine = null;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Set<Map.Entry<String, Integer>> entrySet = null;


        try {
            while ((inputLine = readFile.readLine()) != null) {
                String[] words = inputLine.split("[ \n\t\r.,;:!?(){}]");

                for (int wordCounter = 0; wordCounter < words.length; wordCounter++) {
                    String key = words[wordCounter].toLowerCase();
                    if (key.length() > 0) {
                        if (map.get(key) == null) {
                            map.put(key, (1));
                        }
                        else {
                            int value = map.get(key).intValue();
                            value++;
                            map.put(key,  value);
                        }
                    }
                    entrySet = map.entrySet();

                }

            }
            this.map =map;
            int allWords = 0;
            for(Map.Entry<String, Integer> entry : entrySet){
                allWords+=  entry.getValue();
            }
        /*    System.out.println("for file " + inputfile + ":");
            System.out.printf("number of all words is %d \n" , allWords); */
            for (Map.Entry<String, Integer> entry : entrySet) {

                //   sentences[i] = sentences[i].replaceAll(" ", "");
                file.println(entry.getValue() + "\t" + entry.getKey());

                //    System.out.println(entry.getValue() + "\t" + entry.getKey());
            }

        }
        catch (IOException error) {
            System.out.println("Invalid File");
        }

        finally {
            readFile.close();
            file.close();

        }

        return inputfile+"countWordsMap";

    }
    public int probability(String[] input) {
        int x=0;
        for (int i=0 ; i< input.length ; i ++){

        }
        return x;

    }






    public static void main(String[] args) throws IOException {
        WordCounter w1 = new WordCounter();
        WordCounter w2 = new WordCounter();
        w1.counter("eshgh");
        w2.counter("fekr");
HashMap<String,Integer> map1 = w1.getMap();
HashMap<String,Integer> map2 = w2.getMap();
System.out.print(map2);
    }


}