public class View {
    private int screenWidth;

    private int screenHeight;
    double xSlope, xOffset, ySlope, yOffset;
    // initialize the view

    public View(int w, int h) {
        screenWidth = w;

        screenHeight = h;

        setComplexCorners(new Complex(-2, 1), new Complex(1, -1));
    }

    // translate a point

    public Complex translate(int x, int y) {
        double real = xSlope * x + xOffset;
        double imag = ySlope * y + yOffset;
        return new Complex(real, imag);
    }

    // set or update screen zoom

    public void setComplexCorners(Complex topLeft, Complex botRight) {
        xSlope = (botRight.getReal()-topLeft.getReal()) / (screenWidth - 0);
        xOffset =  topLeft.getReal();
        yOffset = topLeft.getImag();
        ySlope = (botRight.getImag() - topLeft.getImag()) / screenHeight - 0;
    }
}
