package com.costalopes.mybatispoc;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.costalopes.mybatispoc.model.Agrupamento;
import com.costalopes.mybatispoc.persistence.MyBatisConnection;
import com.costalopes.mybatispoc.persistence.dao.CommonsDAO;

public class UsageExample {

	public static void main(String[] args) {
		
//		MyBatisConnection myBatis = new MyBatisConnection();
		
		SqlSession session = MyBatisConnection.getSqlSession("/home/joao/Documentos/workspaces/POCs_workspace/POCMyBatisWithSqlite_workspace/docs/commons.med");
		
		List<Agrupamento> agrupamentos = session.getMapper(CommonsDAO.class).getAllAgrupamento();
		
		agrupamentos.forEach(System.out::println);
		
		
//		SqlSession session2 = myBatis.getSqlSession();
//		
//		List<Agrupamento> agrupamentos2 = session2.getMapper(Commons.class).getAllAgrupamento();
//		
//		System.out.println("\nteste");
//		agrupamentos2.forEach(System.out::println);
		
	}
	
}
