package org.sid.gestion_conference;

import org.sid.gestion_conference.dao.entities.*;
import org.sid.gestion_conference.dao.enums.Genre;
import org.sid.gestion_conference.dao.enums.Statut;
import org.sid.gestion_conference.dao.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class GestionConferenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionConferenceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ConferenceRepository conferenceRepository, CommentaireRepository commentaireRepository, InscriptionRepository inscriptionRepository, ParticipantRepository participantRepository
            , SalleRepository salleRepository, SessionRepository sessionRepository) {
        return args -> {

            List<Invite> invites= new ArrayList<>();
            Stream.of("ouassima", "imane", "assia", "jinan").forEach(name -> {
                Invite invite = new Invite();
                invite.setNom(name);
                invite.setEmail(name + "@gmail.com");
                invite.setGenre(Genre.FEMENIN);
                invite.setPhoto("photo" + name + ".jpg");
                invite.setAffiliation(Math.random() < 0.5 ? "universite" : "entreprise");
                participantRepository.save(invite);
                invites.add(invite);
            });

            List<Moderateur> moderateurs = new ArrayList<>();
            Stream.of("john", "jali", "jim", "james").forEach(name -> {
                Moderateur moderateur = new Moderateur();
                moderateur.setNom(name);
                moderateur.setEmail(name + "@gmail.com");
                moderateur.setGenre(Genre.MASCULIN);
                moderateur.setPhoto("photo" + name + ".jpg");
                moderateur.setSpecialite(Math.random() < 0.5 ? "informatique" : "mathematique");
                participantRepository.save(moderateur);
                moderateurs.add(moderateur);
            });

            List<Speaker> speakers = new ArrayList<>();
            Stream.of("hassan", "mohamed", "oualid", "arbi").forEach(name -> {
                Speaker speaker = new Speaker();
                speaker.setNom(name);
                speaker.setEmail(name + "@gmail.com");
                speaker.setGenre(Genre.MASCULIN);
                speaker.setPhoto("photo" + name + ".jpg");
                speaker.setUrlProfile("www." + name + ".com");
                participantRepository.save(speaker);
                speakers.add(speaker);
            });

            Salle salle1 = new Salle();
            salle1.setNom("Salle 1");
            Salle salle2 = new Salle();
            salle2.setNom("Salle 2");
            Salle salle3 = new Salle();
            salle3.setNom("Salle 3");
            Salle salle4 = new Salle();
            salle4.setNom("Salle 4");
            salleRepository.save(salle1);
            salleRepository.save(salle2);
            salleRepository.save(salle3);
            salleRepository.save(salle4);

            Session session1 = new Session();
            session1.setNom("Session 1");
            session1.setSalle(salle1);
            session1.setModerateur(moderateurs.get(0));
            sessionRepository.save(session1);

            Session session2 = new Session();
            session2.setNom("Session 2");
            session2.setSalle(salle2);
            session2.setModerateur(moderateurs.get(1));
            sessionRepository.save(session2);

            Session session3 = new Session();
            session3.setNom("Session 3");
            session3.setSalle(salle3);
            session3.setModerateur(moderateurs.get(2));
            sessionRepository.save(session3);

            Inscription inscription1 = new Inscription();
            inscription1.setDate(new Date());
            inscription1.setPrix(319.2F);
            inscription1.setStatut(Statut.VALIDEE);
            inscription1.setInvite(invites.get(0));
            inscription1.setSession(session1);
            inscriptionRepository.save(inscription1);

            Inscription inscription2 = new Inscription();
            inscription2.setDate(new Date());
            inscription2.setPrix(219.2F);
            inscription2.setStatut(Statut.EN_COURS);
            inscription2.setInvite(invites.get(1));
            inscription2.setSession(session2);
            inscriptionRepository.save(inscription2);

            Inscription inscription3 = new Inscription();
            inscription3.setDate(new Date());
            inscription3.setPrix(119.2F);
            inscription3.setStatut(Statut.ANNULEE);
            inscription3.setInvite(invites.get(2));
            inscription3.setSession(session3);
            inscriptionRepository.save(inscription3);

            Conference conference1 = new Conference();
            conference1.setTitre("Java");
            conference1.setDate(new Date());
            conference1.setDescription("Java");
            conference1.setSession(session1);
            conference1.setHeureDebut("08:00");
            conference1.setHeureFin("10:00");
            conference1.setSpeaker(speakers.get(0));
            conferenceRepository.save(conference1);

            Conference conference2 = new Conference();
            conference2.setTitre("Java");
            conference2.setDate(new Date());
            conference2.setDescription("Java");
            conference2.setSession(session2);
            conference2.setHeureDebut("10:00");
            conference2.setHeureFin("12:00");
            conference2.setSpeaker(speakers.get(1));
            conferenceRepository.save(conference2);

            Conference conference3 = new Conference();
            conference3.setTitre("Java");
            conference3.setDate(new Date());
            conference3.setDescription("Java");
            conference3.setSession(session3);
            conference3.setHeureDebut("12:00");
            conference3.setHeureFin("14:00");
            conference3.setSpeaker(speakers.get(2));
            conferenceRepository.save(conference3);

        };


    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
