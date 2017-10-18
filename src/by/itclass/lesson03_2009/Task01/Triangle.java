package by.itclass.lesson03_2009.Task01;

public class Triangle {

    Point point1,
          point2,
          point3;

    public Triangle(Point point1, Point point2, Point point3){

        if(point1 == null || point2 == null || point3 == null){

            System.err.println("Одна или несколько точек отсутствуют");

        }else if((point1.equals(point2)) || (!point1.equals(point3)) || (!point2.equals(point3))) {

            System.err.println("Одна или несколько точек равны");

        }else{
            double l12 = (point1.length(point2));
            double l23 = (point2.length(point3));
            double l13 = (point1.length(point3));

             if (l12+l23<=l13 || l23+l13<=l12 || l12+l13<=l23){
                System.err.println("Точка лежит на одной линии");
            }
            else {
                this.point1 = point1;
                this.point2 = point2;
                this.point3 = point3;
            }
            }
        }


    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {

        Point point1 = new Point(x1, y1),
              point2 = new Point(x2, y2),
              point3 = new Point(x3, y3);

        if ((!point1.equals(point2)) && (!point1.equals(point3)) && (!point2.equals(point3))) {

            if (point1.length(point2) < (point1.length(point3) + point2.length(point3))) {

                this.point1 = point1;
                this.point2 = point2;
                this.point3 = point3;
            }
        }
    }

    public  void isPointInTriangle(Point point){

        Point  p = point,
               p1 = point1,
               p2 = point2,
               p3 = point3;

        double a = (p1.x - p.x) * (p2.y - p1.y) - (p2.x - p1.x) * (p1.y - p.y);
        double b = (p2.x - p.x) * (p3.y - p2.y) - (p3.x - p2.x) * (p2.y - p.y);
        double c = (p3.x - p.x) * (p1.y - p3.y) - (p1.x - p3.x) * (p3.y - p.y);

        if ((a >= 0 && b >= 0 && c >= 0) || (a <= 0 && b <= 0 && c <= 0))
        {
            System.out.println("Точка принадлежит треугольнику");
        }
        else
        {
            System.out.println("Точка не принадлежит треугольнике");
        }
    }

    public void checkIntersectionLineSegmentsAndTriangle(LineSegment segment){

        LineSegment segment1 = new LineSegment(point1, point2),
                    segment2 = new LineSegment(point1, point3),
                    segment3 = new LineSegment(point2, point3);

        if (LineSegment.checkIntersectionOfTwoLineSegments(segment,segment1) ||
                LineSegment.checkIntersectionOfTwoLineSegments(segment, segment2) ||
                LineSegment.checkIntersectionOfTwoLineSegments(segment, segment3)){

            System.out.println("Отрезок пересекается с треугольником");

        }else {
            System.out.println("Отрезок не пересекается с треугольником");
        }
    }
}
