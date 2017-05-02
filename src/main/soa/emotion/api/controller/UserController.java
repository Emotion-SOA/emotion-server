package emotion.api.controller;

import emotion.api.client.DatabaseWebserviceClient;
import emotion.api.client.service.User;
import emotion.api.response.ErrorResponse;
import emotion.api.service.TokenService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lifengshuang on 24/04/2017.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public @ResponseBody Object login(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
        try {
            User user = DatabaseWebserviceClient.db.getUser(email);
            if (user.getPassword().equals(password)) {
                return new UserResponse(email, user.getUserID());
            } else {
                return new ErrorResponse("Password is incorrect");
            }
        } catch (Exception e) {
            return new ErrorResponse("DB service failed.");

        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody Object register(@RequestBody UserRegisterRequest request) {
        try {
            int user_id = DatabaseWebserviceClient.db.createUser(request.getName(), request.getEmail(), request.getPassword());
            if (user_id > 0) {
                return new UserResponse(request.getEmail(), user_id);
            } else {
                return new ErrorResponse("Failed to create new User.");
            }
        } catch (Exception e) {
            return new ErrorResponse("DB service failed.");
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

    private class UserRegisterRequest {
        private String email;
        private String password;
        private String name;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
