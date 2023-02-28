package presentation;


import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Presentation2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner=new Scanner(new File("config.txt"));
        //instanciation dynamique
        //il faut savoir la classe
        String daoClassName=scanner.nextLine();
        //il faut charger la classe en mémoire
        Class cDao=Class.forName(daoClassName);// forName : on lui donner le nom de la classe, si la classe il existe il va charger le bytecode en mémoire
        // tt les classes que vous utilisez sont chargés en mémoire sous forme des objets de type Class
        // il faut instancier la classe
        IDao dao=(IDao) cDao.newInstance(); // newInstance fait appel au constructor sans paramétre privé
        //System.out.println(dao.getData());

        String metierClassName=scanner.nextLine();
        Class cMetier=Class.forName(metierClassName);
        IMetier metier=(IMetier) cMetier.newInstance();

        //Method method=cMetier.getMethod("setDao",Integer.class,String.class); une methode setDao qui reçoit 2 paramétres de type int et String
        Method method=cMetier.getMethod("setDao",IDao.class);
        //metier.setDao(dao);
        method.invoke(metier,dao);//pour exécuter cette methode
        System.out.println("Résultats =>"+metier.calcul());
    }
}
