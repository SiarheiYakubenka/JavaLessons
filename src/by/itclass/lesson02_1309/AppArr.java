package by.itclass.lesson02_1309;

public class AppArr {
    public static void main(String[] args) {

        int[] array; //объявление ссылки на массив чисел
        array = new int[100]; //создание массива из 100 чисел и получение ссылки на него

        array = new int[]{1, 19, -2, 23}; //массив из четырех чисел

        array[0] = 1;                   //запись в ячейку
        System.out.println(array[1]); //чтение и вывод на экран
        System.out.println(array.length);//длина массива(в элементах)

        for (int i = 0; i < array.length; i++) {

            System.out.println(array[i]);
        }
        //ненадежное создание

        int height = 5;
        int width = 5;
        int[] square = new int[height * width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                square[i * width + j] = 10;
            }

        }


        //двумерный массив
        int[][] sq = new int[5][5];//явное указание размеров массива
        for (int i = 0; i < sq.length; i++) {
            for (int j = 0; j < sq[i].length; j++) {


                System.out.println(i + "," + j + " = " + sq[i][j]);
            }
        }

        //трехмерный массив
        int[][][] ar = new int[1][2][3];



        //зубчатые массивы
        int[][] jaggedI = new int[4][]; //матрица с 4 строками
        for (int i = 0; i<jaggedI.length; i++){
            jaggedI[i] = new  int[10-i];
        }

        System.out.println("Зубчатый массив");

        for (int i = 0; i< jaggedI.length; i++){
            for (int j = 0; j<jaggedI[i].length;j++ ){

                System.out.printf("%d, %d = %d\n", i, j, jaggedI[i][j]);

            }
        }

        //Строка
        String s = "Строка";
        int s_len = s.length();//ф-ция возвращает длину строки
        for (int i =0 ; i < s_len; i++){
            System.out.println(s.charAt(i));
        }

        System.out.println(s+" дополнение");// строки можно складывать

        s.concat("Дополнение");// то же, что и сложение
        System.out.println(s.contains("тро"));//содерится ли подстрока
        System.out.println(s.contains("тор"));

        int k = s.indexOf("тро"); //первое вхождение в строку
        s.lastIndexOf("тро"); //последнее вхождение в строку

        s.indexOf("тро", k);//первое вхождение, начиная с k эл-та




    }
}
