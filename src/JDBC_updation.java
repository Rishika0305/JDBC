import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC_updation {
    public static void main(String[] args) throws Exception {
        // Connect to DB
        Connection con = DBConn.getConn();
        Statement stmt = con.createStatement();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter empid to update:");
        String empid = sc.nextLine();

        System.out.println("Enter new salary:");
        double newSalary = sc.nextDouble();

        // Build and execute update query
        int rowsAffected = stmt.executeUpdate("UPDATE employee SET salary = " + newSalary + " WHERE empid = " + empid);
        // Show result
        if (rowsAffected > 0)
            System.out.println("Record updated successfully.");
        else
            System.out.println("Employee ID not found. Update failed.");

        // Close connections
        stmt.close();
        con.close();
        sc.close();
    }
}