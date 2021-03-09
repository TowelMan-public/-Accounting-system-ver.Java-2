package com.example.demo.repository.select.base.earnings;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.select.BaseEarningstDto;
import com.example.demo.entity.select.BaseEarningsResultEntity;
import com.example.demo.entity.select.GroupResultEntity;

@Mapper
public interface SelectRevenueMapper extends BaseEarningsMapper {
	//グループ検索
	@Override
	List<GroupResultEntity> selectGroup(BaseEarningstDto form);
	
	//普通に羅列の検索
	@Override
	List<BaseEarningsResultEntity> selectList(BaseEarningstDto form);
}