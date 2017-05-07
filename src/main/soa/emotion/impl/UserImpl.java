package emotion.impl;


import emotion.service.User;

import javax.xml.bind.annotation.XmlType;

/**
 * Created by mayezhou on 2017/4/23.
 */
@XmlType(name = "User")
public class UserImpl implements User{
    int userID;
    String email;
    String password;
    String name;

    public UserImpl(int userID, String email, String password, String name) {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public UserImpl() {
    }

    public UserImpl(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

}
