package com.example.demo.repository.select.base.earnings.group;

import java.util.List;

import com.example.demo.dto.select.BaseEarningsGroupDto;
import com.example.demo.entity.select.GroupResultEntity;

public interface BaseEarningsGroupMapper {
	//グループ検索
	List<GroupResultEntity> selectGroup(BaseEarningsGroupDto select);
}
