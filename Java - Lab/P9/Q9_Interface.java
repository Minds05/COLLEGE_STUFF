import java.util.Scanner;

interface Compute { 
    void convert(double val); 
}
class GBtoBytes implements Compute {
    public void convert(double val) { 
        System.out.println(val + " GB = " + (val * 1024 * 1024 * 1024) + " Bytes"); 
    }
}
class EuroToRupee implements Compute {
    public void convert(double val) { 
        System.out.println(val + " Euro = " + (val * 90) + " Rupees"); 
    }
}
class Q9_Interface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a, b:");
        double a = sc.nextDouble(), b = sc.nextDouble();
        new GBtoBytes().convert(a);
        new EuroToRupee().convert(b);
    }
}