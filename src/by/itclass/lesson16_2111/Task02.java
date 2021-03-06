package by.itclass.lesson16_2111;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task02 {
    public static void main(String[] args)  {

        StringBuilder newFile = new StringBuilder();
        File file = new File("task02.txt");

        try {

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();




            while (line != null){

                line =  line.replaceAll("([0-9]{1,3}\\.){3}[0-9]{1,3}", "[засекречено]");
                newFile.append(line);
                newFile.append("\r\n");
                line = bufferedReader.readLine();

            }
            bufferedReader.close();


        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            FileWriter fileWriter = new FileWriter("task02_out.txt");
            fileWriter.write(String.valueOf(newFile));
            fileWriter.flush();
            fileWriter.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
