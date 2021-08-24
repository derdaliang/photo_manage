package photoCurd.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import photoCurd.bean.starList;
import photoCurd.bean.starListExample;

public interface starListMapper {
    long countByExample(starListExample example);

    int deleteByExample(starListExample example);

    int deleteByPrimaryKey(Integer starId);

    int insert(starList record);

    int insertSelective(starList record);

    List<starList> selectByExample(starListExample example);

    starList selectByPrimaryKey(Integer starId);

    int updateByExampleSelective(@Param("record") starList record, @Param("example") starListExample example);

    int updateByExample(@Param("record") starList record, @Param("example") starListExample example);

    int updateByPrimaryKeySelective(starList record);

    int updateByPrimaryKey(starList record);
}