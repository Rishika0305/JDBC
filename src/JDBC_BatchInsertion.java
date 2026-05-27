import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC_BatchInsertion {
	public static void main(String[] args) throws Exception{
		Connection con = DBConn.getConn();
		Statement stmt = con.createStatement();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter how many employees you want to insert: ");
		int n =sc.nextInt();
		sc.nextLine();
		for(int i = 1; i <= n; i++) {
			System.out.println("\nEnter details for Employee: " + i + "");
			System.out.println("Enter empid: ");
			String empid = sc.nextLine();
			System.out.println("Enter empname: ");
			String empname = sc.nextLine();
			System.out.println("Enter department: ");
			String department = sc.nextLine();
			System.out.print("Enter Salary: ");
			double salary = sc.nextDouble();
			sc.nextLine();
			//Add SQL Query to batch
			String query = "INSERT INTO employee(empid, empname, department, salary)VALUES ('"+empid+"','"+empname+ "','"+department+"',"+salary+")";
			stmt.addBatch(query);
		}
		//Execute all queries as a batch
		int[] result = stmt.executeBatch();
		//Output message
		System.out.println("\n " + result.length + " records inserted successfully.");
		//Close resources
		stmt.close();
		con.close();
		sc.close();
	}
}
