package repository.select;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dto.select.BaseEarningstDto;
import entity.select.BaseEarningsResultEntity;
import entity.select.GroupResultEntity;
import repository.select.base.earnings.BaseDatabaseMapper;

@Mapper
public interface SelectEarningsDatabaseMapper extends BaseDatabaseMapper {
	//グループ検索
	@Override
	List<GroupResultEntity> selectGroup(BaseEarningstDto form);
	
	//普通に羅列の検索
	@Override
	List<BaseEarningsResultEntity> selectList(BaseEarningstDto form);
}