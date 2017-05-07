package emotion.service;

import emotion.impl.PostAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * Created by mayezhou on 2017/4/23.
 */
@XmlJavaTypeAdapter(PostAdapter.class)
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
