public class Rational {

    private int numerator;
    private int denominator;

    /**
     * Constructs a Rational object with default values (0/1)
     */
    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }
    
    /**
     * Constructs a Rational object with the specified numerator and denominator
     *
     * @param numerator   the numerator of the rational number
     * @param denominator the denominator of the rational number
     */
    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        reduce(this);
    }
    
    /**
     * Constructs a Rational object with the specified numerator and a denominator
     * of 1
     *
     * @param numerator the numerator of the rational number
     */
    public Rational(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    /**
     * Returns a string of the rational number
     *
     * @return a string of the rational number
     */
    public String toString() {
        return String.format("%d/%d", this.numerator, this.denominator);
    }

    /**
     * Converts the rational number to a double value
     *
     * @return the rational number as a double value
     */
    public Double toDouble() {

        return (double) this.numerator / (double) this.denominator;
    }
    
    /**
     * Returns the negatie value of the rational number
     *
     * @return the negatie of the rational number
     */
    public Rational negate() {

        return new Rational(-this.numerator, this.denominator);
    }

    /**
     * Returns the reciprocal of the rational number
     *
     * @return the reciprocal of the rational number
     */
    public Rational invert() {
        return new Rational(this.denominator, this.numerator);
    }

    /**
     * Adds another rational number to this rational number
     *
     * @param other the rational number to be added
     * @return the sum of this rational number and the given rational number
     */
    public Rational add(Rational other) {
        Rational res = new Rational(this.numerator * other.denominator + other.numerator * this.denominator,
                this.denominator * other.denominator);
        return res;
    }
    
    /**
     * Subtracts another rational number from this rational number
     *
     * @param other the rational number to be subtracted
     * @return the difference between this rational number and the given rational
     * number
     */
    public Rational subtract(Rational other) {
        Rational res = new Rational(this.numerator * other.denominator - other.numerator * this.denominator,
                this.denominator * other.denominator);
        return res;
    }

    /**
     * Multiplies this rational number by another rational number
     *
     * @param other the rational number to be multiplied
     * @return the product of this rational number and the given rational number
     */
    public Rational multiply(Rational other) {
        int num, denom;
        num = this.numerator * other.numerator;
        denom = this.denominator * other.denominator;
        Rational res = new Rational(num, denom);
        return res;
    }

    /**
     * Divides this rational number by another rational number
     *
     * @param other the rational number to divide by
     * @return the quotient of this rational number divided by the given rational
     * number
     */
    public Rational divide(Rational other) {
        int num, denom;
        num = this.numerator * other.denominator;
        denom = this.denominator * other.numerator;

        Rational res = new Rational(num, denom);
        return res;
    }

    /**
     * Checks if this rational number is equal to another rational number
     *
     * @param other the rational number to compare with
     * @return true if the two rational numbers are equal, false otherwise
     */
    public boolean equals(Rational other) {
        return this.numerator == other.numerator && other.numerator == this.numerator;
    }

    private static int gcd(Rational other) {
        int n = other.numerator, d = other.denominator, temp = 1;

        if (n % d == 0) {
            temp = n / d;
            other.numerator = temp;
            other.denominator = 1;
        } else {
            while (n % d != 0) {
                temp = n % d;
                n = d;
                d = temp;
            }
            return temp;
        }
        return 1;
        
    }

    private void reduce(Rational r) {
        int gcd = gcd(r);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

}
