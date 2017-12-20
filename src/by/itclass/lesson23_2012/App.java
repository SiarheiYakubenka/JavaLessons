package by.itclass.lesson23_2012;

import java.util.concurrent.atomic.AtomicLong;

public class App {
    public static void main(String[] args) {

        final int TASKS_COUNT = 100000;// коль-во последовательностей, кот. нужно сложить

        SumTask[] tasks = new SumTask[TASKS_COUNT];

        AtomicLong fullSum = new AtomicLong(0);

        for (int i = 0; i <  TASKS_COUNT; i++) {
            tasks[i] = new SumTask(i * 1000000, (i + 1) * 1000000, fullSum);
        }

        /*
        //Последовательный вариант
        long time = System.nanoTime();
        for (int i = 0; i < TASKS_COUNT ; i++) {
            tasks[i].run();
        }
        long end_time = System.nanoTime();
        System.out.printf("Время выполнения = %.4f %n", (end_time - time) / 1e9);
        System.out.printf("Сумма  = %d %n", fullSum.get());

*/

        /*
        //Параллельный вариант
        Thread[] threads = new Thread[TASKS_COUNT];
        long time = System.nanoTime();
        for (int i = 0; i < TASKS_COUNT ; i++) {
            threads[i] = new Thread(tasks[i]);
            tasks[i].run();
        }

        for (int i = 0; i < TASKS_COUNT ; i++) {
            try {

                threads[i].join();

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        long end_time = System.nanoTime();
        System.out.printf("Время выполнения = %.4f %n", (end_time - time) / 1e9);
        System.out.printf("Сумма  = %d %n", fullSum.get());
*/
    }
}

//класс нахождения сумы последовательности чисел
class SumTask implements Runnable {

    private int start;
    private int end;
    private AtomicLong fullSum;

    public SumTask(int start, int end, AtomicLong fullSum) {
        this.start = start;
        this.end = end;
        this.fullSum = fullSum;
    }

    @Override
    public void run() {
        long sum = 0;
        for (int i = start; i < end ; i++) {
            sum += i;
        }
        fullSum.addAndGet(sum);
    }
}