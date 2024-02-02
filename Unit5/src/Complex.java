public class Complex {
    private double real;
    private double imag;


    public Complex(double realPart, double imaginaryPart){
        this.real = realPart;
        this.imag = imaginaryPart;
    }
    public Complex(){
        this.real = 0;
        this.imag = 0;
        
    }

    public double getImag(){
        return this.imag;
    }

    public double getReal(){
        return this.real;
    }

    public Complex subtract(Complex other) {
        
        double real = this.real - other.real;
        double imag = this.imag - other.imag;
        return new Complex(real, imag);
    }
    public Complex add(Complex other) {
        
        double real = this.real + other.real;
        double imag = this.imag + other.imag;
        return new Complex(real, imag);
    }
    public Complex add(double real){
        return add(new Complex(real,0));
    }

    public Complex subtract(double real){
        return subtract(new Complex(real,0));
    }

    public String toString(){
        return String.format("%f %fi\n", this.real,this.imag);
    }
    public Complex divide(Complex other){
        
    }

    public Complex multiply(Complex other){
        double newReal = 0, newImag = 0;
        newReal = this.real * other.real;
        newReal += -(this.imag * other.imag);
        newImag = this.imag * other.real;
        newImag += this.real * other.imag;
        return new Complex(newReal,newImag);
    }
    public Complex multiply(double real){
        return multiply(new Complex(real,0));
    }
    
}
