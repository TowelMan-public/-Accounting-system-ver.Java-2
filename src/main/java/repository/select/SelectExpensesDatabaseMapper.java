package repository.select;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import entity.select.GroupResultEntity;

@Mapper
public interface SelectExpensesDatabaseMapper {
	//グループ検索
	List<GroupResultEntity> selectGroup(BaseEarningstDto form);
	
	//普通に羅列の検索
	List<BaseEarningsResultEntity> selectList(BaseEarningstDto form);
}
