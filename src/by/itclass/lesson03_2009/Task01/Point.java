package by.itclass.lesson03_2009.Task01;

public class Point {

     double x;//абсцисса точки
     double y;//ордината точки

    public Point(){
        x=0.0;
        y=0.0;
    }

    public Point(double x, double y){

         this.x = x;
         this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double length(Point p){

        if (p == null){
            System.err.println("Передана ошибочная точка");
            return 0.0;
        }else {
            return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
        }

    }

    public static double lengthBetween(Point p1, Point p2){

        if (p1 == null || p2 ==null){
            System.err.println("Передана ошибочная точка");
            return 0.0;
        }else {
            return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
        }


    }


    @Override
    public String toString(){ return String.format("(%f, %f)", x, y); }

    @Override
    public boolean equals(Object obj){

        if (obj == null){
            return  false;
        }
        if (obj == this){
            return true;
        }
        //Узнаем, сравниваем объект с тем же классом
        if (obj.getClass() != this.getClass()) {
            return  false;
        }
        Point other = (Point) obj;
        if ((this.x==other.x) &&(this.y==other.y)){
            return true;
        }else {
            return false;
        }
    }

}
