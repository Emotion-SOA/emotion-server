package emotion.impl;


import emotion.service.User;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by mayezhou on 2017/4/23.
 */
public class UserAdapter extends XmlAdapter<UserImpl, User> {
    public UserImpl marshal(User v) throws Exception {
        if (v == null) {
            return null;
        } else if (v instanceof UserImpl) {
            return (UserImpl)v;
        } else {
            return new UserImpl(v.getUserID(), v.getEmail(), v.getPassword(), v.getName());
        }
    }

    public User unmarshal(UserImpl v) throws Exception {
        return v;
    }
}
