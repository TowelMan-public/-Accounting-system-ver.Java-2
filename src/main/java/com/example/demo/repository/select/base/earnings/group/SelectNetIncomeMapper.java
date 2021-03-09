package com.example.demo.repository.select.base.earnings.group;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.select.BaseEarningsGroupDto;
import com.example.demo.entity.select.GroupResultEntity;

@Mapper
public interface SelectNetIncomeMapper extends BaseEarningsGroupMapper {
	//グループ検索
	@Override
	List<GroupResultEntity> selectGroup(BaseEarningsGroupDto form);
}