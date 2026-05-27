import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
public class JDBC_insertion {
	public static void main(String[] args) throws Exception{
		Connection con = DBConn.getConn();
		Statement stmt = con.createStatement();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter empid:");
		String empid = sc.nextLine();
		System.out.println("Enter empname:");
		String empname = sc.nextLine();
		System.out.println("Enter department:");
		String department = sc.nextLine();
		System.out.println("Enter salary:");
		double salary = sc.nextDouble();
		int i = stmt.executeUpdate("INSERT INTO employee (empid, empname, department, salary) VALUES ('" + empid + "', '" + empname + "', '" + department + "', " + salary + ")");
		if(i == 1)
			System.out.println("Record inserted successfully");
		else
			System.out.println("Insertion failed.");
		stmt.close();
		con.close();
		sc.close();
	}
}