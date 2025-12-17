import java.util.*;
class Quad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a, b, c:");
        double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble();
        double d = b * b - 4 * a * c;

        if (d > 0) 
            System.out.println("Roots: " + ((-b + Math.sqrt(d))/(2*a)) + ", " + ((-b - Math.sqrt(d))/(2*a)));
        else if (d == 0) 
            System.out.println("Root: " + (-b / (2 * a)));
        else 
            System.out.println("Roots are imaginary.");
    }
}