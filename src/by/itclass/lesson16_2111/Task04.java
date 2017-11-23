package by.itclass.lesson16_2111;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task04 {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("task04.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            Pattern pattern = Pattern.compile("['|\"][^'|\"]+['|\"]");

            Matcher matcher =  pattern.matcher(line);


            while (line != null){

                while (matcher.find()){
                    System.out.println(matcher.group());
                }
                line = bufferedReader.readLine();
                if (line != null) {
                    matcher = pattern.matcher(line);
                }
            }


            bufferedReader.close();


        }catch (IOException e){

        }



    }
}
