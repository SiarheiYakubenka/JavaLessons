package by.itclass.lesson22_1912;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookApp {
    public static void main(String[] args) {

        AtomicInteger fileParserCount = null;//безопасно работает в нескольких потоках
        AtomicInteger splittersCount = null;

        Map<String, Integer> wordsCount = new TreeMap<>();
        PQueue<String> lineQueue = new PQueue<>(1000);
        PQueue<String> wordsQueue = new PQueue<>(1000);

        File[] files = new File("novels/").listFiles();

        fileParserCount = new AtomicInteger(files.length);

        for (File f: files) {
            new Thread(new FileParser(f, lineQueue, fileParserCount)).start();

        }

        splittersCount = new AtomicInteger(2);

        for (int i = 0; i < 2 ; i++) {
            new Thread(new SentenceSplitter(lineQueue, wordsQueue));
        }

        Thread[] counters = new Thread[2];
        for (int i = 0; i < counters.length ; i++) {
            counters[i] =  new Thread(new WordsCounter(wordsQueue, wordsCount));
            counters[i].start();
        }

        for (int i = 0; i < counters.length; i++) {
            try {
                counters[i].join();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Содержимое словаря");
        for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}

class FileParser implements  Runnable {

    private PQueue<String> lineQueue;
    private File file;
    private  AtomicInteger fileParserCount;

    public FileParser(File file, PQueue<String> lineQueue, AtomicInteger fileParserCount) {
        this.lineQueue = lineQueue;
        this.file = file;
        this.fileParserCount = fileParserCount;
    }

    @Override
    public void run() {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            while (line != null) {
                lineQueue.put(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class  SentenceSplitter implements Runnable {
    private PQueue<String> lineQueue;

    private PQueue<String> wordsQueue;

    public SentenceSplitter(PQueue<String> lineQueue, PQueue<String> wordsQueue) {
        this.lineQueue = lineQueue;
        this.wordsQueue = wordsQueue;
    }

    @Override
    public void run() {

        Pattern pattern = Pattern.compile("[a-zA-Zа-яА-Я\\-]+");

        while (true) {
            String line = lineQueue.get();
            if (line != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    wordsQueue.put(matcher.group());
                }
            }
        }
    }
}

class WordsCounter implements Runnable {

    private PQueue<String> wordsQueue;
    private Map<String, Integer> words;

    WordsCounter(PQueue<String> wordsQueue, Map<String, Integer> words) {
        this.wordsQueue = wordsQueue;
        this.words = words;
    }

    @Override
    public void run() {
        while (true) {
            String word = wordsQueue.get();
            if (word != null) {
                if (!words.containsKey(word)){
                    words.put(word, 1);
                }else  {
                    Integer count = words.get(word);
                    words.put(word, count + 1);
                }
            }
        }
    }
}