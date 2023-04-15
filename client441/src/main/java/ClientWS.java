import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;
// pour consommer le web service que je fais je vais juste
// chercher une interface qui s'appelle BanqueService
// donc Banqueservice c'est une interface qui a été générée dans proxy à partir de WSDL
// si je suis dans n'importe quel langage il me génère l'interface, si je suis dans JAVA à partir de WSL il me génére interface JAVA

public class ClientWS {
    public static void main(String[] args) {
        //BanqueWS ça c'est le nom du web service, je viens de créer un middleware, c'est grâce à cet objet là je peux mon application peut communiquer avec le web service
        BanqueService stub=new BanqueWS().getBanqueServicePort();
        // je suis en train de faire appel à la méthode Converse
        //d'un web service le web service il se trouve quelque part dans une autre machine
        System.out.println(stub.convert(7600));
        Compte cp=stub.getCompte(5);
        System.out.println(cp.getCode());
        System.out.println(cp.getSolde());
    }
}
