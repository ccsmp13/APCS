public class RationalTest {
    public static void main(String[] args) {
        Rational r = new Rational(10,20);
        Rational d = new Rational (3,5);
        System.out.println(r);
        System.out.println(r.toDouble());
        System.out.println(r.invert());
        System.out.println(r.negate());
        System.out.println(r.add(d));
    }

}