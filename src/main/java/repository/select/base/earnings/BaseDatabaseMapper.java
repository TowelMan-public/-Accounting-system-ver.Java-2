package repository.select.base.earnings;

import java.util.List;

import entity.select.GroupResultEntity;

public interface BaseDatabaseMapper {
	//グループ検索
	List<GroupResultEntity> selectGroup(BaseEarningstDto form);
	
	//普通に羅列の検索
	List<BaseEarningsResultEntity> selectList(BaseEarningstDto form);
}
