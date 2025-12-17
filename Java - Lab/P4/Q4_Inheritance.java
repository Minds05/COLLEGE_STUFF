class Person {
    String name; int age;
    Person(String n, int a) { name=n; age=a; }
}
class Student extends Person {
    String grade;
    Student(String n, int a, String g) { super(n, a); grade=g; }
    void display() { System.out.println("Student: " + name + ", Grade: " + grade); }
}
class Employee extends Person {
    double salary;
    Employee(String n, int a, double s) { super(n, a); salary=s; }
    void display() { System.out.println("Employee: " + name + ", Salary: " + salary); }
}

class Q4_Inheritance {
    public static void main(String[] args) {
        Student[] s = { new Student("S1", 20, "A"), new Student("S2", 21, "B") };
        Employee[] e = { new Employee("E1", 30, 50000), new Employee("E2", 35, 60000) };
        
        for(Student st : s) st.display();
        for(Employee em : e) em.display();
    }
}