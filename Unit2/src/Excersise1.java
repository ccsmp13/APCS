public class Excersise1 {
    public static void main(String[] args) {
        fermat(3, 4, 5, 6);
        triangle(4, 5, 12);
    }

    public static void fermat(int a, int b, int c, int n) {
        double leftSide = (Math.pow(a, n) + Math.pow(b, n));
        double rightSide = (Math.pow(c, n));
        if (n <= 2) {
            System.out.println("Please enter an n value greater than 2");
        } else if (leftSide == rightSide) {
            System.out.println("Holy smokes, Fermat was wrong!");
        } else {
            System.out.println("No, that doesn't work.");
        }
    }
    public static void triangle(int a, int b, int c){
        int ab = a + b;
        int bc = b + c;
        int ac = a + c;
        if (ab <= c){
            System.out.println("Nope. Not a triangle");
        } else if (bc <= a){
            System.out.println("Nope. Not a triangle");
        } else if (ac <= b){
            System.out.println("Nope. Not a triangle");
        } else {
            System.out.println("You got a triangle!");
        }
    }
}
