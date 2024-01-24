public class LILearning {
    // Change these boolean values to control whether you see 
    // the expected result and/or hints.
    public static void main(String[] args) {
        System.out.println(reverseEachWord("sandy"));
    }

    private static String reverse(String word) {
		StringBuilder sb = new StringBuilder(word);
		return sb.reverse().toString();
	}

    // Return a new String with each word reversed
    static String reverseEachWord(String sentence) {
        
        
        String result = "";
        String[] s =  sentence.split(" ");
        for(String word : s){
            result += reverse(word);
        }
        return result;
    }
}