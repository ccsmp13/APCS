public class ObjectDemo {
    public static void main(String[] args){
        Dot d1 = new Dot();
        Dot d2 = new Dot(1,2,3);
        Time t1 = new Time(13345.2);
        Time t2 = new Time(13345.2);
        //d1.x = -1;  //error because x is (correctly) private 
        d1.z = 5;
        d2.move(1,0,-1);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d1.distance(d2));
        
        System.out.println(t1.getHour());
        System.out.println(t1.getMinute());
        System.out.println(t1.getSecond());
        System.out.println(t1);
        t1.setHour(7);
        System.out.println(t1);
        System.out.println(t1.subtract(t2));
        t1 = new Time(13345.2);
        t2 = new Time(13345.25);
        System.out.println(t1.equals(t2));
    }
}
