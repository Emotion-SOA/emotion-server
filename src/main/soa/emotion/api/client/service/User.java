package emotion.api.client.service;

/**
 * Created by mayezhou on 2017/4/23.
 */

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
