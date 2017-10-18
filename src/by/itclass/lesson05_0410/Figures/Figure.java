package by.itclass.lesson05_0410.Figures;


//Абстрактный класс может содержать только абстрактные методы
//и объект данного класса нельзя создать

public abstract class Figure {


    //Абстрактный метод не имеет тела
    //Метод нужно обязательно переопределить в классе наследнике
    //Площадь фигуры
    public abstract double getArea();

     //Периметр фигуры
    public abstract double getPerimeter();
/*
    @Override
    public String toString() {
        return "Геометрическая фигура";
    }
*/
}
