import java.util.List;

public class WrapperClasses{
    public static void main(String[] args) {
        //prims
        int x = 9;
        double y = 2.5;

        //wrapper objects
        // obsolete but shows how objects are usually created
        Integer x2 = new Integer(7); 
        Double y2 = new Double(1.2);
        //proper way in java
        Integer x3 = Integer.valueOf(8);
        Double y3 = Double.valueOf(1.8);

        System.out.println(x3 + x);
        System.out.println(x2 + y);
        System.out.println(x2 + y3);
        System.out.println(x3 + y3);
        int a = x + x2;
        Integer q = x2 + x3;
        System.out.println(q);
        Integer z = x + x3;
        System.out.println(z);
        //Autoboxing:
        // Java auto converts between wrapper objects and primative whenever needed

        //Why even have wrapper classes?

        //1. They come in built in methods
        System.out.println(x3.byteValue());
        Integer b = Integer.parseInt("316");
        System.out.println(b);

        //2. Somethings in java only work on objects
        List<Integer> myList;
        // List<int> myList2; does not work on prims

    }

}