package by.itclass.lesson16_2111;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Palindrome {
    static String assertEntirety(String pattern) {
        return "(?<=(?=^pattern$).*)".replace("pattern", pattern);
    }

    public static void main(String[] args) {
        final String PALINDROME =
                "(?x) | (?:(.) add)+ chk"
                        .replace("add", assertEntirety(".*? (\\1 \\2?)"))
                        .replace("chk", assertEntirety("\\2"));


        try {
            FileReader fileReader = new FileReader("task07.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            Pattern pattern = Pattern.compile(PALINDROME);

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
