class Complex {
    private int r, i;
    Complex(int real, int img) { r = real; i = img; }
    void show() { System.out.println(r + "+" + i + "i"); }
    
    // Static methods for operations
    static Complex add(Complex a, Complex b) { return new Complex(a.r + b.r, a.i + b.i); }
    static Complex sub(Complex a, Complex b) { return new Complex(a.r - b.r, a.i - b.i); }
}

public class Q3_Complex {
    public static void main(String[] args) {
        Complex c1 = new Complex(4, 5), c2 = new Complex(2, 2);
        Complex.add(c1, c2).show(); // 6+7i
        Complex.sub(c1, c2).show(); // 2+3i
    }
}