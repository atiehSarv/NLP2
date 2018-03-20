import java.io.*;

public class Cleaning {



    public void writing() throws IOException {
        PrintWriter file = null;
        char[] chars = {'.' , ',' , '?' , '!' ,':' ,
                '"' , ')' , '(','0' , '1' ,'2' , '3', '4', '5', '6', '7', '8', '9','؟',
                '،' ,'a' ,'b','c','d','e','f','g','h','i','j',
                'k','l','m','n','o','p','q','r','s','t','u'
                ,'v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K',
                'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        String[] keys ={"اگر","اما","پس","تا","چون","چه","خواه"
                ,"زیرا","که","لیکن","نه","نیز","و","ولی",
                "هم","یا","از","الا","با","بر","برای","بی","حز"
                ,"در","مگر","مثل","را","یا","ای","به","ﺑﻪ","این","ان","یک",
                "حتی", "دو" , "می", "روی","انکه","هر","میان","انقدر" ,
                "همان", "مرا","اینکه", "یکی" ,"ﺗﺎ" ,"شود" ,"بود", "اﺳﺖ" ," شود","ﮐﻨﯿﺪ",
                "اﺳﺖ","ﻣﯽ" , "اﯾﻦ", "ﮐﺮد", "را" ,"ﻫﻢ" ,"ﮐﻪ" ,"ﮐﺮدم",
                "ﮐﻨﻨﺪ" ,"ﮐﻨﺪ",  "ﺧﻮاﻫﺪ","داد"  ,"و" ,
                "ﺑﻪ", "ﺧﻮاﻫﯿﺪ", "ﺑﺎ", "ﭼﻪ" ,"ﺑﺮای" ,"تریسی" ,  "نویسنده" ,"ارﯾﺎ" ,
                "ام" , "ای" , " اید", "اید", "ایم","اید","اند","کرده","ﯾﺎ" ,"ﻫﺎ"
        ,"ﻣﯽ" , "ﻫﺮ", "ﺗﺮ" ,"ان" ,"اﻧﭽﻪ" ,"ﺑﻪ","ﺑﻮد" ,"ﻫﻢ","از","در",
                 "اﻣﺎ", "است","نیست","کردم" ,"کرد" ,"شده" , "اش","شد","شوم",
        "کنی","بشوی","شود", "باشد","چی","کنم","کنند", "همین","کرد","کند","شود"}   ;
        file = new PrintWriter(new BufferedWriter(new FileWriter("melateEshgh")));
        //  file.close();


        InputStream inputFile = getClass().getResourceAsStream("./melateEshgh");
        BufferedReader readFile = new BufferedReader(new InputStreamReader(inputFile));
        String temp ="";
        String file_line;

        InputStream inputVerbs = getClass().getResourceAsStream("./verbs");
        BufferedReader readVerbs = new BufferedReader(new InputStreamReader(inputVerbs));
        String tempverb="";
        String verbLine;
        try {
            while ((file_line = readFile.readLine()) != null) {

                temp = file_line;
                temp = temp.replaceAll("\u202B" , "");
                temp =temp.replaceAll("\u202A,","");
                temp = temp.replaceAll("ؤ","و");
                temp = temp.replaceAll( "ك","ک");
                temp = temp.replaceAll( "ي", "ی");
                temp = temp.replaceAll("ة","ه");
                temp = temp.replaceAll("آ","ا");
                temp = temp.replaceAll("أ","ا");
                temp = temp.replaceAll("إ","ا");
                temp = temp.replaceAll("أ","ا");
                temp = temp.replaceAll("ئ","ی");
                temp = temp.replaceAll("ئ","ی");


          //      temp=temp.replaceAll("\u202C" ,"");
             //   temp=temp.replaceAll( "ﮐﻨﺪ\u202A ","");
                // temp = temp.replaceAll( "بود","بود" ) ;
                //   temp = temp.replaceAll("د","د");

                //  temp =temp.replaceAll( "شود" , "شود"); */
                temp = temp.replaceAll("ها" , "");
                temp = temp.replaceAll("های" , "");
                temp = temp.replaceAll("هایی" , "");


                for (int j = 0; j < temp.length(); j++) {
                    char s = temp.charAt(j);
                    for(int i = 0 ; i< chars.length ; i ++){
                        if ( chars[i] == s){

                            temp= temp.replace(s, ' ');
//System.out.println(temp);
                        }

                    }

                }

                temp = temp.replaceAll(" ", "");
                for(int i = 0 ; i < keys.length ; i ++) {
                    if (temp.equals(keys[i])){
                        temp = "";
                    }
                }
                temp = temp.replaceAll(" ", "");
                temp=temp.replaceAll("\u202C" ,"");
                if(temp.startsWith("می")){
                    temp = temp.replaceAll("می", "");
                }
                else if(temp.startsWith("نمی")){
                    temp = temp.replaceAll("نمی", "");
                }



                file.println(temp);

            }
        } catch (IOException e) {
            e.printStackTrace();

        }



        file.close();


    }



    public static void main(String[] args) throws IOException {
        Cleaning f = new Cleaning();
        f.writing();
        //  f.editing();

    }
}


