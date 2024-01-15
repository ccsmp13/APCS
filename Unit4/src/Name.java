public class Name {
    public static void main(String[] args) {
        //String str = "firstname m lastname";
        String str = "lastname, firstname m";
        String first = "";
        String last = "";
        int i = -1;

            if(str.indexOf(",") != -1){
                i = str.indexOf(",");
                last += str.substring(0, i);
                first += str.substring(i+2);
            } else{
        
        i = str.indexOf(" ");
        first = str.substring(0, i);
        last = str.substring(i + 3);
            }
        System.out.println("First: " + first);
        System.out.println("Last: " + last);
    }
}
