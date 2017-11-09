package by.itclass.lesson14_0911;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TicTacToe extends JFrame {

    private Figure[][] figures;
    private Figure move;
    private int freeCells = 9;

    public TicTacToe() {

        setTitle("Крестики-нолики");
        setSize(300, 300);
        setMinimumSize(new Dimension(300, 300));


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        figures = new Figure[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                figures[i][j] = Figure.Empty;
            }


        }

        move = Figure.CROSS;
        loadSaveGame();

        addMouseListener(new TicTacMouseAdapter());

        setVisible(true);

    }

    private void loadSaveGame() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("save.properties"));


            freeCells = Integer.parseInt(properties.getProperty("freeCells"));
            move = Figure.valueOf(properties.getProperty("move"));

            String[] cells = properties.getProperty("state").split(",");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    figures[i][j] = Figure.valueOf(cells[i * 3 + j]);
                }

            }

        } catch (IOException e) {

        }
    }

    private void saveGame() {
        Properties properties = new Properties();


        properties.put("freeCells", Integer.toString(freeCells));

    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        drawLines(graphics);
        drawFigures(graphics);
    }

    private void drawLines(Graphics g) {

        for (int i = 0; i < 2; i++) {
            int x = (i + 1) * this.getWidth() / 3;
            g.drawLine(x, 0, x, this.getHeight() - 1);
        }
        for (int i = 0; i < 2; i++) {
            int y = (i + 1) * this.getHeight() / 3;
            g.drawLine(y, 0, y, this.getWidth() - 1);
        }
    }

    private void drawFigures(Graphics g) {
        final int RADIUS = 40;
        int w = getWidth();
        int h = getHeight();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Figure figure = figures[i][j];
                int x = j * (w / 3) + w / 6;
                int y = i * (h / 3) + h / 6;
                switch (figure) {
                    case NOUGHT:
                        g.drawOval(x - RADIUS / 2, y - RADIUS, RADIUS, RADIUS);
                        break;
                    case CROSS:
                        g.drawLine(x - RADIUS / 2, y - RADIUS / 2, x + RADIUS, x + RADIUS);
                }
            }
        }
    }

    public static void main(String[] args) {
        new TicTacToe();
    }

    class TicTacMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int i = e.getY() / (getHeight() / 3);
            int j = e.getX() / (getWidth() / 3);

            if (move == Figure.CROSS) {
                figures[i][j] = Figure.CROSS;
                move = Figure.NOUGHT;
            } else if (move == Figure.NOUGHT) {
                figures[i][j] = Figure.NOUGHT;
                move = Figure.CROSS;
            }
        }

       // repaint();

       // checkWin();

    }


    private void checkWin() {
        checkVerticalWin();
        checkHorizontalWin();
        checkDiagonalWin();

    }

    private Figure checkVerticalWin() {
        for (int j = 0; j < 2; j++) {
            if (figures[0][j] == figures[1][j] && figures[1][j] == figures[2][j]){

            }

        }
        return Figure.NOUGHT;
    }

    private Figure checkHorizontalWin() {

        return Figure.Empty;
    }

    private Figure checkDiagonalWin() {
        return Figure.NOUGHT;
    }
}

enum Figure{
    Empty,
    NOUGHT,
    CROSS
}
