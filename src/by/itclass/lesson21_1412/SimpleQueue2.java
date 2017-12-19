package by.itclass.lesson21_1412;

public class SimpleQueue2 {
    private Integer number;
    private volatile boolean isDataWritten = false;//Флаг, указывающий на то, были ли записаны данные
    //volatile перед переменной говорит JVM не заносить в кэш, а всегда брать и оперативной памяти,
    //чтобы избежать ошибок в многопоточной программе


    //synchronized перед методом - данный метод внутори одного объекта
    //может выполняться только одним потоком
    public synchronized void  put(int newInt) {
        while (isDataWritten){//активное ожидание
             try {
                 wait();
                 //если наше условие не выполнено, то ждать
             }catch (InterruptedException e){

             }
        }
        // if(!isDataWritten){
        number = newInt;
        isDataWritten = true;
        //оповестить поток(и) о том, что можно зайти в синхрнайзд
        notify();
        // }
    }

    //Среди всех synchronized - блоков в объекте может выполняться только один поток
    public synchronized Integer get() {
        //ждать, если нет числа
        //активное ожидание
        while (!isDataWritten){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        //   if (isDataWritten){
        isDataWritten = false;
        notify();
        return number;

        // }else {
        //    return null;
        // }
    }
}
