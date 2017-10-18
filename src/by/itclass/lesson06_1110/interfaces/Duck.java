package by.itclass.lesson06_1110.interfaces;

/*
Класс утка, реализующий интерфейс "Возможность летать"
Реалезация интерфейсов объявляется через ключевое слово implements
Можно реализовать несколько интерфейсоф, перечислив их через запятую.
 */
public class Duck extends Bird implements Flyable, Swimable {


    //При реализации интерфейса мы должны реализовать все его методы
    @Override
    public void fly() {
        System.out.println("Утка летит");
    }

    @Override
    public double getMaxHeigth() {
        return 500;
    }

    @Override
    public double getMaxSpeed() {
        return 100;
    }

    @Override
    public void swim() {
        System.out.println("Утка плывет");
    }
}
