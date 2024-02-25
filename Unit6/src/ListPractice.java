import java.util.ArrayList;
import java.util.List;

public class ListPractice {
    static List<Character> myList;

    public static void main(String[] args) {
        myList = new ArrayList<Character>();
        for (char i = 'A'; i <= 'Z'; i++) {
            myList.add(i);
        }
        System.out.println(myList);
        swap(0,25);
        System.out.println(myList);
        removeVowels();
        System.out.println(myList);
        myList = doubleList(myList);
        System.out.println(myList);
    
    
    }

    // TODO write modifier swap method
    public static void swap(int a, int b) {
        char tem1 = myList.get(a);
        char temp2 = myList.get(b);
        myList.set(a, temp2);
        myList.set(b, tem1);
    }

    public static void removeVowels() {
        String vowels = "AEIOU";
        for (int i = 0; i < myList.size(); i++) {
            if (vowels.indexOf(myList.get(i)) != -1) {
                myList.remove(i);
            }
        }
    }

    public static List<Character> doubleList(List<Character> oldList) {
        List<Character> newList = new ArrayList<Character>();
        for (Character character : oldList) {
            newList.add(character);
            newList.add(character);
        }

        return newList;
    }

}