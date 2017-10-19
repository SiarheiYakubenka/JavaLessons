package by.itclass.lesson08_1910.generics;


import by.itclass.lesson05_0410.Animals.Animal;

public class App2 {

    Stack<String> s = new Stack<String>(10);

    Stack<Animal> a = new Stack<>(10);

    Pair<String, String>  pair = new Pair<>("Hello", "Generics");

    Pair<Integer, Integer> pair2 = new Pair<>(2,1);


}
