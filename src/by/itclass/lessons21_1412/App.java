package by.itclass.lessons21_1412;

import java.util.Random;

public class App {
    public static void main(String[] args) {


        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        long sumSeq = sumSequential(array);
        long sumPar = sumParallel(array, 2);

        System.out.println("Посл - " + sumSeq);
        System.out.println("Парал - " + sumPar);

        assert  sumSeq == 55;

        assert sumPar == sumSeq;


        int[] randomArray = generatorArray(1_00_000_000);

        for (int i = 1; i <=10 ; i++) {
            System.out.println("Количество птоков = " + i);
            long time = System.nanoTime();
            long sum = sumParallel(randomArray, i);

            long time2 = System.nanoTime();
            System.out.println(sum);
            System.out.println("Время = " + (time2 - time) / 1e9);
        }


    }
        public static int[] generatorArray(int size){
            Random random = new Random();


        int[] array = new int[size];
            for (int i = 0; i < size ; i++) {
                array[i] = random.nextInt(10000);
            }
            return array;
    }

    //Последовательное вычисление суммы
    public static long sumSequential(int[] array){
        long sum = 0;
        for (int x: array) {
            sum += x;
        }
        return sum;
    }

    //Последовательное вычисление суммы
    public static long sumParallel(int[] array, int threads_count){

        Thread[] threads = new Thread[threads_count];
        SumTask[] tasks = new SumTask[threads_count];

        int n = array.length / threads_count; //размер куска массива на поток


        for (int i = 0; i < threads_count ; i++) {
            int start = i * n;
            int end = (i + 1) * n;
            if (i == threads_count - 1){
                end = array.length;
            }
            tasks[i] = new SumTask(array, start, end);
            threads[i] = new Thread(tasks[i]);
            threads[i].start();
        }

        //join -  ф-ция ожидания потока
        for (Thread th : threads) {
            try {
            th.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        long sum = 0;
        for (SumTask t : tasks) {
            sum += t.sum;
        }


        return sum;
    }
}

