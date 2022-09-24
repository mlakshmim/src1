package jdbc_maven;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallDemo {

	public static void main(String[] args) {
      try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprc","root","root");
		CallableStatement c=con.prepareCall("call save_student(?,?,?,?,?)");
		c.setInt(1, 10);
		c.setString(2, "ramu");
		c.setLong(3, 987456);
		c.setString(4, "ndg");
		c.setInt(5, 562314);
		c.execute();
		System.out.println("Saved");
		c.close();
		con.close();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
      
	}

}
