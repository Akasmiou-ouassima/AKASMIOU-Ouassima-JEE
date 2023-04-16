package org.sid;
//JaxWS ça commence depuis Java 6
// mais depuis la nouvelle version 9 et plus ça commance par jakarta par ce que jakarta qui a pris maintenant en charge JEE et non pas oracle
import jakarta.xml.ws.Endpoint;
import org.sid.ws.BanqueService;

public class ServerJWs {
    public static void main(String[] args){
        Endpoint.publish("http://0.0.0.0:9191/",new BanqueService()); //il permet de démarrer un petit serveur http qui utilise dans ce cas la port 9191 et il est utilisé pour consulter uniquement ce web service qui est BanqueService (c'est un conncteur http poue le web service)
        // on met 0.0.0.0 et non pas localhost, localhost ça veut dire que le web service il n'est accessible qu'en local
        // puisqu'il n'est pas normal parce que si je crée un web service dans ma machine je devrais pouvoir le consulter à partir
        //d'une autre machine donc je vais pas laisser localhost je vais mettre 0.0.0.0 c'est-à-dire quel que soit
        //l'adresse IP si par exemple si ma machine possède trois cartes réseau avec trois réseaux qui est connecté à trois
        //réseaux différents c'est à dire j'accepte les connexions depuis n'importe quel réseau local
        System.out.println("Web service déployé sur http://0.0.0.0:9191/");
    }
}
