import java.sql.*;

class Q10_JDBC {
    public static void main(String[] args) {
        try {
            // Adjust url, user, password
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "");
            Statement s = c.createStatement();

            System.out.println("Creating...");
            s.executeUpdate("INSERT INTO emp VALUES(101, 'John')");
            
            System.out.println("Reading...");
            ResultSet rs = s.executeQuery("SELECT * FROM emp");
            while(rs.next()) System.out.println(rs.getInt(1) + " " + rs.getString(2));
            
            System.out.println("Updating...");
            s.executeUpdate("UPDATE emp SET name='Doe' WHERE id=101");
            
            System.out.println("Deleting...");
            s.executeUpdate("DELETE FROM emp WHERE id=101");
            
            c.close();
        } catch(Exception e) { System.out.println(e); }
    }
}