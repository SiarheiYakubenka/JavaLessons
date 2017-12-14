package by.itclass.lessons21_1412;

//Очередь или хранилище, котрое содержит один объект
public class SimpleQueue {

    private Integer number;
    private volatile boolean isDataWritten = false;//Флаг, указывающий на то, были ли записаны данные
    //volatile перед переменной говорит JVM не заносить в кэш, а всегда брать и оперативной памяти,
    //чтобы избежать ошибок в многопоточной программе



    public  void  put(int newInt) {
        while (isDataWritten);//активное ожидание
       // if(!isDataWritten){
        number = newInt;
            isDataWritten = true;
       // }
    }

    public Integer get() {
        //ждать, если нет числа
        while (!isDataWritten); //активное ожидание
     //   if (isDataWritten){
            isDataWritten = false;
            return number;
       // }else {
        //    return null;
       // }
    }

}
