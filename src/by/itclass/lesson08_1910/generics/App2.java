package by.itclass.lesson08_1910.generics;


import by.itclass.lesson05_0410.Animals.Animal;

public class App2 {
    public static void main(String[] args) {


        Stack<String> s = new Stack<String>(10);

        Stack<Animal> a = new Stack<>(10);

        Pair<String, String> pair = new Pair<>("Hello", "Generics");

        Pair<Integer, Integer> pair2 = new Pair<>(2, 1);

        Integer[] arr = new Integer[]{4, 2, 3};
        ArrGen<Integer> arrGen = new ArrGen<Integer>(arr);

        Integer max = (Integer) arrGen.max();
        Integer min = (Integer) arrGen.min();
        double mean =  arrGen.mean();

        System.out.println("Максимум "+max+"%nМинимум "+min+"%nСреднее "+mean);
    }
}
