package photoCurd.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class likeList {
    private Integer likeId;

    private Integer userId;

    private String photoId;
    @JsonFormat(pattern = "HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    public likeList() {
    }

    public likeList(Integer userId, String photoId, Date createTime, Date createDate) {
        this.userId = userId;
        this.photoId = photoId;
        this.createTime = createTime;
        this.createDate = createDate;
    }

    public Integer getLikeId() {
        return likeId;
    }

    public void setLikeId(Integer likeId) {
        this.likeId = likeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId == null ? null : photoId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}