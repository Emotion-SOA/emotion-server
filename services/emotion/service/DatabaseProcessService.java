package emotion.api.client.services.emotion.service;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class was generated by Apache CXF 3.1.10
 * 2017-05-07T12:34:20.019+08:00
 * Generated source version: 3.1.10
 * 
 */
@WebServiceClient(name = "DatabaseProcessService", 
                  wsdlLocation = "file:/Users/lifengshuang/Desktop/Code/Intellij/EMotion/emotion-server/src/main/soa/emotion/api/client/services/DatabaseProcess.wsdl",
                  targetNamespace = "http://service.emotion/") 
public class DatabaseProcessService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://service.emotion/", "DatabaseProcessService");
    public final static QName DatabaseProcessPort = new QName("http://service.emotion/", "DatabaseProcessPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/Users/lifengshuang/Desktop/Code/Intellij/EMotion/emotion-server/src/main/soa/emotion/api/client/services/DatabaseProcess.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(emotion.service.DatabaseProcessService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/Users/lifengshuang/Desktop/Code/Intellij/EMotion/emotion-server/src/main/soa/emotion/api/client/services/DatabaseProcess.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public DatabaseProcessService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public DatabaseProcessService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DatabaseProcessService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public DatabaseProcessService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public DatabaseProcessService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public DatabaseProcessService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns DatabaseProcess
     */
    @WebEndpoint(name = "DatabaseProcessPort")
    public DatabaseProcess getDatabaseProcessPort() {
        return super.getPort(DatabaseProcessPort, DatabaseProcess.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DatabaseProcess
     */
    @WebEndpoint(name = "DatabaseProcessPort")
    public DatabaseProcess getDatabaseProcessPort(WebServiceFeature... features) {
        return super.getPort(DatabaseProcessPort, DatabaseProcess.class, features);
    }

}
