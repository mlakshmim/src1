package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	

	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";
	Connection con = null;
	
	public Product saveProduct(Product p) {
		String query="insert into product values(?,?,?,?,?,?,?,?)";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,p.getPid());
			ps.setString(2, p.getPname());
			ps.setDouble(3, p.getPrice());
			ps.setString(4, p.getManufacture());
			ps.setDouble(5,p.getDiscount());
			ps.setInt(6, p.getWarnty());
			ps.setString(7, p.getMdate());
			ps.setDouble(8, p.getGst());
			int a=ps.executeUpdate();
			if(a==1) {
				System.out.println("Saved");
				return p;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return p;
		
		 
	}
    
	public Product updateProduct(Product p) {
		String query="update product set pname=? where pid=?";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, p.getPname());
			ps.setInt(2,p.getPid());
			
			int a=ps.executeUpdate();
			if(a==1) {
				System.out.println("Updated");
				return p;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return p;
		
		 
	}
	public Product getProduct(Product p) {
		String query="select * from product where pid=?";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setInt(1,p.getPid());
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("============================");
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				p.setManufacture(rs.getString(4));
				p.setDiscount(rs.getDouble(5));
				p.setWarnty(rs.getInt(6));
				p.setMdate(rs.getString(7));
				p.setGst(rs.getDouble(8));
				System.out.println("============================");
				return p;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return p;
		
		 
	}
	public String deleteProduct(int id) { 
		String query="delete from product where pid=?";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setInt(1,id);
			int a=ps.executeUpdate();
			if(a==1) {
			//System.out.println("deleted");
				return "deleted";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try { 
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}  
		return null;
		
		 
	}
	public List<Product> getAllStudent(){
		String query="select * from  product";
		
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			List<Product> l=new ArrayList();
			while(rs.next()) {
				Product p=new Product();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				p.setManufacture(rs.getString(4));
				p.setDiscount(rs.getDouble(5));
				p.setWarnty(rs.getInt(6));
				p.setMdate(rs.getString(7));
				p.setGst(rs.getDouble(8));
				l.add(p);
			}
			return l;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	
		
		
		
		
	}
}
