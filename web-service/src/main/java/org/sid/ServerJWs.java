package org.sid;

import jakarta.xml.ws.Endpoint;
import org.sid.ws.BanqueService;

public class ServerWs {
    public static void main(String[] args){
        Endpoint.publish("http://0.0.0.0:9191/",new BanqueService());
        System.out.println("Web service déployé sur http://0.0.0.0:9191/");
    }
}
