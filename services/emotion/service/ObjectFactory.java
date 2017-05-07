
package emotion.api.client.services.emotion.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the emotion.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreatePost_QNAME = new QName("http://service.emotion/", "createPost");
    private final static QName _CreatePostResponse_QNAME = new QName("http://service.emotion/", "createPostResponse");
    private final static QName _CreateUser_QNAME = new QName("http://service.emotion/", "createUser");
    private final static QName _CreateUserResponse_QNAME = new QName("http://service.emotion/", "createUserResponse");
    private final static QName _GetMyOwnPost_QNAME = new QName("http://service.emotion/", "getMyOwnPost");
    private final static QName _GetMyOwnPostResponse_QNAME = new QName("http://service.emotion/", "getMyOwnPostResponse");
    private final static QName _GetSurroundingPost_QNAME = new QName("http://service.emotion/", "getSurroundingPost");
    private final static QName _GetSurroundingPostResponse_QNAME = new QName("http://service.emotion/", "getSurroundingPostResponse");
    private final static QName _GetUser_QNAME = new QName("http://service.emotion/", "getUser");
    private final static QName _GetUserResponse_QNAME = new QName("http://service.emotion/", "getUserResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: emotion.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreatePost }
     * 
     */
    public CreatePost createCreatePost() {
        return new CreatePost();
    }

    /**
     * Create an instance of {@link CreatePostResponse }
     * 
     */
    public CreatePostResponse createCreatePostResponse() {
        return new CreatePostResponse();
    }

    /**
     * Create an instance of {@link CreateUser }
     * 
     */
    public CreateUser createCreateUser() {
        return new CreateUser();
    }

    /**
     * Create an instance of {@link CreateUserResponse }
     * 
     */
    public CreateUserResponse createCreateUserResponse() {
        return new CreateUserResponse();
    }

    /**
     * Create an instance of {@link GetMyOwnPost }
     * 
     */
    public GetMyOwnPost createGetMyOwnPost() {
        return new GetMyOwnPost();
    }

    /**
     * Create an instance of {@link GetMyOwnPostResponse }
     * 
     */
    public GetMyOwnPostResponse createGetMyOwnPostResponse() {
        return new GetMyOwnPostResponse();
    }

    /**
     * Create an instance of {@link GetSurroundingPost }
     * 
     */
    public GetSurroundingPost createGetSurroundingPost() {
        return new GetSurroundingPost();
    }

    /**
     * Create an instance of {@link GetSurroundingPostResponse }
     * 
     */
    public GetSurroundingPostResponse createGetSurroundingPostResponse() {
        return new GetSurroundingPostResponse();
    }

    /**
     * Create an instance of {@link GetUser }
     * 
     */
    public GetUser createGetUser() {
        return new GetUser();
    }

    /**
     * Create an instance of {@link GetUserResponse }
     * 
     */
    public GetUserResponse createGetUserResponse() {
        return new GetUserResponse();
    }

    /**
     * Create an instance of {@link Post }
     * 
     */
    public Post createPost() {
        return new Post();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.emotion/", name = "createPost")
    public JAXBElement<CreatePost> createCreatePost(CreatePost value) {
        return new JAXBElement<CreatePost>(_CreatePost_QNAME, CreatePost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.emotion/", name = "createPostResponse")
    public JAXBElement<CreatePostResponse> createCreatePostResponse(CreatePostResponse value) {
        return new JAXBElement<CreatePostResponse>(_CreatePostResponse_QNAME, CreatePostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.emotion/", name = "createUser")
    public JAXBElement<CreateUser> createCreateUser(CreateUser value) {
        return new JAXBElement<CreateUser>(_CreateUser_QNAME, CreateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.emotion/", name = "createUserResponse")
    public JAXBElement<CreateUserResponse> createCreateUserResponse(CreateUserResponse value) {
        return new JAXBElement<CreateUserResponse>(_CreateUserResponse_QNAME, CreateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMyOwnPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.emotion/", name = "getMyOwnPost")
    public JAXBElement<GetMyOwnPost> createGetMyOwnPost(GetMyOwnPost value) {
        return new JAXBElement<GetMyOwnPost>(_GetMyOwnPost_QNAME, GetMyOwnPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMyOwnPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.emotion/", name = "getMyOwnPostResponse")
    public JAXBElement<GetMyOwnPostResponse> createGetMyOwnPostResponse(GetMyOwnPostResponse value) {
        return new JAXBElement<GetMyOwnPostResponse>(_GetMyOwnPostResponse_QNAME, GetMyOwnPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSurroundingPost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.emotion/", name = "getSurroundingPost")
    public JAXBElement<GetSurroundingPost> createGetSurroundingPost(GetSurroundingPost value) {
        return new JAXBElement<GetSurroundingPost>(_GetSurroundingPost_QNAME, GetSurroundingPost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSurroundingPostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.emotion/", name = "getSurroundingPostResponse")
    public JAXBElement<GetSurroundingPostResponse> createGetSurroundingPostResponse(GetSurroundingPostResponse value) {
        return new JAXBElement<GetSurroundingPostResponse>(_GetSurroundingPostResponse_QNAME, GetSurroundingPostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.emotion/", name = "getUser")
    public JAXBElement<GetUser> createGetUser(GetUser value) {
        return new JAXBElement<GetUser>(_GetUser_QNAME, GetUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.emotion/", name = "getUserResponse")
    public JAXBElement<GetUserResponse> createGetUserResponse(GetUserResponse value) {
        return new JAXBElement<GetUserResponse>(_GetUserResponse_QNAME, GetUserResponse.class, null, value);
    }

}
