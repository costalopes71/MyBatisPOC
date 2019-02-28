package com.costalopes.mybatispoc.persistence.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.costalopes.mybatispoc.model.Agrupamento;

@Mapper
public interface CommonsDAO {
	
	public List<Agrupamento> getAllAgrupamento();
	
}
