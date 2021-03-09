package com.example.demo.repository.select.base.earnings;

import java.util.List;

import com.example.demo.dto.select.BaseEarningstDto;
import com.example.demo.entity.select.BaseEarningsResultEntity;
import com.example.demo.entity.select.GroupResultEntity;

public interface BaseEarningsMapper {
	//グループ検索
	List<GroupResultEntity> selectGroup(BaseEarningstDto form);
	
	//普通に羅列の検索
	List<BaseEarningsResultEntity> selectList(BaseEarningstDto form);
}
