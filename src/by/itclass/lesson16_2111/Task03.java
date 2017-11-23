package by.itclass.lesson16_2111;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task03 {
    public static void main(String[] args) {
        StringBuilder newFile = new StringBuilder();
        StringBuffer newline = new StringBuffer();
        File file = new File("task03.txt");

        try {

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            Pattern pattern = Pattern.compile("([^.!?]+[.!?])");

            Matcher matcher =  pattern.matcher(line);


            while (line != null){

                while (matcher.find()){
                    newline.append(matcher.group()).reverse();
                    newFile.append(newline);
                    newline.setLength(0);
                }
                newFile.append("\n");
                line = bufferedReader.readLine();
                if (line != null) {
                    matcher = pattern.matcher(line);
                }

            }
            bufferedReader.close();


        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            FileWriter fileWriter = new FileWriter("task03_out.txt");
            fileWriter.write(String.valueOf(newFile));
            fileWriter.flush();
            fileWriter.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
