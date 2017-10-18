package by.itclass.lesson03_2009;

public class App {
    public static void main(String[] args) {
        //Объявление ссылки на обьект класса Bird
        //Ссылка не инициализирована(ее использовать нельзя)
        Bird bird;

        //Установка ссылки на null(тсутствие объекта по ссылке)
        bird = null;

        //Создание объекта класса Bird
        new Bird();

        //Создание объекта класса Bird и получение ссылки на него
        bird = new Bird();

        //Обьявляем новую ссылку и устанавливаем ее на тот объект, на который указывала ссылка bird
        Bird bird1 = bird;

        //Ссылки указывают на один объект при присваивании, а переменные типа
        //byte, int, short, long, float, double, char, boolean копируются при присваивании


        //Получение поля name бъекта bird
        System.out.println(bird.name);


        bird.name = "Кеша";


        System.out.println(bird.name);

        //Вызов метода объекта
        bird1.sayHello();

        //Вызов метода объекта с параметрами
        bird.rename("Аристарх");
        System.out.println(bird.name);

        //Вызов перегруженного метода
        bird1.sayHello("Михаил");

        //Создание через конструктор
        Bird bird2 = new Bird("Синица");
        System.out.println(bird2.name);
        bird2.sayHello();

        //Вызов публичного метода класса и вывод его на экран
        System.out.println(bird2.getYear());

        //Обращение к приватной переменной запрещено
        //System.out.println(bird2.year);

        //Два способа обращения к статической переменной
        //1.Через название класса
        System.out.println(Bird.birdKind);
        //2.Через объект этого класса
        System.out.println(bird2.birdKind);

        System.out.println(Bird.birdCount());

        //Вызов метода с переменным коичеством параметров
        System.out.println(Bird.sum());
        System.out.println(Bird.sum(1));
        System.out.println(Bird.sum(1, 2));
        System.out.println(Bird.sum(3, 4, 5, 6, 7));

        //Вызов метода с массивом
        System.out.println(Bird.sum2(new int[0]));
        System.out.println(Bird.sum2(new int[]{1}));
        System.out.println(Bird.sum2(new int[]{1, 2}));
        System.out.println(Bird.sum2(new int[]{3, 4, 5, 6, 7}));

        //Класс объект - предок всех классов java
        Object object = new Object();
        object.toString();//методод перевода объекта в строку

        System.out.println(bird);


        //Проверка сравнений
        System.out.println(bird.equals(null));
        System.out.println(bird.equals("Строка"));
        System.out.println(bird.equals(bird));
        System.out.println(bird.equals(bird1));
        System.out.println(bird.equals(bird2));


    }
}
