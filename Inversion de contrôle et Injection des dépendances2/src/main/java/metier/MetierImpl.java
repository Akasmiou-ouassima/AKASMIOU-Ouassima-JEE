package metier;


import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MetierImpl implements IMetier {
    //Couplage faible
    @Autowired //faire injection de dépendance : au moment l`instanciation de la classe MetierImpl le spring il va chercher un objet de type IDAO et l`injecter au variable dao
    // si vous créér un constructeur avec paramétre c mieux que autowired
   // @Qualifier("dao") // est utilisé lorsque plusieurs instance qui implémente l`interface, injecter l`instance dao
    @Qualifier("dao2") // à l`intérieur on spécifier laquelle de l`instance que vous voulez injecter
    private IDao dao;

    @Override
    public double calcul() {
        double tmp=dao.getData();
        double res=tmp*540/Math.cos(tmp*Math.PI);
        return res;
    }
   /*
   Injecter dans la variable dao un objet
   d'une classe qui implémente l'interface IDao
    */
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
