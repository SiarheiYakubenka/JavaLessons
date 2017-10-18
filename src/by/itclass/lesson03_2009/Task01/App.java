package by.itclass.lesson03_2009.Task01;

public class App {
    public static void main(String[] args) {
        Point   p1 = new Point(),
                p2 = new Point(5.2,4.2),
                p3 = new Point(1.0 ,3.2),
                p4 = new Point(6.2,-1.0);

        System.out.println(p1+"\n"+p2+"\n"+p3+"\n"+p4);

        LineSegment s1 = new LineSegment(p1, p2),
                    s2 = new LineSegment(p3, p4),
                    s3 = new LineSegment(3.0, 2.0, 5.7, 6.5);

        LineSegment.compare(s1,s2);
        LineSegment.checkIntersectionOfTwoLineSegments(s1, s2);
        System.out.println(LineSegment.str);
        System.out.printf("Расстояние от точки до отрезка %.3f\n", LineSegment.distPointToLineSegment(p1,s2));

        Triangle triangle = new Triangle(0.0, 0.0, 3.2, 3.2, 6.4, 0.0);
        triangle.isPointInTriangle(new Point(2.0, 1.0 ));

        Triangle triangle1 = new Triangle(p1, p2, p3);
        LineSegment segment = new LineSegment(0.0, 3.0, 5.0, -1.0);
        triangle1.checkIntersectionLineSegmentsAndTriangle(segment);
    }
}
