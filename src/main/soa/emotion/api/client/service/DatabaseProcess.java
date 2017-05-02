package emotion.api.client.service;

import javax.jws.WebService;
import java.util.List;


/**
 * Created by lifengshuang on 21/04/2017.
 */
@WebService
public interface DatabaseProcess {

    int createUser(String name, String email, String password);

    User getUser(String email);

    int createPost(String text, float longtitude, float latitude, int userID);

    List<Post> getSurroundingPost(float longtitude, float latitude, float range);

    List<Post> getMyOwnPost(int userID);
}
