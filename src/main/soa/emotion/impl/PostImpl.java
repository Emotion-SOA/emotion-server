package emotion.impl;

import emotion.service.Post;

import javax.xml.bind.annotation.XmlType;
import java.util.Date;

/**
 * Created by mayezhou on 2017/4/23.
 */
@XmlType(name = "Post")
public class PostImpl implements Post {
    int postID;
    String text;
    Date publishTime;
    float longtitude;
    float latitude;
    int userID;

    public PostImpl(String text, float longtitude, float latitude, int userID) {
        this.text = text;
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.userID = userID;
    }

    public PostImpl(int postID, String text, Date publishTime, float longtitude, float latitude, int userID) {
        this.postID = postID;
        this.text = text;
        this.publishTime = publishTime;
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.userID = userID;
    }

    public PostImpl() {
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public void setLongtitude(float longtitude) {
        this.longtitude = longtitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public int getPostID() {
        return postID;
    }

    public String getText() {
        return text;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public float getLongtitude() {
        return longtitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public int getUserID() {
        return userID;
    }
}
