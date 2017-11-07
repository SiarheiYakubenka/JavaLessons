package by.itclass.lesson13_0711;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class App {
    public static void main(String[] args) {

        //Основной класс графических приложений, представляет собой окно
        Frame frame = new Frame();

        frame.setTitle("Окно на AWT");// метод утсановки загаловка окна
        frame.setSize(640, 480); // метод задания размеров
        frame.setVisible(true);//показать, скрыть окно

        //добавляем к окну слушателя
        frame.addWindowListener(new FrameListener2());



    }

}     /*
        Класс - слушаетль событий
*/
    class FrameListener implements WindowListener{

      @Override
      public void windowOpened(WindowEvent e) {
          System.out.println("Окно открыто");

      }

      @Override
      public void windowClosing(WindowEvent e) {
          //Возвращает окно, явлюющееся источником событий
          e.getWindow().dispose();
           System.out.println("Окно пытаются закрыть");

      }

      @Override
      public void windowClosed(WindowEvent e) {
           System.out.println("Окно закрыто");
      }

      @Override
      public void windowIconified(WindowEvent e) {
          System.out.println("Окно свернуто");
      }

      @Override
      public void windowDeiconified(WindowEvent e) {
          System.out.println("Окно развернуто");
      }

      @Override
      public void windowActivated(WindowEvent e) {
          System.out.println("Окно активированно");
      }

      @Override
      public void windowDeactivated(WindowEvent e) {
          System.out.println("Окно деактивировано");
      }
  }

    class  FrameListener2 extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            e.getWindow().dispose();
        }
    }