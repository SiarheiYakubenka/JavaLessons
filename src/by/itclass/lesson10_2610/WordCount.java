package by.itclass.lesson10_2610;

import java.util.*;

public class WordCount {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        //слова из строки
        String[] words = line.split(" ");

        Set<String> uniqueWords = new TreeSet<>();
        for (String word: words
             ) {
            uniqueWords.add(word);
        }

        System.out.printf("Все слова в тексте");
        for (String word: uniqueWords
             ) {
            System.out.println(word);
        }

        //как посчитать кол-во слов
        Map<String, Integer> counts = new TreeMap<>();

        for (String word:
             words) {
            if (!counts.containsKey(word)){
                counts.put(word, 1);
            }else  {
                int count = counts.get(word);
                counts.put(word, count + 1);
            }
        }
        System.out.printf("Количество слов в тексте");
        for (Map.Entry<String, Integer> entry: counts.entrySet()
                ) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
