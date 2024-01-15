import java.util.Scanner;
@SuppressWarnings("resource")

public class ULIDPW {
    public static void main(String[] args) {
       // System.out.println(ULIDGen());
        //System.out.println(password());
        System.out.println(passHash(password()));
        System.out.println(passHash(password())); 
        
    }


    public static String passHash(String pw){
        String firstHashPW = "";
        String secondHashPW = "";
        final int UNICODE_SHIFT = 49;
        final int SINGLE_DIGIT = 9;
        final int LENGTH_OF_HASH = 16;
        //This ANY_NUM variable is really just any number you want to choose
        //I found 31 works pretty good
        final int ANY_NUM = 31;
        for (int i = 0; i < pw.length(); i++) {
            firstHashPW += ((int)pw.charAt(i) * ANY_NUM) % SINGLE_DIGIT;
        }
        for (int i = 0; i < firstHashPW.length(); i++) {
            if (i % 2 == 0){
                secondHashPW += (char)((int)firstHashPW.charAt(i) + UNICODE_SHIFT);
            } else{
                secondHashPW += firstHashPW.charAt(i);
            }
        }
        if (secondHashPW.length() < LENGTH_OF_HASH){
            for (int i = secondHashPW.length(); i < LENGTH_OF_HASH; i++) {
                secondHashPW += i * ANY_NUM % SINGLE_DIGIT;
            }
        }
        if (secondHashPW.length() > LENGTH_OF_HASH){
            secondHashPW = secondHashPW.substring(0, LENGTH_OF_HASH);
        }
        return secondHashPW;
    }
    public static String ULIDGen() {
        String first = "";
        String middle = "";
        String last = "";
        boolean isValid = false;
        Scanner in = new Scanner(System.in);
        while (!isValid) {
            System.out.print("Please enter your first name: ");
            first = in.nextLine();
            first = first.toLowerCase();
            if (!first.equals("")) {
                isValid = true;
            }
        }
        isValid = false;
        System.out.print("Please enter your middle name: ");
        middle = in.nextLine();
        middle = middle.toLowerCase();

        while (!isValid) {
            System.out.print("Please enter your last name: ");
            last = in.nextLine();
            last = last.toLowerCase();
            if (!last.equals("")) {
                isValid = true;
            }
        }
        final int ISO_INITIAL = 1;
        final int NUM_OF_LAST_NAME = 5;

        first = first.substring(0, ISO_INITIAL);
        if (!middle.equals("")) {
            middle = middle.substring(0, ISO_INITIAL);
        }
        if (last.length() >= 5) {
            last = last.substring(0, NUM_OF_LAST_NAME);
        }

        return first + middle + last;
    }

    public static String password() {
        String password = "";
        boolean isPassValid = false;
        Scanner in = new Scanner(System.in);
        while (!isPassValid) {
            System.out.print("Enter a password: ");
            password = in.nextLine();
            if (isCap(password) && isLength(password) && isLow(password) && isNum(password)) {
                return password;
            }
            if (!isCap(password)) {
                System.out.println("Please include at least one capital letter");
            }
            if (!isLength(password)) {
                System.out.println("Please make your password longer then 8 characters");
            }
            if (!isLow(password)) {
                System.out.println("Please include at lease one lowercase letter");
            }
            if (!isNum(password)) {
                System.out.println("Please include at least one number");
            }
        }
        return password;
    }

    public static boolean isCap(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                return true;
            }
        }
        return false;
    }

    public static boolean isLow(String s) {
        char a = 'a';
        char z = 'z';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= a && s.charAt(i) <= z) {
                return true;
            }
        }
        return false;
    }

    public static boolean isLength(String s) {
        if (s.length() >= 8) {
            return true;
        }
        return false;
    }

    public static boolean isNum(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                return true;
            }
        }
        return false;
    }
}
