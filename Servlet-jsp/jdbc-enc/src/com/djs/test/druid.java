package com.djs.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.djs.entity.Pet;
import com.djs.util.CrudTemplate;

public class druid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sql = "select * from pet_table";
		CrudTemplate ct = new CrudTemplate();
		ResultSet rs = ct.query(sql);
		try {
			while (rs.next()) {
				Pet p = new Pet(
				rs.getInt("id"),
				rs.getString("color"),
				rs.getString("name")
				);
				
			System.out.println(p);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}