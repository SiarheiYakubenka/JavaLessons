package by.itclass.lesson13_0711;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MyFrame extends Frame implements ActionListener {

    private TextArea textArea;

    private  Button button;

    public MyFrame(){

        this.setTitle("Компоненты  AWT");
        this.setSize(640, 480);

        this.addWindowListener(new FrameListener2());


        //Компоновка с пятью позициями(север, юг, запад, восток)
        BorderLayout borderLayout = new BorderLayout();

        this.setLayout(borderLayout);


        //Сеточная компоновка
        //GridLayout gridLayout = new GridLayout(3,3);
        //this.setLayout(gridLayout);

        Label label = new Label();
        label.setText("Класс Label предназначен для хранения текста");
        label.setAlignment(Label.CENTER);
        add(label);


        //Кнопка
        Button button = new Button();
        button.setLabel("Отправить");
        add(button);

        //Флажок (да/нет)
        Checkbox checkbox = new Checkbox();
        checkbox.setLabel("Ананимно");
        checkbox.setState(true); //изменить состояние флажка
        add(checkbox, BorderLayout.SOUTH);


        Checkbox android = new Checkbox("Android");
        Checkbox ios = new Checkbox("iOS");
        //Класс для объеденения нескольких флажков в группу,
        //чтобы выбрать только один вариант
        CheckboxGroup systems = new CheckboxGroup();
        android.setCheckboxGroup(systems);
        ios.setCheckboxGroup(systems);
        add(android);
        add(ios);


        //Однострочное текстовое поле
        TextField textField = new TextField();
        textField.setText("sdf");
        add(textField);

        textField.setEchoChar('*');//на какой символ заменять


        //Многострочное текстовое поле
        TextArea textArea = new TextArea();
        add(textArea, BorderLayout.EAST);

        //Список
        List list = new List();
        list.setMultipleMode(true);//Разрешить выбор нескольких вариантов
        list.add("Первый");
        list.add("Второй");
        list.add("Третий");

        add(list);

        //Компоновка в котрой все элементы идут друг за другом
        //FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        //this.setLayout(flowLayout);//сказать форме, чтобы она упорядочила эл-ты согласно выбранной компановке





        //Заголовок меню
        MenuBar menuBar = new MenuBar();
        //Пункт меню(в загаловочном они рассполог в строчку)
        Menu filemenu = new Menu("Файл");
        MenuItem open = new MenuItem("Открыть");

        //Назнач гор клав для меню

        MenuShortcut shortcut = new MenuShortcut(KeyEvent.VK_0);
        open.setShortcut(shortcut);
        open.addActionListener(this);
        //

        MenuItem save = new MenuItem("Сохранить");
        MenuItem exit = new MenuItem("Выйти");
        filemenu.add(open);
        filemenu.add(save);
        filemenu.add(exit);

        menuBar.add(filemenu);

        this.setMenuBar(menuBar);

        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g){

        g.setColor(Color.RED);
        g.drawOval(10, 10, 200, 200);
    }

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        textArea.append ("Выбран пункт меню 'открыть'\n");
    }
}
