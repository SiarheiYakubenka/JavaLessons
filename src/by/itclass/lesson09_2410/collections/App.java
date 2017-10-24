package by.itclass.lesson09_2410.collections;


import by.itclass.lesson05_0410.Figures.Circle;
import by.itclass.lesson05_0410.Figures.Figure;
import by.itclass.lesson05_0410.Figures.Rectangle;
import by.itclass.lesson05_0410.Figures.Triangle;

import java.security.SecureRandom;
import java.util.*;

public class App {
    public static void main(String[] args) {

        //Collection - интерфейс, котроый реализует все коллекции
        //Set - колекции, у котрых все эл-ты уникальные

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Iterator<Integer> iterator = list.iterator();
        while ( iterator.hasNext()){
            int i = iterator.next();
            System.out.println(i);
        }

//Объект после двоеточия обязан реализовывать интерфейс Iterable
        for (Integer i: list) {
            System.out.println(i);
        }

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(1);
        hashSet.add(2);
        System.out.println("Содержимое HashSet");
        for (Integer i : hashSet
             ) {
            System.out.println(i);
        }

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i <100 ; i++) {
            treeSet.add(i%10);
        }
        System.out.println("Содержимое TreeSet");
        for (Integer i :treeSet.headSet(3)
             ) {
            System.out.println(i);
        }


        //List - это интерфейс коллекции, в которой все эл-ты распологаются друг за другом и точно
        //знают распложение следующего и предыдущего эл-та
        //ArrayList -список (List), построенный на массиве
        List<Integer> integers = new ArrayList<>();
        //LinkedList -список (List), построенный на массиве
        List<Integer> integers2 = new LinkedList<>();

        for (int i = 0; i < 50 ; i++) {
            integers.add(i%5);
        }
        System.out.println("Содержимое ArrayList");
        for (Integer i :
             integers) {
            System.out.println(i);
        }

        double random = Math.random();//[0;1]

        Random random1 = new Random();
        random1.nextInt(100);//генерация от 0 до 100(не включая)
        SecureRandom random2 = new SecureRandom();

        //Очередь с приорететами
        //Эл-ты добавляются в произвольном порядке, а извлекаются в порядке возрастания
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < 50 ; i++) {
            priorityQueue.add(random1.nextInt(100));
        }
        System.out.println("Содержимое PriorityQueue");
        for (Integer i :priorityQueue) {
            System.out.println(i);
        }
        System.out.println("Содержимое PriorityQueue извлеченное с помощью стандартных операций");

        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }


        PriorityQueue<Figure> figure = new PriorityQueue<>(new FigureAreaComparator());
        for (int i = 0; i < 50 ; i++) {
            int fig = random1.nextInt(3);
            switch (fig){
                case 0:
                    double radius = random1.nextInt(100)+1;
                    figure.add(new Circle(radius));
                    break;
                case 1:
                    double a = random1.nextInt(100)+1;
                    double b = random1.nextInt(100)+1;
                    double c = random1.nextInt(100)+1;

                    figure.add(new Triangle(a, b, c));
                    break;
                case 2:
                     a = random1.nextInt(100)+1;
                     b = random1.nextInt(100)+1;

                    figure.add(new Rectangle(a, b));
                    break;
            }
        }
        while (!figure.isEmpty()){
            Figure f = figure.poll();
            System.out.println(f+"площадь"+f.getArea());
        }


        //Collections.sort(); - сортировка списка
        //Collections.binarySearch(); - бинарный поиск
        //Collections.shuffle(); - перемешать все элементы
    }
}
