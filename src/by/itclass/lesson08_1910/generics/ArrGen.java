package by.itclass.lesson08_1910.generics;


import com.sun.org.omg.CORBA.ParDescriptionSeqHelper;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrGen<T extends Number> implements Stats {

    private T[] array;

    public ArrGen(T array[]) {
        this.array =  array;
    }

    @Override
    public double mean() {
        double m = 0;
        for (T i:
             array) {
            m += i.doubleValue();
        }
        return m/(array.length-1);
    }

    @Override
    public T max() {
        Arrays.sort(array);
        return array[array.length-1];
    }

    @Override
    public T min() {
        Arrays.sort(array);
        return array[0];
    }
}
