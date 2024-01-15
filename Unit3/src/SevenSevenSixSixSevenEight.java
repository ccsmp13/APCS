public class SevenSevenSixSixSevenEight {
    public static void main(String[] args) {
        System.out.println(canSpell("stoplaskodjfh", "poots"));
    }

    public static int[] letterHist(String s) {
        final int NUM_BINS = 26;
        final int LOWERCASE_START = 97;
        int[] hist = new int[NUM_BINS];
        char[] letters = s.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int bin = letters[i] - LOWERCASE_START;
            hist[bin]++;
        }
        return hist;
    }

    public static boolean isAnagram(String s1, String s2) {
        int[] s1Hist = letterHist(s1);
        int[] s2Hist = letterHist(s2);
        for (int i = 0; i < s2Hist.length; i++) {
            if (s1Hist[i] != s2Hist[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean canSpell(String tiles, String word) {
        int[] tilesHist = letterHist(tiles);
        int[] wordHist = letterHist(word);
        for (int i = 0; i < wordHist.length; i++) {
            if (wordHist[i] <= tilesHist[i]) {
                tilesHist[i]--;
            } else {
                return false;
            }
        }
        return true;
    }

}
