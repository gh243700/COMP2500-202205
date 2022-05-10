package academy.pocu.comp2500.lab2;

public class ComplexNumber {
    public double real;
    public double imaginary;

    public ComplexNumber() {
    }

    public ComplexNumber(double real) {
        this.real = real;
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public boolean isReal() {
        return (imaginary == 0) ? true : false;
    }

    public boolean isImaginary() {
        return (real == 0) ? true : false;
    }

    public ComplexNumber getConjugate() {
        return new ComplexNumber(real, -imaginary);
    }

    public ComplexNumber add(ComplexNumber num) {
        return new ComplexNumber(real + num.real, imaginary + num.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber num) {
        return new ComplexNumber(real - num.real, imaginary - num.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber num) {
        return new ComplexNumber(real * num.real - imaginary * num.imaginary, real * num.imaginary + imaginary * num.real);
    }

    public ComplexNumber divide(ComplexNumber num) {
        double n = num.real * num.real + num.imaginary * num.imaginary;
        ComplexNumber mul = multiply(num.getConjugate());
        return new ComplexNumber(mul.real / n, mul.imaginary / n);
    }

}
