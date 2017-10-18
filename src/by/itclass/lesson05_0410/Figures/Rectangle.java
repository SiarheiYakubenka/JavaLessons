package by.itclass.lesson05_0410.Figures;


public class Rectangle extends Figure{

    private  final double width;
    private final double height;


    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getPerimeter() {
        return 2*(width + height);
    }

    //Метод с индефекатором final нельзя переопределить в классах-наследниках
    @Override
    public final double getArea() {
        return width*height;
    }

    @Override
    public String toString() {
        return String.format("Прямоугольник со сторонами %.2f, %.2f", width, height);
    }
}
