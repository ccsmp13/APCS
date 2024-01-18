import java.awt.Point;


public class WorkingWithObjects {
    public static void main(String[] args) {
        Point p1 = new Point(3,4) , p2 = new Point(4,3);

        System.out.println(p1.equals(p2));

        System.out.println(p1.getLocation());

        System.out.println(p1.getX());

        System.out.println(p2.getY());

        p1.move(5,9);

        System.out.println(p1);

        p2.setLocation(3.14,3.14);
        
        System.out.println(p2);

        p1.setLocation(9,10);

        System.out.println(p1);

        System.out.println(p1.toString());

        p1.translate(1, 1);

        System.out.println(p1);

    }
}


