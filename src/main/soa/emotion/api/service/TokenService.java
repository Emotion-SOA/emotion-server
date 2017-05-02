package emotion.api.service;


import org.springframework.util.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lifengshuang on 29/04/2017.
 */
public class TokenService {

    private static int count = 0;
    private static Map<String, UserInfo> tokenData = new HashMap<>();

    public static String generateToken(String username, int userID) {
        long time = System.currentTimeMillis();
        String key = "Emotion API" + time + username + count;
        count++;
        String token = DigestUtils.md5DigestAsHex(key.getBytes());
        tokenData.put(token, new UserInfo(username, time, userID));
        return token;
    }

    public static String getUsername(String token) {
        UserInfo userInfo = tokenData.get(token);
        if (userInfo == null) {
            return null;
        } else {
            return userInfo.getUsername();
        }
    }

    public static int getUserID(String token) {
        UserInfo userInfo = tokenData.get(token);
        if (userInfo == null) {
            return -1;
        } else {
            return userInfo.getUserID();
        }
    }

    private static class UserInfo {
        private String username;
        private long latestVisitTime;
        private int userID;

        public UserInfo(String username, long latestVisitTime, int userID) {
            this.username = username;
            this.latestVisitTime = latestVisitTime;
        }

        public String getUsername() {
            return username;
        }

        public long getLatestVisitTime() {
            return latestVisitTime;
        }

        public int getUserID() {
            return userID;
        }
    }
}
