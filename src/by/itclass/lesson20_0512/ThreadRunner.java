package by.itclass.lesson20_0512;

public class ThreadRunner {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
       thread.start();

        Thread runnableThread = new Thread(new RunnableThread());
        runnableThread.start();
     //   int counter = 0;
    //    while (true) {
    //        System.out.println("This is general thread operation" + counter++);
  //  }
}}
