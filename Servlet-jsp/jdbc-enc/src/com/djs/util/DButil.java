package com.djs.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alibaba.druid.pool.DruidAbstractDataSource;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

public class DButil {
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	ResultSet rs = null;
	Connection conn;
	PreparedStatement pst;
	DruidDataSource ds;
	
	String userName = "lisi";
	String passWord = "lisi";
	private static DButil instance= new DButil();
	
	private DButil () {
		init();
	}
	
	public static DButil getInstance () {
		return instance;
	}
	//实例化Druid对象，并设置url,name,word属性
	private void init () {
		ds = new DruidDataSource();
		ds.setUrl(url);
		ds.setUsername(userName);
		ds.setPassword(passWord);
	}
	
	//建立连接
	public void connection () {-
		try {
			 conn = ds.getConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//创建准备状态
	public void  pre(String sql,Object...values) {
		try {
			pst = conn.prepareStatement(sql);
			//把数组里面的值装进sql里面
			for (int i = 0; i < values.length; i++) {
				pst.setObject(i+1, values[i]);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//执行操作方法
	public void executeUpdate () {
		try {
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 执行查询方法
	public ResultSet executeQuery() {
		
		try {
			rs = pst.executeQuery();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
//关闭 rs pst conn这三个的io	
	public void close () {
		
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void conn() {
		// TODO Auto-generated method stub
		
	}
}
