package by.itclass.lesson05_0410.Figures;


public class App {
    public static void main(String[] args) {


    Figure f1 = new Triangle(3, 4, 5);

        System.out.println(f1);
        System.out.println(f1.getArea());
        System.out.println(f1.getPerimeter());

        Figure f2 = new Rectangle(3, 4);

        System.out.println(f2);
        System.out.println(f2.getArea());
        System.out.println(f2.getPerimeter());

        Figure f3 = new Circle(3);

        System.out.println(f3);
        System.out.println(f3.getArea());
        System.out.println(f3.getPerimeter());


    }
}
