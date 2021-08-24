package photoCurd.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import photoCurd.bean.Photo;
import photoCurd.bean.PhotoExample;

public interface PhotoMapper {
    long countByExample(PhotoExample example);

    int deleteByExample(PhotoExample example);

    int deleteByPrimaryKey(String photoId);

    int insert(Photo record);

    int insertSelective(Photo record);

    List<Photo> selectByExample(PhotoExample example);

    Photo selectByPrimaryKey(String photoId);

    int updateByExampleSelective(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByExample(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByPrimaryKeySelective(Photo record);

    int updateByPrimaryKey(Photo record);

    int addLikeCount(@Param("record") Photo photo);

    int reduceLikeCount(@Param("record")Photo photo);

    int addStarCount(@Param("record")Photo photo);

    int reduceStarCount(@Param("record")Photo photo);
}