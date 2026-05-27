import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class JDBC_selection {
	public static void main(String[] args) throws Exception{
		Connection con = DBConn.getConn();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from employee");
		System.out.println("empid\tempname\t\tdepartment\tsalary");
		System.out.println("-----------------------");
		while(rs.next()) {
			String empid = rs.getString("empid");
			String empname = rs.getString("empname");
			String department = rs.getString("department");
			String salary = rs.getString("salary");
			System.out.println(empid + "\t" + empname + "\t" + department + "\t" + salary);
		}
		rs.close();
		stmt.close();
		con.close();
		
	}
}
