package by.itclass.lesson16_2111;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task02 {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("c:\\Users\\IT Class\\IdeaProjects\\JavaLessons\\task01.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            Pattern pattern = Pattern.compile("([0-9]{1,3}\\.){3}[0-9]{1,3}");

            Matcher matcher =  pattern.matcher(line);


            while (line != null){

                while (matcher.find()){

                }
                line = bufferedReader.readLine();

            }
            bufferedReader.close();


        }catch (IOException e){

        }



    }

}
