package emotion.api.controller;

import emotion.api.client.DatabaseWebserviceClient;
import emotion.api.client.service.Post;
import emotion.api.response.ErrorResponse;
import emotion.api.service.TokenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lifengshuang on 01/05/2017.
 */

@RestController
@RequestMapping("/post")
public class PostController {

    @RequestMapping(value = "/surrounding", method = RequestMethod.GET)
    public
    @ResponseBody
    Object getPost(@RequestParam float longitude, @RequestParam float latitude, @RequestParam float range) {
        try {
            List<Post> posts = DatabaseWebserviceClient.db.getSurroundingPost(longitude, latitude, range);
            return posts;
        } catch (Exception e) {
            return new ErrorResponse("DB service failed.");
        }
    }

    //todo: add image
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public
    @ResponseBody
    Object addPost(@RequestBody AddPostRequest request) {
        int userID = TokenService.getUserID(request.getToken());
        if (userID < 0) {
            return new ErrorResponse("Token is invalid");
        } else {
            try {
                int postID = DatabaseWebserviceClient.db.createPost(request.getText(), request.getLongitude(), request.getLatitude(), userID);
                return new AddPostResponse(postID);
            } catch (Exception e) {
                return new ErrorResponse("DB service failed.");
            }
        }
    }

    private class AddPostRequest {
        private String token;
        private String text;
        private int imageID;
        private float latitude;
        private float longitude;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getImageID() {
            return imageID;
        }

        public void setImageID(int imageID) {
            this.imageID = imageID;
        }

        public float getLatitude() {
            return latitude;
        }

        public void setLatitude(float latitude) {
            this.latitude = latitude;
        }

        public float getLongitude() {
            return longitude;
        }

        public void setLongitude(float longitude) {
            this.longitude = longitude;
        }
    }
    private class AddPostResponse{
        private int postID;

        public AddPostResponse(int postID) {
            this.postID = postID;
        }

        public int getPostID() {
            return postID;
        }

        public void setPostID(int postID) {
            this.postID = postID;
        }
    }
}
