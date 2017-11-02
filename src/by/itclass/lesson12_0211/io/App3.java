package by.itclass.lesson12_0211.io;

import java.io.File;

public class App3 {
    public static void main(String[] args) {

        File folder = new File("C:\\Program Files");

        //Метод возвращает массив строк- названий файлов, содержащихся в данной папке
        String[] filenames = folder.list();
        for (String  filename : filenames){
            System.out.println(filename);
        }

        //Метод возвращает массив файлов- названий файлов, содержащихся в данной папке
        File[] files = folder.listFiles();
        for (File  file : files){
            System.err.println(file.getName());
        }

    }
}
