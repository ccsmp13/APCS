import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("resource")
public class LanguageAnalyzer {

    static double[] english = { .0812, .0149, .0271, .0432, .1202, .023, .0203, .0592, .0731, .001, .0069, .0398, .0261,
            .0695, .0768,
            .0182, .0011, .0602, .0628, .091, .0288, .0111, .0209, .0017, .0211, .0007 };
    static double[] spanish = { .1216, .0149, .0387, .0467, .1408, .0069, .01, .0118, .0598, .0052, .0011, .0524,
            .0308, .07, .092, .0289, .0111, .0641, .072, .0460, .0469, .0105, .0004, .0014, .0109, .0047 };
    static double[] french = { .0813, .0093, .0315, .0355, .1510, .0096, .0097, .0108, .0694, .0071, .0016, .0568, .0323,
         .0642, .0527, .0303, .0089, .0643, .0791, .0711, .0605, .0183, .0004, .0042, .0019, .0021 };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Type something: ");
        String text = in.nextLine();
        String result = compareLoss(text);
        System.out.println(String.format("The phrase \"%s\" is likely in %s", text, result));
      
      

    }
    public static String compareLoss(String text){
        double lossEnglish = calcLoss(letterFreqs(letterHist(text)), english);
        double lossSpanish = calcLoss(letterFreqs(letterHist(text)), spanish);
        double lossFrench = calcLoss(letterFreqs(letterHist(text)), french);

        if(lossEnglish < lossSpanish && lossEnglish < lossFrench){
            return "english";
        }
        if (lossSpanish < lossEnglish && lossSpanish < lossFrench){
            return "spanish";
        }
        if (lossFrench < lossEnglish && lossFrench < lossSpanish){
            return "french";
        }
        return "nope";
    }

    public static int[] letterHist(String s){
        final int CHAR_SHIFT = 97;
        final int NUM_OF_LETTERS = 26;
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        int[] hist = new int[NUM_OF_LETTERS];
        for (int i = 0; i < chars.length; i++) {
            int bin = chars[i] - CHAR_SHIFT;
            if (bin >= 0 && bin <= 25){
                hist[bin]++;

            }

        }
        return hist;
    }

   
    public static double[] letterFreqs(int[] letterHist) {
        final int NUM_OF_LETTERS = 26;
        double[] freqHist = new double[NUM_OF_LETTERS];
        int numLetterSum = 0;
        
        for (int i = 0; i < letterHist.length; i++) {
            numLetterSum += letterHist[i];
        }

        for (int i = 0; i < freqHist.length; i++) {
            freqHist[i] =  1.0 * letterHist[i] / numLetterSum; 
        }
        return freqHist;
    }

    public static double calcLoss(double[] data, double[] referenceVals) {
        double[] lossFunction = new double[referenceVals.length];
        double sum = 0;
        for (int i = 0; i < referenceVals.length; i++) {
            lossFunction[i] = referenceVals[i] - data[i];
            lossFunction[i] = lossFunction[i] * lossFunction[i];
        }
        for (double d : lossFunction) {
            sum += d;
        }
        double result = sum / data.length;
        return result;
    }
}