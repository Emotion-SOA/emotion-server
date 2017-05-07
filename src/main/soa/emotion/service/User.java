package emotion.service;

import emotion.impl.UserAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by mayezhou on 2017/4/23.
 */
@XmlJavaTypeAdapter(UserAdapter.class)
public interface User {
    int getUserID();

    void setUserID(int userID);

    String getPassword();

    void setPassword(String password);

    String getName();

    void setName(String name);

    String getEmail();

    void setEmail(String email);
}
