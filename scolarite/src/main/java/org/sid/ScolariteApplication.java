package org.sid;

import org.sid.dao.EtudiantRepository;
import org.sid.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

@SpringBootApplication
public class ScolariteApplication implements CommandLineRunner {
    @Autowired
    private EtudiantRepository etudiantRepository;
    public static void main(String[] args) {
        SpringApplication.run(ScolariteApplication.class, args);
       /* ApplicationContext context=SpringApplication.run(ScolariteApplication.class, args);
        EtudiantRepository etudiantRepository=context.getBean(EtudiantRepository.class);chercher un objet qui implemente cette interface
        etudiantRepository.save(new Etudiant(null,"Mohamed","med@gmail.com",new Date(),45));
        etudiantRepository.save(new Etudiant(null,"Hassan","hassan@gmail.com",new Date(),65));
        etudiantRepository.save(new Etudiant(null,"Imane","imane@gmail.com",new Date(),15));

         etudiantRepository.findAll().forEach(et->{
             System.out.println(et.toString());
         });*/
    }

    @Override
    public void run(String... args) throws Exception {
        etudiantRepository.save(new Etudiant(null,"Mohamed","med@gmail.com",new Date(),45));
        etudiantRepository.save(new Etudiant(null,"Hassan","hassan@gmail.com",new Date(),65));
        etudiantRepository.save(new Etudiant(null,"Imane","imane@gmail.com",new Date(),15));

        etudiantRepository.findAll().forEach(et->{
            System.out.println(et.toString());
        });
        System.out.println("--------------------------");
        Etudiant et=etudiantRepository.findById(1L).get();
        System.out.println(et.getName());

        System.out.println("***************************");
        etudiantRepository.findByScore(45).forEach(ett->{
            System.out.println(ett.getName());
        });
    }
}
