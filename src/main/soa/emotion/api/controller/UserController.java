package emotion.api.controller;

import emotion.api.client.DatabaseWebserviceClient;
import emotion.service.User;
import emotion.api.request.UserRegisterRequest;
import emotion.api.response.ErrorResponse;
import emotion.api.service.TokenService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * Created by lifengshuang on 24/04/2017.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public @ResponseBody Object login(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
        try {
            User user = DatabaseWebserviceClient.getDB().getUser(email);
            if (user.getPassword().equals(password)) {
                return new UserResponse(email, user.getUserID());
            } else {
                return new ErrorResponse("Password is incorrect");
            }
        } catch (Exception e) {
            return new ErrorResponse("DB service failed.\n" + Arrays.toString(e.getStackTrace()));

        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody Object register(@RequestBody UserRegisterRequest request) {
        try {
            int user_id = DatabaseWebserviceClient.getDB().createUser(request.getName(), request.getEmail(), request.getPassword());
            if (user_id > 0) {
                return new UserResponse(request.getEmail(), user_id);
            } else {
                return new ErrorResponse("Failed to create new User.");
            }
        } catch (Exception e) {
            return new ErrorResponse("DB service failed." + Arrays.toString(e.getStackTrace()));
        }
    }

    private class UserResponse {
        private String token;
        private int userID;

        public UserResponse(String email, int userID) {
            this.token = TokenService.generateToken(email, userID);
            this.userID = userID;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getUserID() {
            return userID;
        }

        public void setUserID(int userID) {
            this.userID = userID;
        }
    }
}
