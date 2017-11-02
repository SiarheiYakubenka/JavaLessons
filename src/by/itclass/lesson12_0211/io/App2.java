package by.itclass.lesson12_0211.io;

import java.io.File;
import java.io.IOException;

public class App2 {
    public static void main(String[] args) {

        //Класс, представляющий собой какое-то имя(по этому имени может быть файл на диске или нет)
        File file = new File("C:\\out.properties");

        //Является исполняемым
        System.out.println(file.canExecute());
        //Можно читать?
        System.out.println(file.canRead());
        //Можно писать
        System.out.println(file.canWrite());
        //Длина файла(размер)
        System.out.println(file.length());
        //Существует ли файл
        System.out.println(file.exists());
        //Удаление файла
       //System.out.println(file.delete());

        //Является ли путь абсолютным
        System.out.println(file.isAbsolute());
        //Указывает ли путь на папку
        System.out.println(file.isDirectory());
        //Существует ли путь на файл
        System.out.println(file.isFile());
        //Существует ли файл скрытым
        System.out.println(file.isHidden());

        //Папка в котором этот файл находится
        System.out.println(file.getParent());

        //Вернуть абсолютный путь к этому файлу
        System.out.println(file.getAbsoluteFile());

        File file1 = new File("C:\\out2.properties");
        //Создание пустого файла
        try {
            System.out.println(file1.createNewFile());
        }catch (IOException e){
            e.printStackTrace();
        }






    }
}
