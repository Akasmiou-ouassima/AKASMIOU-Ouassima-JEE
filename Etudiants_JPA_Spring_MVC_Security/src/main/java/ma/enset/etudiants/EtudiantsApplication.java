package ma.enset.etudiants;

import ma.enset.etudiants.entities.Etudiant;
import ma.enset.etudiants.entities.Genre;
import ma.enset.etudiants.repository.EtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class EtudiantsApplication {
    public static void main(String[] args) {
        SpringApplication.run(EtudiantsApplication.class, args);
    }

    @Bean
    CommandLineRunner start(EtudiantRepository etudiantRepository){
        return args -> {
            etudiantRepository.save(new Etudiant(null,"AKASMIOU","Ouassima",new Date(),"ouassima@gmail.com", Genre.FEMENIN,true));
            etudiantRepository.save(new Etudiant(null,"ALLACH","Aicha",new Date(),"aicha@gmail.com", Genre.FEMENIN,true));
            etudiantRepository.save(new Etudiant(null,"Arri","Anass",new Date(),"anass@gmail.com", Genre.MASCULIN,true));
            etudiantRepository.save(new Etudiant(null,"Amjad","Mohamed",new Date(),"mohamed@gmail.com", Genre.MASCULIN,false));
            etudiantRepository.save(new Etudiant(null,"ELKHALADI","Oualid",new Date(),"oualid@gmail.com", Genre.MASCULIN,false));
            etudiantRepository.save(new Etudiant(null,"boughlala","Jinan",new Date(),"jinan@gmail.com", Genre.FEMENIN,true));

        };
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
