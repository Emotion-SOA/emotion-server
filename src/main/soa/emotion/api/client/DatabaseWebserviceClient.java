package emotion.api.client;

import emotion.service.DatabaseProcess;
import emotion.service.Post;
import emotion.service.User;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by lifengshuang on 01/05/2017.
 */
public class DatabaseWebserviceClient {

    private static final QName SERVICE_NAME
            = new QName("http://service.emotion/", "DatabaseProcess");
    private static final QName PORT_NAME
            = new QName("http://service.emotion/", "DatabaseProcessPort");

    private static DatabaseProcess db;

    public static DatabaseProcess getDB() {
        if (db == null) {
            Service service = Service.create(SERVICE_NAME);
            String endpointAddress = "http://localhost:8080/emotion-webservice/services/DatabaseProcess";
            service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
            db = service.getPort(DatabaseProcess.class);
        }
        return db;
    }

    // For testing purpose.
    public static void main(String[] args) {
        Service service = Service.create(SERVICE_NAME);
        String endpointAddress = "http://localhost:8080/emotion-webservice/services/DatabaseProcess";
        service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
        DatabaseProcess hw = service.getPort(DatabaseProcess.class);
        User user = hw.getUser("yeats.mar@gmail.com");
        if (user != null) {
            System.out.println("user name: " + user.getName());
            System.out.println("user password: " + user.getPassword());
        }
        List<Post> posts = hw.getSurroundingPost(0, 0, 1);
        for (Post post :
                posts) {
            System.out.println(post.getPublishTime()+"\n"+post.getText());
        }
    }
}

