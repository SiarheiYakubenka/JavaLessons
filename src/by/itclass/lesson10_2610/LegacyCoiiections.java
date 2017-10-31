package by.itclass.lesson10_2610;

import by.itclass.lesson08_1910.generics.Stack;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;

public class LegacyCoiiections {
    public static void main(String[] args) {

        //Устаревший класс, необходимо его заменять на Map(HashMap)
        Dictionary<String, String> dictionary = new Hashtable<>();
        dictionary.put("Петров", "+375293242132");
        dictionary.put("Иванов", "+3752932231132");

        //Vector - расшияемый массив (устаревший), заменять на ArrayList
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(0,2);
        for (Integer i : vector) {
            System.out.println(i);
        }

        //Stack<Integer> integerStack = new Stack<>();

        Properties properties = new Properties();
        properties.put("width", "800");
        properties.put("higth", "600");
        try {
            properties.store(new FileWriter("C:/out.properties"), "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
