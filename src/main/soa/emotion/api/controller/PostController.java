package emotion.api.controller;

import emotion.api.client.DatabaseWebserviceClient;
import emotion.api.service.PostImageRelationService;
import emotion.service.Post;
import emotion.api.request.AddPostRequest;
import emotion.api.response.ErrorResponse;
import emotion.api.service.TokenService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedList;
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
            List<Post> posts = DatabaseWebserviceClient.getDB().getSurroundingPost(longitude, latitude, range);
            List<GetPostResponse> result = new LinkedList<>();
            for (Post post : posts) {
                GetPostResponse response = new GetPostResponse(post.getPostID(), post.getText(),
                        PostImageRelationService.getImagePath(post.getPostID()), post.getLongtitude(), post.getLatitude(), post.getUserID());
                result.add(response);
            }
            return result;
        } catch (Exception e) {
            return new ErrorResponse("DB service failed." + Arrays.toString(e.getStackTrace()));
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
                int postID = DatabaseWebserviceClient.getDB().createPost(request.getText(), request.getLongitude(), request.getLatitude(), userID);
                if (postID == -1){
                    return "Add post failed for userID: " + userID;
                }
                PostImageRelationService.addRelation(postID, request.getImagePath());
                return new AddPostResponse(postID);
            } catch (Exception e) {
                return new ErrorResponse("DB service failed.") + Arrays.toString(e.getStackTrace());
            }
        }
    }

    private class AddPostResponse {
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

    private class GetPostResponse {
        private int postID;
        private String text;
        private String imagePath;
        private float longitude;
        private float latitude;
        private int userID;

        public GetPostResponse(int postID, String text, String imagePath, float longitude, float latitude, int userID) {
            this.postID = postID;
            this.text = text;
            this.imagePath = imagePath;
            this.longitude = longitude;
            this.latitude = latitude;
            this.userID = userID;
        }

        public int getPostID() {
            return postID;
        }

        public void setPostID(int postID) {
            this.postID = postID;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getImagePath() {
            return imagePath;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }

        public float getLongitude() {
            return longitude;
        }

        public void setLongitude(float longitude) {
            this.longitude = longitude;
        }

        public float getLatitude() {
            return latitude;
        }

        public void setLatitude(float latitude) {
            this.latitude = latitude;
        }

        public int getUserID() {
            return userID;
        }

        public void setUserID(int userID) {
            this.userID = userID;
        }
    }
}
