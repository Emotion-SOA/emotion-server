package emotion.api.client.service;

import java.util.Date;

/**
 * Created by mayezhou on 2017/4/23.
 */

public interface Post {
    int getPostID() ;

    void setPostID(int postID);

    String getText() ;

    void setText(String text);

    Date getPublishTime() ;

    void setPublishTime(Date publishTime);

    float getLongtitude() ;

    void setLongtitude(float longtitude);

    float getLatitude() ;

    void setLatitude(float latitude);

    int getUserID();

    void setUserID(int userID);
    
}
