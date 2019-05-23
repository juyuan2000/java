package com.djs.util;

import java.sql.ResultSet;

public class CrudTemplate {
	private DButil db = DButil.getInstance();
	
	public void update (String sql, Object...values) {
		db.connection();
		db.pre(sql, values);
		db.executeUpdate();
		db.close();
	}
	
	public ResultSet query (String sql,Object...values ) {
		db.connection();
		db.pre(sql, values);
		ResultSet rs = db.executeQuery();
		db.close();
		return rs;
	}

}
