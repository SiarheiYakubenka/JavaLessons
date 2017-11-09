package by.itclass.lesson14_0911;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicToolBarUI;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class NotepadFrame extends JFrame implements ActionListener{

    private JMenuBar mainMenu;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private File openedFile = null;
    private boolean textModified = false;

    public NotepadFrame(){
        this.setTitle("Блокнот на  Swing");
        this.setSize(640, 480);
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addWindowListener(new NotepadFrameAdapter());

        this.setLayout(new BorderLayout());

        mainMenu = new JMenuBar();
        JMenu fileMenu = new JMenu("Файл");
        mainMenu.add(fileMenu);
        JMenuItem openMenu  = new JMenuItem("Открыть");
        openMenu.setName("open");
        openMenu.addActionListener(this);
        JMenuItem saveMenu  = new JMenuItem("Сохранить");
        saveMenu.setName("save");
        saveMenu.addActionListener(this);
        JMenuItem closeMenu  = new JMenuItem("Закрыть");
        closeMenu.setName("close");
        closeMenu.addActionListener(this);
        JMenuItem exitMenu  = new JMenuItem("Выйти");
        exitMenu.setName("exit");
        exitMenu.addActionListener(this);
        fileMenu.add(openMenu);
        fileMenu.add(saveMenu);
        fileMenu.add(closeMenu);
        fileMenu.add(exitMenu);

        JMenu optionMenu = new JMenu("Настройки");
        JCheckBoxMenuItem wordWrapMenu = new JCheckBoxMenuItem("Перенос по словам");
        wordWrapMenu.setName("wordWrap");
        wordWrapMenu.addActionListener(this);
        optionMenu.add(wordWrapMenu);

        mainMenu.add(optionMenu);

        add(mainMenu, BorderLayout.NORTH);

        textArea = new JTextArea();
        textArea.getDocument().addDocumentListener(new NotepadDocumentListener());

        scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);


        this.setVisible(true);
    }

    public static void main(String[] args) {
        new NotepadFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem) e.getSource();

        switch (source.getName()){
            case "open" :
                closePrevFile();
                openFile();
                break;
            case "save":
                saveText();
                break;
            case "close":
                closePrevFile();
                break;
            case "exit" :
                closePrevFile();
                this.dispose();
                break;
            case "wordWrap" :
                JCheckBoxMenuItem item = (JCheckBoxMenuItem)source;
                textArea.setLineWrap(item.getState());
                break;
        }
    }

    private void openFile(){
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(this);
        if ( result == JFileChooser.APPROVE_OPTION){
            openedFile = chooser.getSelectedFile();
            try {
                FileReader fileReader = new FileReader(openedFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = bufferedReader.readLine();
                while (line != null){
                    textArea.append(line + "\n");
                    line = bufferedReader.readLine();
                }
                bufferedReader.close();
                textModified = false;

            }catch (IOException e){

            }
        }
    }

    private void closePrevFile() {
        if (textModified){
            Object[] variants = new Object[]{"Да", "Нет","Отмена"};

            int variant = JOptionPane.showOptionDialog(this, "Файл изменен, хотите сохранить его?",
                    "Предупреждение", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
                    variants, variants[0]);
            if(variant==0){
                saveText();
                clearAllInfo();
            }else if (variant == 1){
                clearAllInfo();
            }


        }
            clearAllInfo();
    }

    private  void saveText(){

        if(openedFile != null){
            saveTextToFile();
        } else {
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION){
                openedFile = chooser.getSelectedFile();
                saveTextToFile();
            }
        }

    }

    private void clearAllInfo() {
        this.openedFile = null;
        this.textArea.setText("");
        textModified = false;
    }

    private void saveTextToFile(){
        try{
            FileWriter fileWriter = new FileWriter(openedFile);
            fileWriter.write(textArea.getText());
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    class  NotepadDocumentListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            textModified  = true;
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            textModified = true;

        }

        @Override
        public void changedUpdate(DocumentEvent e) {

            textModified = true;
        }
    }

    class NotepadFrameAdapter extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            closePrevFile();
            e.getWindow().dispose();
        }
    }
}
