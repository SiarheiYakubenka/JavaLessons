package by.itclass.lesson20_0512;

public class MyThread extends Thread {
    @Override
    public void run() {
        int counter = 0;
        while (true) {
            System.out.println("This is thread operation" + counter++);
        }
    }
}
