package by.itclass.lesson22_1912;

public class App {
    public static void main(String[] args) {
        PQueue<Integer> queue = new PQueue<>(10);

        new  Thread(new Producer(queue, 0, 10)).start();
        new  Thread(new Producer(queue, 20, 30)).start();

        new Thread(new Consumer(queue)).start();
    }
}

class Producer implements Runnable {

    private PQueue<Integer> queue;
    private int start;
    private int end;

    public Producer(PQueue<Integer> queue, int start, int end) {
        this.queue = queue;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            queue.put(i);
        }
    }
}

class Consumer implements Runnable {

    private  PQueue<Integer> queue;

    public Consumer(PQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            Integer i = queue.get();
            if (i != null ){
                System.out.println(i);
            }else {
                break;
            }
        }
    }
}