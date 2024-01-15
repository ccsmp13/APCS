public class ArrayDemo {
    public static void main(String[] args) {
        int[] a = new int[19];
        a[7] = 98;
        a[2] = 91;
        //array loops start at 0
        //they often use 'i' to stand for 'index'
        // a.length gives the number of elements in the array
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }

    }
}
