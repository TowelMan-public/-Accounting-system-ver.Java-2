package com.example.demo.select.company;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.example.demo.select.GroupResultForm;

@Mapper//TODO 実装
public interface DatabaseMapper {
	//普通に羅列の検索
	List<ResultForm> selectList(SelectForm form);
}
