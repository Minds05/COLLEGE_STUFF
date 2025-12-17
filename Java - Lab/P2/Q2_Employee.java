class Emp {
    String name, dept, desig; int id; double sal;
    Emp(String n, int i, String dp, double s, String ds) {
        name=n; id=i; dept=dp; sal=s; desig=ds;
    }
}

public class Q2_Employee {
    public static void main(String[] args) {
        Emp[] e = {
            new Emp("A", 1, "Sales", 5000, "Mgr"),
            new Emp("B", 2, "Sales", 6000, "Clerk"),
            new Emp("C", 3, "Purchase", 9000, "Manager")
        };
        
        // b) Sum Salary of Sales
        double sum = 0;
        for(Emp x : e) if(x.dept.equals("Sales")) sum += x.sal;
        System.out.println("Sales Sum: " + sum);

        // c) Highest Paid Manager in Purchase
        double max = 0; String name = "";
        for(Emp x : e) 
            if(x.dept.equals("Purchase") && x.desig.equals("Manager") && x.sal > max) {
                max = x.sal; name = x.name;
            }
        System.out.println("Top Purchase Mgr: " + name);
    }
}