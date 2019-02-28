package com.costalopes.mybatispoc.persistence;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.sqlite.SQLiteDataSource;

public class MyBatisConnection {

	
	//
	// atributos da classe
	//
	private static Map<String, SqlSession> sessionsMap = new HashMap<>();
	private static final String CONNECTION_URL = "jdbc:sqlite:" ;
	
	//
	// atributos da instancia
	//
	
	static {
		
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private MyBatisConnection() {
		
	}
	
	public static SqlSession getSqlSession(String sqliteFileName) {
		
		if (sessionsMap.containsKey(sqliteFileName)) {
			return sessionsMap.get(sqliteFileName);
		}
		
		SQLiteDataSource dataSource = new SQLiteDataSource();
		dataSource.setUrl(CONNECTION_URL + sqliteFileName);
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment enviroment = new Environment("dev", transactionFactory, dataSource);
		Configuration config = new Configuration(enviroment);
		
		config.addMappers("com.costalopes.mybatispoc.persistence.dao");
		
		sessionsMap.put(sqliteFileName, new SqlSessionFactoryBuilder().build(config).openSession());
		
		return sessionsMap.get(sqliteFileName);
	}
	
}
