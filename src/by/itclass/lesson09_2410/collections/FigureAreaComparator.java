package by.itclass.lesson09_2410.collections;

import by.itclass.lesson05_0410.Figures.Figure;

import java.util.Comparator;

//Компоратор, который сравнивает фигуры по площади
public class FigureAreaComparator implements Comparator<Figure> {
    @Override
    public int compare(Figure o1, Figure o2) {

        double area1 = o1.getArea();
        double area2 = o2.getArea();
        return Double.compare(area1,area2);
    }
}
