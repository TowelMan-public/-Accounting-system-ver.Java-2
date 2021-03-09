package com.example.demo.repository.select;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.select.CompanyDto;
import com.example.demo.entity.select.CompanyResultEntity;

@Mapper
public interface SelectCompanyMapper {
	//普通に羅列の検索
	List<CompanyResultEntity> selectList(CompanyDto form);
}
