package by.itclass.lessons21_1412;

//Задача сложения элементов части массива
public class SumTask implements  Runnable{

    private int[] array; //ссылка на нужный массив
    private int start; //начало массива
    private int end;  //конец массива (не включая последий)

    public long sum;

    public SumTask(int[] array, int start, int end) {
        if(array == null){
            throw new IllegalArgumentException();
        }

        if (start < 0 || start >= array.length){
            throw new IllegalArgumentException();
        }
        if (start < 0 || end > array.length){
            throw new IllegalArgumentException();
        }


        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        sum = 0;
        //Нахордим сумму куска массива
        for (int i = start; i < end; i++){
            sum += array[i];
        }
    }
}
