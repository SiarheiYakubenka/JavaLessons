package by.itclass.lesson06_1110.interfaces;

/*
 Объявление интерфейса Flyable (то кто может летать)
 Все классы, которые реализуют интерфейс, должны реализовать все методы
 */
public interface Flyable {
    /*
     В интерфейсе мы можем объявлять только заголовок метода
     */
    void fly();

    /*
    Переменные в интерфейсе объявлять нельзя, но зато можно объявить метод, который будет
    возвращать значение
     */

    double getMaxHeigth();//узнать максимальную высоту

    double getMaxSpeed();//узнать максимальную скорость

}