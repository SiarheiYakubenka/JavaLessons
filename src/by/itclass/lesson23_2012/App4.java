package by.itclass.lesson23_2012;

import java.util.Random;
import java.util.concurrent.RecursiveTask;

public class App4 {
    public static void main(String[] args) {

        Random r = new Random();


        int ASIZE = 1_000_000;
        int BOUND = 10000;


        int[] array = new int[ASIZE];

        for (int i = 0; i < ASIZE ; i++) {
            array[i] = r.nextInt(BOUND);
        }
    }
}

//ForkJoinPool - класс, который управляет потоками
//ForkJoinTask - класс задачи, дополняемой с помощью библиотеки
//RecursiveAction
//RecursiveTask<V>


class SearchTask extends RecursiveTask<Integer> {


    public static final int THRESHOLD =1000;

    private int[] array;
    private int start;
    private int end;
    private int value;

    public SearchTask(int[] array, int start, int end, int value) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.value = value;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD){
            for (int i = start; i <  end; i++) {
                if (array[i] == value)
                    return i;
            }
            return -1;
        }

        int mid = (start + end) / 2;

        SearchTask task1 = new SearchTask(array, start, mid, value);
        SearchTask task2 = new SearchTask(array, mid, end, value);

        task1.fork();
        task2.fork();

        int i1 = task1.join();
        int i2 = task2.join();

        if (i1 == -1 && i2 == -1) {
            return i1;
        }else if (i1 == -1){

        }
        return null;
    }
}