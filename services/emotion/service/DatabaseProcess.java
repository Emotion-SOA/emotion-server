package emotion.api.client.services.emotion.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.10
 * 2017-05-07T12:34:19.930+08:00
 * Generated source version: 3.1.10
 * 
 */
@WebService(targetNamespace = "http://service.emotion/", name = "DatabaseProcess")
@XmlSeeAlso({ObjectFactory.class})
public interface DatabaseProcess {

    @WebMethod
    @RequestWrapper(localName = "createUser", targetNamespace = "http://service.emotion/", className = "emotion.service.CreateUser")
    @ResponseWrapper(localName = "createUserResponse", targetNamespace = "http://service.emotion/", className = "emotion.service.CreateUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public int createUser(
            @WebParam(name = "arg0", targetNamespace = "")
                    String arg0,
            @WebParam(name = "arg1", targetNamespace = "")
                    String arg1,
            @WebParam(name = "arg2", targetNamespace = "")
                    String arg2
    );

    @WebMethod
    @RequestWrapper(localName = "getMyOwnPost", targetNamespace = "http://service.emotion/", className = "emotion.service.GetMyOwnPost")
    @ResponseWrapper(localName = "getMyOwnPostResponse", targetNamespace = "http://service.emotion/", className = "emotion.service.GetMyOwnPostResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<Post> getMyOwnPost(
            @WebParam(name = "arg0", targetNamespace = "")
                    int arg0
    );

    @WebMethod
    @RequestWrapper(localName = "getUser", targetNamespace = "http://service.emotion/", className = "emotion.service.GetUser")
    @ResponseWrapper(localName = "getUserResponse", targetNamespace = "http://service.emotion/", className = "emotion.service.GetUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public User getUser(
            @WebParam(name = "arg0", targetNamespace = "")
                    String arg0
    );

    @WebMethod
    @RequestWrapper(localName = "createPost", targetNamespace = "http://service.emotion/", className = "emotion.service.CreatePost")
    @ResponseWrapper(localName = "createPostResponse", targetNamespace = "http://service.emotion/", className = "emotion.service.CreatePostResponse")
    @WebResult(name = "return", targetNamespace = "")
    public int createPost(
            @WebParam(name = "arg0", targetNamespace = "")
                    String arg0,
            @WebParam(name = "arg1", targetNamespace = "")
                    float arg1,
            @WebParam(name = "arg2", targetNamespace = "")
                    float arg2,
            @WebParam(name = "arg3", targetNamespace = "")
                    int arg3
    );

    @WebMethod
    @RequestWrapper(localName = "getSurroundingPost", targetNamespace = "http://service.emotion/", className = "emotion.service.GetSurroundingPost")
    @ResponseWrapper(localName = "getSurroundingPostResponse", targetNamespace = "http://service.emotion/", className = "emotion.service.GetSurroundingPostResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<Post> getSurroundingPost(
            @WebParam(name = "arg0", targetNamespace = "")
                    float arg0,
            @WebParam(name = "arg1", targetNamespace = "")
                    float arg1,
            @WebParam(name = "arg2", targetNamespace = "")
                    float arg2
    );
}
