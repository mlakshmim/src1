package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BatchExecution {

	public static void main(String[] args) {
		List<Person> l = new ArrayList();
		Person p = new Person(81, "q", "w", 8956, 88);
		Person p1 = new Person(273, "l", "k", 4886, 99);
		Person p2 = new Person(74, "z", "p", 147, 06);
		Person p3 = new Person(65, "v", "a", 143, 05);
		Person p4 = new Person(95, "n", "m", 911, 04);
		l.add(p);
		l.add(p1);
		l.add(p2);
		l.add(p3);
		l.add(p4);

		String path = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbcprc";
		String username = "root";
		String password = "root";
		Connection con = null;
		String query = "insert into person values(?,?,?,?,?)";

		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			for (Person p5 : l) {
				ps.setInt(1, p5.getId());
				ps.setString(2, p5.getName());
				ps.setString(3, p5.getAdress());
				ps.setLong(4, p5.getPhone());
				ps.setInt(5, p5.getPincode());

				ps.addBatch();
			}
			ps.executeBatch();
			
			System.out.println("All data saved");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
