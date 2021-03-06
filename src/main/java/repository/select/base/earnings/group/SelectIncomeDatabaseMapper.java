package repository.select.base.earnings.group;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dto.select.BaseEarningsGroupDto;
import entity.select.GroupResultEntity;

@Mapper
public interface SelectIncomeDatabaseMapper extends BaseDatabaseMapper {
	//グループ検索
	@Override
	List<GroupResultEntity> selectGroup(BaseEarningsGroupDto form);
}