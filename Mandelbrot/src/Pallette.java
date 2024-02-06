import java.awt.Color;
import java.nio.charset.MalformedInputException;

public class Pallette {
    private int colorScheme;

    public Pallette(int colorScheme) {

        this.colorScheme = colorScheme;
    }

    public Color getColor(double normedN) {
        if (this.colorScheme == 1) {
            return getPalette1(normedN);
        } else { 
            return getDefaultPalette(normedN);
        }
    }
    // if (this.colorScheme == 2) {
    //     return getPalette2(normedN);
    // } else if (this.colorScheme == 3) {
    //     return getPalette3(normedN);
    // }
    private Color getPalette1(double n){
        double normalized = (n / Mandelbrot.iterationLimit);
        if (normalized < 0)
            return Color.BLACK;
        int red = (int)(122 * Math.cos(normalized * 3)) + 122;
        int green = (int) (122 * Math.cos(normalized * 6)) + 122;
        int blue = -(int)(122 * Math.cos(normalized * 3)) + 122;
        return new Color(red, green, blue);
    }
 
    private Color getDefaultPalette(double n){
        if (n < 0){
            return Color.BLACK;
        }else {
            return Color.WHITE;
        }
    }
}