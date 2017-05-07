package emotion.api.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lifengshuang on 07/05/2017.
 */
public class PostImageRelationService {

    private static Map<Integer, String> relation = new HashMap<>();

    public static void addRelation(int postID, String imagePath) {
        relation.put(postID, imagePath);
    }

    public static String getImagePath(int postID) {
        return relation.get(postID);
    }
}
