package by.itclass.lesson06_1110.exceptions;

/**
 * Created by IT Class on 11.10.2017.
 */
public class Interval {
    private  final  int a;
    private  final  int b;
    public Interval(int a, int b){
        if(a==b){
            throw  new IllegalArgumentException("Точки интервала не могут быть равны");
        }else  if (a>b){
            throw new IllegalArgumentException("Точка а не может быть больше b");
        }
        this.a = a;
        this.b = b;
    }
}
