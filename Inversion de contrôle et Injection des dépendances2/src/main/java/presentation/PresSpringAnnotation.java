package presentation;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresSpringAnnotation {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext("dao","metier","ext"); //les packages qu`il doivent scannées
        IMetier metier=context.getBean(IMetier.class); // donnez moi un bean qui implémente l`interface IMetier
        System.out.println(metier.calcul());

    }
}
