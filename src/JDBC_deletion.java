import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
        public class JDBC_deletion {
     public static void main(String[] args) throws Exception {
         // Connect to DB
         Connection con = DBConn.getConn();
         Statement stmt = con.createStatement();
         Scanner sc = new Scanner(System.in);
         
         System.out.println("Enter empid to delete:");
         String empid = sc.nextLine();

                 // Build and execute update query
         int rowsAffected = stmt.executeUpdate("delete from employee  WHERE empid = '" + empid + "'");

         // Show result
         if (rowsAffected > 0)
             System.out.println("Record deleted successfully.");
         else
             System.out.println("Employee ID not found.failed.");

         // Close connections
         stmt.close();
         con.close();
         sc.close();
     }
 }