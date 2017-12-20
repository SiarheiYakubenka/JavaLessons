package by.itclass.lesson23_2012;

import java.util.EmptyStackException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class App2 {
    public static void main(String[] args) {

        final int TASKS_COUNT = 100000;// коль-во последовательностей, кот. нужно сложить

        SumTask[] tasks = new SumTask[TASKS_COUNT];

        AtomicLong fullSum = new AtomicLong(0);

        for (int i = 0; i < TASKS_COUNT; i++) {
            tasks[i] = new SumTask(i * 1000000, (i + 1) * 1000000, fullSum);
        }


        long time = System.nanoTime();

        Executor executor = null;
        ExecutorService service = null;





        int procesorCount = Runtime.getRuntime().availableProcessors();

        //service = Executors.newSingleThreadExecutor();
        //service =Executors.newFixedThreadPool(procesorCount);
        //service = Executors.newCachedThreadPool();//Если в очереди отсутствуют потоки, то они создаются с нуля, иначе переиспользуются

        service = Executors.newWorkStealingPool();// Если задача начало что-то ждать(synhronised, wait), то этот исполнитель перекинет поток на другую задачу


        Future<?>[] futures = new Future[TASKS_COUNT];

        for (int i = 0; i < TASKS_COUNT; i++) {
            futures[i] = service.submit(tasks[i]);
        }

        for (int i = 0; i < TASKS_COUNT; i++) {
            try {
                futures[i].get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }




        long end_time = System.nanoTime();
        System.out.printf("Время выполнения = %.4f %n", (end_time - time) / 1e9);
        System.out.printf("Сумма  = %d %n", fullSum.get());


        service.shutdown();
    }
}
