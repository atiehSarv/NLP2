import java.io.*;

public class FileReader {
    public void writing() throws IOException {
        PrintWriter file = null;
        file = new PrintWriter(new BufferedWriter(new  FileWriter("melateEshgh")));
        //  file.close();


        InputStream inputFile = getClass().getResourceAsStream("./melateEshgh");
        BufferedReader readFile = new BufferedReader(new InputStreamReader(inputFile));
        String temp ="";
        String file_line;


        try {
            int count = 0;
            while ((file_line = readFile.readLine()) != null) {

                temp=file_line;
                temp=temp.replace('\0' , ' ');
                temp=temp.replaceAll("\u202C"," ");
                temp=temp.replaceAll("\u202A"," ");
                temp=temp.replaceAll("\u202B"," ");
                temp=temp.replaceAll("\u200B"," ");
                temp=temp.replaceAll("\u200C"," ");
                temp=temp.replaceAll("\u200A"," ");
                String[] sentences = file_line.split(" ");

                for(int i=0; i < sentences.length; i++){
                    sentences[i] = sentences[i].replaceAll(" ", "");
                    file.println(sentences[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();

        }


        file.close();


    }


    public static void main(String[] args) throws IOException {
        FileReader f = new FileReader();
        f.writing();
    }
}
