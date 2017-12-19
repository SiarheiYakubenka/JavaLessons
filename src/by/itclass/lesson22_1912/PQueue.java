package by.itclass.lesson22_1912;

//очередь с поддержкой параллельного доступа

import java.util.LinkedList;
import java.util.Queue;

public class PQueue<T> {

    private Queue<T> data;
    private volatile int maxSize;// максимальный размер очереди (volatile будет храниться в оперативной памяти, а не в кэше процессора)

    public PQueue(int maxSize) {
        this.data = new LinkedList<>();
        this.maxSize = maxSize;
    }

    //Взять из очереди
    public synchronized T get(){
        while (this.data.isEmpty()){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        T element = this.data.poll();
        notify();
        return element;
    }

    //Положить в очередь
    public synchronized void put (T item) {
        while (this.data.size() == maxSize) {
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.data.add(item);
        notify();
    }
}
