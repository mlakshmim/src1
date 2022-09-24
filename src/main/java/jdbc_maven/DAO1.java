package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO1 {
	
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";
	Connection con = null;
	// PreparedStatement ps=null;

	public String savePerson(Person p) {
		String query = "insert into person values(?,?,?,?,?)";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, p.getId());
			ps.setString(2,p.getName());
			ps.setString(3, p.getAdress());
			ps.setLong(4, p.getPhone());
			ps.setInt(5, p.getPincode());
			int rows = ps.executeUpdate();
			if (rows == 1) {
				return "saved";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return "Not saved";
	}

	public String updatePerson(Person p) {
		String query = "update person set name=? where id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, p.getName());
			ps.setInt(2, p.getId());

			int rows = ps.executeUpdate();
			
				return "Updated";
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return "Not Updated";
	}
     
	public Person getPerson(int id) {
		String query = "select * from person where id=?";
		Person p=new Person();
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("============================");
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setAdress(rs.getString(3));
				p.setPhone(rs.getLong(4));
				p.setPincode(rs.getInt(5));
				
				System.out.println("============================");
				return p;
			}
			//return Person;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

}
