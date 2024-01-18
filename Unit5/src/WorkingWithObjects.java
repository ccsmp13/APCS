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

        p2.setLocation(3.499999999,3.51);
        
        System.out.println("THIS" + p2);

        p1.setLocation(9,10);

        System.out.println(p1);

        System.out.println(p1.toString());

        p1.translate(1, 1);

        System.out.println(p1);



    }
}

// 1. Who wrote the Point source code?
// Sami Shaio
// 2. Roughly how much of the file is comments vs. actual code?
// 95% comments with occasional code sprinkled in
// 3. How does rounding of a double work in the setLocation method?
// It rounds exactly like we would expect it to round where it rouns up from .5 on and down
// from less than .5


