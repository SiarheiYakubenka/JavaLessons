package by.itclass.lesson21_1412;

public class App2 {

    public static void main(String[] args) {

        SimpleQueue2 queue = new SimpleQueue2();

        //Создание задачи-поставщика
        new Thread(new Producer(queue), "P").start();
        //Создание залачи-потребителя
        new Thread(new Consumer(queue), "C").start();

    }
}
//поставщик
class Producer implements Runnable {


    private SimpleQueue2 queue;

    public Producer(SimpleQueue2 queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10_000; i++) {
            queue.put(i);
        }
    }
}

//потребитель
class Consumer implements Runnable {

    private SimpleQueue2 queue;

    public Consumer(SimpleQueue2 queue) {
        this.queue = queue;
    }

    //тысячу раз берем числа из очереди и выводи на экран
    @Override
    public void run() {
        for (int i = 0; i < 10_000; i++) {
            System.out.println(queue.get());
        }
    }
}