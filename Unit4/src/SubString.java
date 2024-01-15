public class SubString {
    static String str = "banana";
    
    public static void main(String[] args) {
        System.out.println(subString(6, 6));
    }









    public static String subString(int a,int b){
        String res = "";
        for (int i = a; i < b; i++) {
            res += str.charAt(i);
        }
        return res;
    }







    
}
