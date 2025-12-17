import java.util.Scanner;


abstract class Bank {
    String name; int accNo; double bal;
    Scanner sc = new Scanner(System.in);


    void read() {
        System.out.print("Enter Name, AccNo, Balance: ");
        name = sc.next(); accNo = sc.nextInt(); bal = sc.nextDouble();
    }
    
    void show(String bName, double rate) {
        System.out.println("Name: " + name + " | Acc: " + accNo + " | Bal: " + bal);
        System.out.println(bName + " (" + (rate * 100) + "%) Interest: " + (bal * rate));
    }
    abstract void calcInterest();
}


class CityBank extends Bank { void calcInterest() { show("City Bank", 0.05); } }
class SBIBank extends Bank { void calcInterest() { show("SBI Bank", 0.06); } }
class CanaraBank extends Bank { void calcInterest() { show("Canara Bank", 0.055); } }


public class Prog6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank b = null;
        for (int ch = 0; ch != 4; ) {
            System.out.print("\n1.City 2.SBI 3.Canara 4.Exit\nSelect: ");
            ch = sc.nextInt();
            if (ch == 4) break;
            
            if (ch == 1) b = new CityBank();
            else if (ch == 2) b = new SBIBank();
            else if (ch == 3) b = new CanaraBank();
            else { System.out.println("Invalid"); continue; }


            b.read();
            b.calcInterest();
        }
    }
}
