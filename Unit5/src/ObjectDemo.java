public class ObjectDemo {
    public static void main(String[] args){
        Dot d1 = new Dot();
        Dot d2 = new Dot(1,2,3);
        //d1.x = -1;  //error because x is (correctly) private 
        d1.z = 5;
        d2.move(1,0,-1);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d1.distance(d2));
    }
}
