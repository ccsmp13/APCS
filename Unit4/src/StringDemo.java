public class StringDemo {
    public static void main(String[] args) {

        System.out.println(replace());
    }

    public static String replace() {
        String str = "chumbawumba";
        String oldText = "ba";
        String newText = "ku";

        int loc = str.indexOf(oldText);
        while (loc != -1) {
            String firstPart = str.substring(0, loc);
            String lastPart = str.substring(loc + oldText.length());
            str = firstPart + newText + lastPart;
            loc = str.indexOf(oldText);
        }
        return str;
    }

    public static boolean isPalindrom(String s) {
        String back = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            back += s.charAt(i);
        }
        if (s.equals(back)) {
            return true;
        } else {

            return false;

        }
    }

}
