import java.util.Scanner;

class NegEx extends Exception { 
    NegEx(String s) { super(s); } 
}

class Q8_Exception {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter num and den: ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            if (a < 0 || b < 0) throw new NegEx("Negative Input Found");
            System.out.println("Result: " + (a / b));
            
        } catch (ArithmeticException e) {
            System.out.println("Error: Divide by Zero");
        } catch (NegEx e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}