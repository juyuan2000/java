package com.djs.util;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {

	private static MybatisUtil instance = new MybatisUtil();
	private SqlSessionFactory sessionFactory;

	private MybatisUtil() {
		 init();
	}

	public static MybatisUtil getInstance() {
		return instance;
	}

	private void init() {
		try {
			this.sessionFactory = new SqlSessionFactoryBuilder()
					.build(Resources.getResourceAsStream("config\\configuration.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public SqlSession getSqlSession() {
		return this.sessionFactory.openSession();
	}

}
