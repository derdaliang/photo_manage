package photoCurd.bean;

import java.util.Date;

public class Photo {
    private String photoId;

    private String fileName;

    private Integer orderId;

    private Date createTime;

    private Date createDate;

    private Integer likeCount;

    private Integer starCount;

    public Photo() {
    }

    public Photo(String photoId, String fileName, Integer orderId, Date createTime, Date createDate, Integer likeCount, Integer starCount) {
        this.photoId = photoId;
        this.fileName = fileName;
        this.orderId = orderId;
        this.createTime = createTime;
        this.createDate = createDate;
        this.likeCount = likeCount;
        this.starCount = starCount;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId == null ? null : photoId.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getStarCount() {
        return starCount;
    }

    public void setStarCount(Integer starCount) {
        this.starCount = starCount;
    }
}