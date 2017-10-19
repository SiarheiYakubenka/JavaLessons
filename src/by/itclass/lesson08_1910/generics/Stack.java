package by.itclass.lesson08_1910.generics;


public class Stack <T> {

    private T[] array;
    private int pointer;

    public  Stack (int size){
        if (size <= 0){
            throw new IllegalArgumentException("Стек должен быть положительного размера");
        }
        this.array = (T[]) new Object[size];
        this.pointer = 0;
    }

    //Добовление элемента в стек
    public void  push(T c){
        if (pointer == array.length){
            throw new IllegalStateException("Стек переполнен");
        }
        this.array[pointer] = c;
        pointer++;
    }
    //Забрать элемент из стека
    public  T pop() {
        if (pointer ==0){
            throw  new IllegalStateException("Стек пуст");
        }
        this.pointer--;
        return this.array[pointer];
    }

    //Забрать элемент из стека(без удаления)
    public  T peek(){
        if (pointer == 0){
            throw new IllegalStateException("Стек пуст");
        }
        return this.array[pointer-1];
    }

    //Размер стека

    public int size() {
        return pointer;
    }
}

class  Pair<X, Y>{
    private  X x;
    private Y y;

    public Pair(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public X getX() {
        return x;
    }

    public Y getY() {
        return y;
    }
}
//Можно наложить ограничения на тип обобщения (с помощью ключевого слова extends)
interface Stats<T extends Number>{
    double mean();
    T max();
    T min();
}

class  GenericClass<T>{

    private  int x;

    //Обобщенный конструктор
    public <K> GenericClass(){
        K k1 = null;
    }

    public <E> void  doAction(E action){
        System.out.println("Doing "+action);
    }
}
