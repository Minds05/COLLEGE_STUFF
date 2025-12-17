abstract class Bank {
    abstract void calcInterest();
}
class City extends Bank { void calcInterest() { System.out.println("City Bank: 5%"); } }
class SBI extends Bank { void calcInterest() { System.out.println("SBI Bank: 6%"); } }
class Canara extends Bank { void calcInterest() { System.out.println("Canara Bank: 7%"); } }

class Q6_Bank {
    public static void main(String[] args) {
        new City().calcInterest();
        new SBI().calcInterest();
        new Canara().calcInterest();
    }
}