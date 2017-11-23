package by.itclass.lesson16_2111;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task05 {
    public static void main(String[] args) {
        TreeSet<String> numberPhones = new TreeSet<>();
        try {

            FileReader fileReader = new FileReader("task05.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            Pattern pattern = Pattern.compile("([+]\\d{3}\\s*\\d{2,3}\\s*)?\\d{1,3}([-]?\\s*\\d{1,3}){2}");

            Matcher matcher =  pattern.matcher(line);


            while (line != null){

                while (matcher.find()){
                    numberPhones.add(matcher.group());
                }
                line = bufferedReader.readLine();
                if (line != null) {
                    matcher = pattern.matcher(line);
                }
            }


            bufferedReader.close();


        }catch (IOException e){

        }

        while (!numberPhones.isEmpty()) {
            System.out.println(numberPhones.pollFirst());
        }

    }
}
