package repository.select.base.earnings.group;

import java.util.List;

import entity.select.GroupResultEntity;

public interface BaseDatabaseMapper {
	//グループ検索
	List<GroupResultEntity> selectGroup(dto.select.BaseEarningsGroupDto select);
}
