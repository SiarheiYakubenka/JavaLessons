package by.itclass.lesson10_2610;

import by.itclass.lesson05_0410.Animals.Human;

import java.util.Comparator;

public class HumanComparator implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
