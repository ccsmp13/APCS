public class Rational {

    //TODO add javadoc comments

    private int numerator;
    private int denominator;

    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    public Rational(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public String toString() {
        return String.format("%d / %d", this.numerator, this.denominator);
    }

    public Double toDouble() {
        
        return (double)this.numerator / (double)this.denominator;
    }

    public Rational negate(){

        return new Rational(-this.numerator,this.denominator);
    }

    public Rational invert(){
        return new Rational(this.denominator , this.numerator);
    }

    public Rational add(Rational r){
        Rational res = new Rational();
        res.numerator = this.numerator * r.denominator + r.numerator * this.denominator;
        res.denominator = this.denominator * r.denominator;
        reduce();
        return res;
    }

    public Rational subtract(Rational r){
        Rational res = new Rational();
        res.numerator = this.numerator * r.denominator - r.numerator * this.denominator;
        res.denominator = this.denominator * r.denominator;
        reduce();
        return res;
    }

    public Rational multiply(Rational r){
        Rational res = new Rational();
        res.numerator = this.numerator * r.numerator;
        res.denominator = this.denominator * this.denominator;
        reduce();
        return res;
    }

    public Rational divide(Rational r){
        Rational res = new Rational();
        r = r.invert();
        res = this.multiply(r);
        reduce();
        return res;
    }

    private void reduce() {
        int n = this.numerator, d = this.denominator, temp = 1;

        if (n % d == 0) {
            temp = n / d;
            this.numerator = temp;
            this.denominator = 1;
        } else {
            while (n % d != 0) {
                temp = n % d;
                n = d;
                d = temp;

            }
            this.numerator /= temp;
            this.denominator /= temp;
        }

    }

}