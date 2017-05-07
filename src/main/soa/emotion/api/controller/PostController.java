package emotion.api.controller;

import emotion.api.client.DatabaseWebserviceClient;
import emotion.service.Post;
import emotion.api.request.AddPostRequest;
import emotion.api.response.ErrorResponse;
import emotion.api.service.TokenService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
            return posts;
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
                return new AddPostResponse(postID);
            } catch (Exception e) {
                return new ErrorResponse("DB service failed.") + Arrays.toString(e.getStackTrace());
            }
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
