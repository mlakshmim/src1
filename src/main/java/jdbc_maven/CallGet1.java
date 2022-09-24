package jdbc_maven;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallGet1 {

	public static void main(String[] args) {
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprc","root","root");
				CallableStatement c=con.prepareCall("call get_studet1(?)");
				c.setInt(1, 3);
				ResultSet rs=c.executeQuery();
				while(rs.next()) {
				System.out.print(rs.getInt(1));
				System.out.print(rs.getString(2));
				System.out.print(rs.getLong(3));
				System.out.print(rs.getString(4));
				System.out.println(rs.getInt(5));
				}
				
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
