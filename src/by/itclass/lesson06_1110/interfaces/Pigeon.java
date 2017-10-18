package by.itclass.lesson06_1110.interfaces;

/*
 Абстрактный класс не обязан реализовывать все методы интрефейса
 Если класс не хочет реализовывать некотрые методы интерфейса,
 то он должен быть абстрактным
 */
public abstract class Pigeon extends Bird implements Flyable {
    @Override
    public void fly() {

    }

    @Override
    public double getMaxHeigth() {
        return 0;
    }
}
