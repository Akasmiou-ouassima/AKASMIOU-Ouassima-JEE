package dao;

import org.springframework.stereotype.Component;

@Component("dao") //le spring au démarrage à chaque fois qu il trouve un classe qui commence par l`annotation Component il va l`ìnstancier
public class DaoImpl implements IDao{

    @Override
    public double getData() {
        /*
        Se connecter à la BD pour récupérer la températeur
         */
        System.out.println("version base de données");
        double temp=Math.random()*40;
        return temp;
    }
}
