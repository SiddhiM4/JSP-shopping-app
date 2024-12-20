package shop.service;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;

import shop.model.Product;

public class ProductService {
	
	public Connection myConnection(){
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","123456789");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;	
	}
	
	public int createProduct(Product prodobj) {
		Connection con = myConnection();
		int i = 0;
		try {
			i = 0;
			
			PreparedStatement pstate = con.prepareStatement("insert into productdb values(?,?,?,?)");
			pstate.setInt(1, prodobj.getPid());
			pstate.setString(2, prodobj.getPname());
			pstate.setFloat(3, prodobj.getPprice());
			pstate.setInt(4, prodobj.getPqty());
			
			i = pstate.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public List<Product> retrieveProduct(int pid) {
		List<Product> lstprod=null;
		int i =0;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","123456789");
			PreparedStatement pstate = con.prepareStatement("select * from productdb where product_id = ?");
			pstate.setInt(1, pid);
			
			ResultSet result = pstate.executeQuery();
			if (result.next()) {
				Product prodobj = new Product();
	            prodobj.setPid(result.getInt(1));
	            prodobj.setPname(result.getString(2));
	            prodobj.setPprice(result.getFloat(3));
	            prodobj.setPqty(result.getInt(4));
	            
	            lstprod = new ArrayList<Product>();
	            lstprod.add(prodobj);
	        }
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lstprod;
	}
	
	public int deleteProduct(int pid) {
		int i = 0;
		Connection con = myConnection();
		
		try {
			PreparedStatement pstate = con.prepareStatement("delete from productdb where product_id = ?");
			pstate.setInt(1, pid);
			
			i = pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public int updateProduct(int pid,float pprice) {
		int i = 0;
		Connection con = myConnection();
		
		try {
			PreparedStatement pstate = con.prepareStatement("update productdb set product_price=? where product_id= ?");
			pstate.setFloat(1, pprice);
			pstate.setInt(2, pid);
			i = pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	
	public List<Product> getAllProduct(){
		Connection con = myConnection();
		String str = "select * from productdb";
		List<Product> lstprod = null;
		Product prodobj =  new Product();
		
		try {
			Statement state = con.createStatement();
			ResultSet result = state.executeQuery(str);
			lstprod = new ArrayList<Product>();
			while(result.next()) {
				
				Product prod = new Product();
				prod.setPid(result.getInt(1));
			    prod.setPname(result.getString(2));
			    prod.setPprice(result.getFloat(3));
			    prod.setPqty(result.getInt(4));
			    
			    lstprod.add(prod);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstprod;
		
	}
}
