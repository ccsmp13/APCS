public class RecursionDemo {
    public static void main(String[] args) {
        // System.out.println("Hi, I am the cat in the hat.");
        // littlecat('A');
        System.out.println(fibo(8));
    }
    public static int fibo(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        return fibo(n-1) + fibo(n-2);

    }
    public static void littlecat(char c){
        System.out.println("Hi, I am little cat " + c);
        if (c == 'Z'){
            System.out.println("VOOOOOOOOM!");
            return;
        } else {
        c += 1;
        littlecat(c);
        }
    }
}
