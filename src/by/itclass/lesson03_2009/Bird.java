package by.itclass.lesson03_2009;

//Класс птица(Bird)
public class Bird {

    //Количество созданных птиц за работу программы
    private static int birdCount = 0;

    public static int birdCount(){
        return birdCount;
    }

    //Статическое поле
    public static String birdKind = "Попугаи";

    //Объявление поля(переменной)"имя" типа String
    String name;//= null

    //Приватное поле. Доступ только внутри класса
    private int year;

    //Метод класса, ничего не возвращает и не принимает
    void sayHello(){

        System.out.println("Привет, я "+name);
    }

    //Перегруженный метод sayHello
    void sayHello(String to){

        System.out.println("Привет, "+to+", я "+name);
    }

    //Метод класса прингимающий параметры
    void  rename(String name){

        this.name = name;
    }

    //Конструктор без параметров
    Bird(){
        name = "Птица";
        year = 0;
        birdCount++;
    }

    //Перегруженный конструктор
    Bird (String name){

        this.name = name;
        year = 0;
        birdCount++;
    }

    //Публичный метод, который можно вызвать в любой точке программы
    public int getYear() {
        return year;
    }

    //Объявление константы
    final int WINGS_COUNT = 2;

    //Статическая константа(одна на весь класс)
    static final int BIRD_TYPES = 4;

    //Пример метода с переменным количеством параметров
    public  static int sum(int... array){

        int sum = 0;

        for (int i = 0; i <array.length ; i++) {
            sum+=array[i];
        }
        return sum;
    }

    public  static int sum2(int[] array){

        int sum = 0;

        for (int i = 0; i <array.length ; i++) {
            sum+=array[i];
        }
        return sum;
    }

    //Метод выводит строку
    @Override
    public String toString() {
        return "Птица "+name +", "+year+", "+"лет";
    }

    @Override
    public boolean equals(Object obj) {

        //Проверяем не передан ли был пустой объект
        if (obj == null){
            return  false;
        }
        //Узнаем, сравниваем объект с тем же классом
        if (obj.getClass() != Bird.class) {
            return  false;
        }
        //Значит объект является типом Bird
        Bird other = (Bird)obj;

        if (this.name.equals(other.name) && this.year == other.year){
            return true;
        }else {
            return false;
        }
    }
}
