public class RecursionExcercise {
    public static void main(String[] args) {
        System.out.println(isPalindrome("redivider"));
        System.out.println(power(2,12));
        System.out.println(remainder(123, 23));
    }
    public static boolean isPalindrome(String s){
        if (s.length() <= 1){
            return true;
        } 
        if (s.charAt(0) == s.charAt(s.length() - 1)){
            return isPalindrome(s.substring(1, s.length() - 1));
        }
        return false;
    }

    public static double power(double x, int n){
        if (n == 1){
            return x;
        } 
        return power(x,n -1) * x;
        
    }
    public static int remainder(int x, int y){
        if(y >= x){
            return x;
        }
        return remainder(x - y, y);
    }
}
