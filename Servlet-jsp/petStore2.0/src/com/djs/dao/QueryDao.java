package com.djs.dao;

import java.sql.*;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.djs.entity.Pet;

import java.sql.Connection;

public class QueryDao {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs= null;
	String sql;      
	String url = "jdbc:mysql://120.55.201.129:3306/petstore?useSSL=false";
	String userName = "root";
	String passWord = "Juyuan689";
	Pet p ;
	List<Pet> petList = new LinkedList();
	
			
	 
	  public List<Pet> query() {
	         try {
//	        	 Class.forName("org.gjt.mm.mysql.Driver");            
	             Class.forName("com.mysql.jdbc.Driver");            
	             conn = DriverManager.getConnection(url,userName,passWord);
	             stmt = conn.createStatement();
	             sql="select * from pet";
	             String sql2 = sql;
	             ResultSet rs= stmt.executeQuery(sql2);
	             
//	             p = new Pet(id, kind, color, price)
	             while(rs.next()) {
	            	 p = new Pet(
	            			 rs.getInt("id"),
	            			 rs.getString("kind"),
	            			 rs.getString("color"),
	            			 rs.getDouble("price")
	            			 );
	            	 petList.add(p);
	           System.out.println(p);
	            	 
	             }
	             
	         } catch (SQLException e) {
	             System.out.println("MySQL操作错误");
	             e.printStackTrace();
	         } catch (Exception e) {
	             e.printStackTrace();
	         } 
//	             finally {
//	             try {
////					  rs.close();
////					  stmt.close();
////					  conn.close();
//					  } catch (SQLException e) {
//					  // TODO Auto-generated catch block
//					  e.printStackTrace();
//					  }
//	         		}
//	         System.out.println("666"+ PetL);
	         return petList;
	  }
}

