package by.itclass.lesson20_0512;

public class RunnableThread implements Runnable {
    @Override
    public void run() {
        int counter = 0;
        while (true) {
        System.out.println("This is runnable thread operation" + counter++);
    }

    }
}
