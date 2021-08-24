package photoCurd.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import photoCurd.bean.likeList;
import photoCurd.bean.likeListExample;

public interface likeListMapper {
    long countByExample(likeListExample example);

    int deleteByExample(likeListExample example);

    int deleteByPrimaryKey(Integer likeId);

    int insert(likeList record);

    int insertSelective(likeList record);

    List<likeList> selectByExample(likeListExample example);

    likeList selectByPrimaryKey(Integer likeId);

    int updateByExampleSelective(@Param("record") likeList record, @Param("example") likeListExample example);

    int updateByExample(@Param("record") likeList record, @Param("example") likeListExample example);

    int updateByPrimaryKeySelective(likeList record);

    int updateByPrimaryKey(likeList record);
}