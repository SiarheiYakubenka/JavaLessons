package by.itclass.lesson03_2009.Task01;

public class LineSegment {

    public Point point1;
    public Point point2;

    private double length;
    public static String str;

    public double getLength() {

         //return Point.lengthBetween(point1, point2);
        return length;
    }

    public LineSegment(Point point1, Point point2){

        if (point1 == null || point2 == null){
            System.err.println("Одна или две точки отсутствуют");
        } else if (point1.equals(point2)) {
            System.err.println("Переданы одинаковые точки");
        } else {
            this.point1 = point1;
            this.point2 = point2;
            length = point1.length(point2);
        }

    }

    public LineSegment(double x1, double y1, double x2, double y2) {

        if(!((x1==x2) && (y1==y2))) {
            point1 = new Point(x1, y1);
            point2 = new Point(x2, y2);
            length = point1.length(point2);

        }
    }

    public static void compare(LineSegment segment1, LineSegment segment2){

        if ( segment1 == null || segment2 == null){
            System.err.println("Один или оба отрезка отсутствуют");
        }else
            if (segment1.length > segment2.length) {
            System.out.println("Первый отрезок  больше второго");

        }else  if (segment1.length < segment2.length){
            System.out.println("Второй отрезок больше первого");

        }else {
            System.out.println("Отрезки равны");
        }
    }

    public static boolean checkIntersectionOfTwoLineSegments(LineSegment segment1, LineSegment segment2){
        String  s1 = "Отрезки не пересекаются",
                s2 = "Отрезки пересекаются";
        Point   p1 = segment1.point1,
                p2 = segment1.point2,
                p3 = segment2.point1,
                p4 = segment2.point2;

        //проверяем, находятся ли начальные точки отрезков левее конечных относительно оси X
        //если нет, то расставляем по порядку
        if ( p2.x < p1.x ){
            Point tempPoint = p1;
            p1 = p2;
            p2 = tempPoint;
        }
        if ( p4.x < p3.x ){
            Point tempPoint = p3;
            p3 = p4;
            p4 = tempPoint;
        }

        //проверим существование потенциального интервала для точки пересечения отрезков
        if ((p2.x < p3.x)||(p1.x > p4.x)) {         //Если конец первого отрезка находиться левее начала второго
            str = s1;
             return false;                      //Если начало первого отрезка находиться правее конца второго

        }

        //если оба отрезка горизонтальные и лежат на одном Y
        if ((p1.y == p2.y) && (p3.y == p4.y) && (p1.y == p3.y)){
            str = s2+"\nОба отрезка горизонтальные и лежат на одной прямой";
            return  true;
        }

        //если оба отрезка вертикальные  и лежат на одном X
        if((p1.x == p2.x) && (p3.x == p4.x) && (p1.x == p3.x) ) {

              //проверим пересекаются ли они, т.е. есть ли у них общий Y
              //для этого возьмём отрицание от случая, когда они НЕ пересекаются

                if (!((Math.max(p1.y, p2.y) < Math.min(p3.y, p4.y)) ||

                        (Math.min(p1.y, p2.y) > Math.max(p3.y, p4.y)))) {

                    str = s2+"\nОба отрезка вертикальные и лежат на одной прямой";
                    return true;
                }
            str = s1;
            return false;
        }

       //найдём коэффициенты уравнений, содержащих отрезки
       //f1(x) = A1*x + b1 = y
       //f2(x) = A2*x + b2 = y

       //если первый отрезок вертикальный
        if (p1.x == p2.x) {

          //найдём Xa, Ya - точки пересечения двух прямых

            double Xa = p1.x;
            double A2 = (p3.y - p4.y) / (p3.x - p4.x);
            double b2 = p3.y - A2 * p3.x;
            double Ya = A2 * Xa + b2;

            if ((p3.x <= Xa) && (p4.x >= Xa) && (Math.min(p1.y, p2.y) <= Ya) &&

                    (Math.max(p1.y, p2.y) >= Ya)) {

                str = s2+String.format(" в точке с координатами (%.2f;%.2f)",Xa,Ya);
                return true;
            }
            str = s1;
            return false;
        }

        //если второй отрезок вертикальный
        if (p3.x - p4.x == 0) {

          //найдём Xa, Ya - точки пересечения двух прямых

            double Xa = p3.x;
            double A1 = (p1.y - p2.y) / (p1.x - p2.x);
            double b1 = p1.y - A1 * p1.x;
            double Ya = A1 * Xa + b1;

            if (p1.x <= Xa && p2.x >= Xa && Math.min(p3.y, p4.y) <= Ya &&

                    Math.max(p3.y, p4.y) >= Ya) {


                str = s2+String.format(" в точке с координатами (%.2f;%.2f)",Xa,Ya);
                return true;

            }
            str = s1;
            return false;
        }

        //оба отрезка невертикальные
        double A1 = (p1.y - p2.y) / (p1.x - p2.x);
        double A2 = (p3.y - p4.y) / (p3.x - p4.x);
        double b1 = p1.y - A1 * p1.x;
        double b2 = p3.y - A2 * p3.x;

        if (A1 == A2) {  //отрезки параллельны

            str = s1;
            return false;
        }

        //Xa - абсцисса точки пересечения двух прямых
        double Xa = (b2 - b1) / (A1 - A2);

        if ((Xa < Math.max(p1.x, p3.x)) || (Xa > Math.min( p2.x, p4.x))) {

            str = s1; //точка Xa находится вне пересечения проекций отрезков на ось X
            return false;
        } else {

            double Ya = A1*Xa+b1;

            str = s2+String.format(" в точке с координатами (%.2f;%.2f)",Xa,Ya);
            return true;

        }
    }

    public static double distPointToLineSegment(Point point, LineSegment segment){

        Point   p = point,
                p1 = segment.point1,
                p2 = segment.point2;

        if ((p.x-p1.x)*(p2.x-p1.x)+(p.y-p1.y)*(p2.y-p1.y) >= 0 && (p.x-p2.x)*(p1.x-p2.x)+(p.y-p2.y)*(p1.y-p2.y) >= 0){

            return Math.abs((p.x - p1.x) * (p2.y - p1.y) - (p.y - p1.y) * (p2.x - p1.x)) / p1.length(p2);

        }else if (p.length(p1) < p.length(p2)){
            return  p.length(p1);
        }else {
            return p.length(p2);
        }
    }
}
