package emotion.api.client;

import emotion.api.client.service.DatabaseProcess;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

/**
 * Created by lifengshuang on 01/05/2017.
 */
public class DatabaseWebserviceClient {

    private static final QName SERVICE_NAME
            = new QName("http://service.emotion/", "DatabaseProcess");
    private static final QName PORT_NAME
            = new QName("http://service.emotion/", "DatabaseProcessPort");

    private static Service service = Service.create(SERVICE_NAME);
    public static DatabaseProcess db;

    static {
        String endpointAddress = "http://localhost:8080/emotion/services/DatabaseProcess";
        service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
        db = service.getPort(DatabaseProcess.class);
    }
}

