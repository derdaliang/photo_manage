package photoCurd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import photoCurd.bean.*;
import photoCurd.dao.PhotoMapper;
import photoCurd.dao.likeListMapper;
import photoCurd.dao.starListMapper;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author lixuefeng
 * @date 2021-08-22 23:25
 * @description:
 */
@Service
public class PhotoService {
    @Autowired
    private PhotoMapper photoMapper;
    @Autowired
    private likeListMapper likeListMapper;
    @Autowired
    private starListMapper starListMapper;

    public void addPhoto(Photo photo){

        photoMapper.insert(photo);
    }

    //添加喜欢
    public synchronized int addLike(Photo photo, User user){
        photoMapper.addLikeCount(photo);
        likeList likeList=new likeList( user.getId(), photo.getPhotoId(),new Date(),new Date());
        likeListMapper.insert(likeList);
        return photo.getLikeCount();
    }

    /**
     * 取消喜欢
     * @param photo
     * @param user
     * @return 喜欢数
     */
    public synchronized int removeLike(Photo photo, User user){
        photoMapper.reduceLikeCount(photo);
        likeListExample example=new likeListExample();
        likeListExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(user.getId()).andPhotoIdEqualTo(photo.getPhotoId());
        likeListMapper.deleteByExample(example);
        return photo.getLikeCount();
    }

    /**
     * 收藏
     * @param photo
     * @param user
     * @return
     */
    public synchronized int addStar(Photo photo, User user){
        photoMapper.addStarCount(photo);
        starList starList=new starList( user.getId(), photo.getPhotoId(),new Date(),new Date());
        starListMapper.insert(starList);
        return photo.getStarCount();
    }

    /**
     * 取消收藏
     * @param photo
     * @param user
     * @return
     */
    public synchronized int removeStar(Photo photo, User user){
        photoMapper.reduceStarCount(photo);
        starListExample starListExample=new starListExample();
        photoCurd.bean.starListExample.Criteria criteria = starListExample.createCriteria();
        criteria.andPhotoIdEqualTo(photo.getPhotoId()).andUserIdEqualTo(user.getId());
        starListMapper.deleteByExample(starListExample);
        return photo.getStarCount();
    }

    public List<Photo> searchPhotoByUser(User user) {
        PhotoExample example=new PhotoExample();
        PhotoExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(user.getId());
        return photoMapper.selectByExample(example);
    }
}
