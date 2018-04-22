import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class Comparing {

    HashMap<String ,Integer>  map1 ;
    HashMap<String,Integer> map2;
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    Set<Map.Entry<String, Integer>> entrySet = null;

    public HashMap<String, Integer> getMap() {
        return map;
    }

    public void compareMaps(HashMap<String,Integer> mapp1 , HashMap<String,Integer> mapp2) throws IOException {
        PrintWriter file = null;
        file = new PrintWriter(new BufferedWriter(new  FileWriter(  "C:/Users/Heydari/IdeaProjects/phase1NLP2/src/thirdwordmap")));



        for (Map.Entry<String,Integer> entry : mapp1.entrySet()){
            int sub=0;
            for(Map.Entry<String,Integer> en : mapp2.entrySet()){
                if (entry.getKey().equals((en.getKey()))){
                  //  System.out.print(en.getKey());
                   sub = (int) (entry.getValue()*0.653 - en.getValue());
                    map.put(entry.getKey(), (sub));

                }
                else{
                    map.put(entry.getKey(), (int) (entry.getValue()*0.653));
                }

            }
            entrySet = map.entrySet();
        }



        for (Map.Entry<String,Integer> entry : mapp2.entrySet()){
            int sub=0;
            for(Map.Entry<String,Integer> en : mapp1.entrySet()){
                if (entry.getKey().equals((en.getKey()))){
                    continue;
                }
                else{
                    map.put(entry.getKey(), (int) (-entry.getValue()*0.653));
                }

            }
            entrySet = map.entrySet();
        }

        System.out.println(map);
        for (Map.Entry<String, Integer> entry : entrySet) {

            //   sentences[i] = sentences[i].replaceAll(" ", "");
            file.println(entry.getValue() + "\t" + entry.getKey());

            //    System.out.println(entry.getValue() + "\t" + entry.getKey());
        }
    }

    public  static  void main(String[] args) throws IOException {
        WordCounter w1 = new WordCounter();
        WordCounter w2 = new WordCounter();
        w1.counter("eshgh");
        w2.counter("fekr");
        HashMap<String,Integer> map1 = w1.getMap();
        HashMap<String,Integer> map2 = w2.getMap();
       // System.out.print(map2);
        Comparing cmp = new Comparing();
        cmp.compareMaps(map1 , map2);
        TestOpenCloud test = new TestOpenCloud();
        test.initUI(cmp.getMap());

    }
}
