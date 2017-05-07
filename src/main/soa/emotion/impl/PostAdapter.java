package emotion.impl;

import emotion.service.Post;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by mayezhou on 2017/4/23.
 */
public class PostAdapter extends XmlAdapter<PostImpl, Post> {
    @Override
    public Post unmarshal(PostImpl v) throws Exception {
        return v;
    }

    @Override
    public PostImpl marshal(Post v) throws Exception {
        if(v instanceof PostImpl) {
            return (PostImpl)v;
        }
        return new PostImpl(v.getPostID(), v.getText(), v.getPublishTime(), v.getLongtitude(), v.getLatitude(), v.getUserID());
    }
}
