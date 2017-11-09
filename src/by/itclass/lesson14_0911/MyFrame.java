package by.itclass.lesson14_0911;

import javax.swing.*;

public class MyFrame extends JFrame {

    public  MyFrame(){

        setTitle("Окно на Swing");
        setSize(640, 480);

        //Установка значения-опции, что делать при нажатии кнопки закрыть у окна
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
