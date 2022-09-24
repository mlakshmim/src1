package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MobileDAO {
	
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";
	Connection con = null;
	public String saveMobile(Mobile m) {
		String query = "insert into mobile1 values(?,?,?,?,?,?,?)";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, m.getId());
			ps.setString(2,m.getName());
			ps.setString(3, m.getBrand());
			ps.setString(4, m.getColour());
			ps.setDouble(5, m.getPrice());
			ps.setInt(6, m.getRam());
			ps.setString(7, m.getManufacturer());
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
	
	public String updateMobile(Mobile m) {
		String query = "update mobile1 set name=? where id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, m.getName());
			ps.setInt(2, m.getId());

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
	public Mobile getMobile(int id) {
		String query = "select * from person where id=?";
		 Mobile m=new Mobile();
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("============================");
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setBrand(rs.getString(3));
				m.setColour(rs.getString(4));
				m.setPrice(rs.getDouble(5));
				m.setRam(rs.getInt(6));
				m.setManufacturer(rs.getString(7));
				
				System.out.println("============================");
				return m;
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
