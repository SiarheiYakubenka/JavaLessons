package by.itclass.lesson16_2111;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {

        //Строка представляет собой объект класса String
        //которая лежит в памяти в виде неизменного массива символов
        String string = "Строка";

        //анная конструкция не изменит строку, а создаст новую
        //и поместит ссылку на нее в переменную стринг
        string = string + "!";
        System.out.println(string);

        //онкатенация (сложение) строк
        string = "1" + ", hello";
        System.out.println(string);

        if (string.equals("2, hi")){
            System.out.println("строки равны");
        }else {
            System.out.println("строки не равны");
        }


        //Сравнение строк
        System.out.println("Стол".equals("стол"));
        //Игнорирование больших\маленьких букв
        System.out.println("Стол".equalsIgnoreCase("стол"));

        String sentence = "На столе лежала тарелка. тарелка была очень " +
                "грязной";

        //Сравнение кусков строк
        boolean matches =  sentence.regionMatches(9, "лежала тарелка", 0, 14);
        System.out.print("результат сравнения - ");
        System.out.println(matches);

        //Проверка начала или конца строки
        System.out.println(sentence.startsWith("На полу"));
        System.out.println(sentence.endsWith("грязной"));

        //Поиск подстроки в строке
        //Ф-ция возвращает -1, если подстроки не существует
        //иначе - индекс подстроки(начиная с нуля)
        System.out.println(sentence.indexOf("лежала"));


        System.out.println(sentence.lastIndexOf("тарелка"));
        System.out.println(sentence.indexOf("тарелка"));

        System.out.println("Позиция подстроки в строке");

        int index = 0;
        do {
            index = sentence.indexOf("тарелка", index+1);
            if (index != -1)
            System.out.println(index);
        }while (index != -1);


        //Извлечь подстроку из строки по начальному и конечному индексам
        System.out.println(sentence.substring(5, 10));


        //Простая замена по шааблону - символу
        System.out.println(sentence.replace('а', 'у'));

        //Простая замена по шааблону - строке
        System.out.println(sentence.replaceAll("тарелка", "вилка"));

        //Ф-ция удаления пробелов
        System.out.println("      Привет    ".trim());

        //Ф-ция перевода в большие/маленькие буквы
        System.out.println(sentence.toLowerCase());
        System.out.println(sentence.toUpperCase());

        //Объединение строк с помощбю разделителя (java 8)
        System.out.println(String.join(", ",  "1", "asd", "Петр"));

        //Класс для работы с изменяющимися строками
        StringBuffer buffer = new StringBuffer();

        //Добавить строку в конец буфера
        buffer.append("Привет");
        System.out.println(buffer);

        buffer.append(", мир");
        System.out.println(buffer);

        //Встаавка в произвольную позицию
        buffer.insert(8, "о дивный новый ");
        System.out.println(buffer);


        //Перевернуть строку
        System.out.println(buffer.reverse());

        //Удалить из буфера
        System.out.println(buffer.reverse().delete(10, 17));

        //Заменить символы в буфере
        System.out.println(buffer.replace(10, 14, "чудный"));

        long time = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 100 ; i++) {
            stringBuffer.append(i);
        }
        time = System.nanoTime() - time;

        System.out.println("Время работы  - " + time / 1e9);
        System.out.println(stringBuffer);


        //Работает один-в-один как StringBuffer, но при этом он не защищен
        //в многопоточной среде от модификаций несколькими потоками выпольнения (прогарммами)
        StringBuilder stringBuilder = new StringBuilder();

        //Класс, представляющий собой шаблон регулярного выражения
        Pattern pattern = Pattern.compile("тарелка");

        //Ищет по шаблону
        Matcher matcher =  pattern.matcher(sentence);

        //Осуществляет поиск и возвращает признак, нашел он строку или нет
        boolean found =  matcher.find();
        if (found){
            System.out.println(matcher.group());
        }

        //Цикл поиска с помощью регулярных выражений
        matcher = pattern.matcher(sentence);
        while (matcher.find()){
            System.out.println(matcher.group());
        }

        //Искать оди из символов из множества
        pattern = Pattern.compile("[абвэюя]");
        System.out.println("Поиск маленьких букв");
        pattern = Pattern.compile("[а-я]");
        matcher = pattern.matcher(sentence);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
        pattern = Pattern.compile("[1-9]");

        //"Крышечка" внутри диапозона означает отрицание
        pattern = Pattern.compile("[^a-zA-Z]");

        //Условие коль-ва символов
        pattern = Pattern.compile("[0-9]+");  //один и более раз
        pattern = Pattern.compile("[0-9]*");  //ноль и более раз
        pattern = Pattern.compile("[0-9]?");  //ноль или один раз

        pattern = Pattern.compile("[0-9]{2,5}");  //от двух до пяти раз
        pattern = Pattern.compile("[0-9]{2,}");  //от двух и более раз
        pattern = Pattern.compile("[0-9]{0,5}");  //пять и менее раз
        pattern = Pattern.compile("[0-9]{4}");  //ровно 4 раза

        pattern = Pattern.compile("\\d");  //цифра
        pattern = Pattern.compile("\\D");  //не цифра
        pattern = Pattern.compile("\\s");  //пробел
        pattern = Pattern.compile("\\S");  //не пробел
        pattern = Pattern.compile("\\w");  //цифра, буква, знак подчеркивания
        pattern = Pattern.compile("\\W");  //не цифра, буква, знак подчеркивания

        pattern = Pattern.compile("^(Hello)"); // в начале предложения
        pattern = Pattern.compile("$(Hello)"); // в конце предложения
        pattern = Pattern.compile("(кг|км)"); // или первый или второй пробел
    }
}
