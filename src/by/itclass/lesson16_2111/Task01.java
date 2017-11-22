package by.itclass.lesson16_2111;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task01 {
    public static void main(String[] args) {
        int sum = 0;
        try {
            FileReader fileReader = new FileReader("task01.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            Pattern pattern = Pattern.compile("^(\\d+\\s)|\\s\\d+\\s|\\s\\d+$|\\s\\d+,");

            Matcher matcher =  pattern.matcher(line);


            while (line != null){

                while (matcher.find()){
                    sum+= Integer.parseInt(matcher.group().trim());
                }
                line = bufferedReader.readLine();
                if (line != null) {
                    matcher = pattern.matcher(line);
                }
            }


            bufferedReader.close();


        }catch (IOException e){

        }

        System.out.println(sum);


    }
}
