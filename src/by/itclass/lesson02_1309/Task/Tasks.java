package by.itclass.lesson02_1309.Task;


import java.util.Scanner;

public class Tasks {

   static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //task01();
        //task02();
        //task03();
        task0401();

    }

    public static void  task01 () {


        System.out.print("Введите размер массива: ");
        int n = Integer.parseInt(scanner.nextLine());

        double[] array = new double[n];
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Введите [%d] элемент массива: ", i + 1);
            array[i] = Double.parseDouble(scanner.nextLine());
        }

        System.out.println("Исходный массив:");
        for (double i : array){
            System.out.print(i+"\t");
        }

        System.out.println();
        System.out.println("Введите номер э-та, котроый нужно увеличить на 10%: ");
        int j = Integer.parseInt(scanner.nextLine());
        array[j-1] +=array[j-1]*0.1;

        System.out.println("Полученный массив:");
        for (double i : array){
            System.out.print(i+"\t");
        }

    }

    public static void task02 () {

        System.out.println("Введите число, которое нужно превратить в массив");
        String number = scanner.nextLine();

        char[] str = number.toCharArray();
        int[] array = new int[str.length];

        for (int i = 0 ;i<str.length; i++){

            array[i] = (int)(str[i] - '0');
        }

        System.out.println("Полученный массив:");
        System.out.print("[");
        for (int i=0;i<array.length;i++) {

            if(i!=array.length-1)
            System.out.print(array[i]+",");
            else
                System.out.print(array[i]+"]");

        }


    }

    public static void task03(){

        float t;

        System.out.println("Введите расстояние до места назначения в км");
        float n = Float.parseFloat(scanner.nextLine());

        while (true) {
            System.out.println("Введите время за которое нужно доехать в ч");
            t = Float.parseFloat(scanner.nextLine());
            if(t!=0) break;
            else System.out.println("Попробуйте еще раз");
        }

        float v = n/t;

        System.out.println("Скорость "+v+" км\\ч");


    }

    public static float task04(float zpInHour, int hours){

        float week;

        if (hours<=40){

            week=zpInHour*hours;

        }else {

            week=zpInHour*40+(1.5f*zpInHour*(hours-40));
        }
        return week;

    }

    public static void task0401(){

        float zpInHour;
        int hours;

      while (true) {
          System.out.println("Введите зарплату в час");
          zpInHour = Float.parseFloat(scanner.nextLine());
          if (zpInHour>=8.0f) break;
          else System.out.println("Зарплата не может быть меньше 8 долларов в час");
      }

        while (true) {
            System.out.println("Введите количество проработаных часов");
            hours = Integer.parseInt(scanner.nextLine());
            if (hours<=60) break;
            else System.out.println("Работник не может работать больше 60 часов в неделю");
        }

       System.out.println("Работник зарабатывает в неделю $"+ task04(zpInHour, hours));

    }


}
