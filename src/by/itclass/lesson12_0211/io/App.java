package by.itclass.lesson12_0211.io;

import org.omg.CORBA.portable.OutputStream;

import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;

public class App {
    public static void main(String[] args) {

        //Поток, который читает байты в программу из внешней среды
        InputStream inputStream = null;


        //Поток, который читает байты из программы
        OutputStream outputStream = null;

        //Поток, который читает символы в программу из внешней среды
        Reader reader = null;


        //Поток, который читает символы из программы
        Writer writer = null;
    }
}
