package org.sid.gestion_conference.mappers;

import org.sid.gestion_conference.dao.entities.*;
import org.sid.gestion_conference.dtos.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ConferenceMapperImpl{
    public ConferenceDTO fromConference(Conference conference) {
        ConferenceDTO conferenceDTO = new ConferenceDTO();
        BeanUtils.copyProperties(conference, conferenceDTO);
        conferenceDTO.setSessionDTO(fromSession(conference.getSession()));
        conferenceDTO.setSpeakerDTO(fromSpeaker(conference.getSpeaker()));
        return conferenceDTO;
    }
    public Conference fromConferenceDTO(ConferenceDTO conferenceDTO) {
       Conference conference= new Conference();
        BeanUtils.copyProperties(conferenceDTO, conference);
        return conference;
    }
    public CommentaireDTO fromCommentaire(Commentaire commentaire) {
        CommentaireDTO commentaireDTO = new CommentaireDTO();
        BeanUtils.copyProperties(commentaire, commentaireDTO);
        return commentaireDTO;
    }
    public Commentaire fromCommentaireDTO(CommentaireDTO commentaireDTO) {
        Commentaire commentaire = new Commentaire();
        BeanUtils.copyProperties(commentaireDTO, commentaire);
        return commentaire;
    }
    public InscriptionDTO fromInscription(Inscription inscription) {
        InscriptionDTO inscriptionDTO = new InscriptionDTO();
        BeanUtils.copyProperties(inscription, inscriptionDTO);
        return inscriptionDTO;
    }
    public Inscription fromInscriptionDTO(InscriptionDTO inscriptionDTO) {
        Inscription inscription = new Inscription();
        BeanUtils.copyProperties(inscriptionDTO, inscription);
        return inscription;
    }
    public InviteDTO fromInvite(Invite invite) {
        InviteDTO inviteDTO = new InviteDTO();
        BeanUtils.copyProperties(invite, inviteDTO);
        inviteDTO.setType(invite.getClass().getSimpleName());
        return inviteDTO;
    }
    public Invite fromInviteDTO(InviteDTO inviteDTO) {
        Invite invite = new Invite();
        BeanUtils.copyProperties(inviteDTO, invite);
        return invite;
    }
    public ModerateurDTO fromModerateur(Moderateur moderateur) {
        ModerateurDTO moderateurDTO = new ModerateurDTO();
        BeanUtils.copyProperties(moderateur, moderateurDTO);
        moderateurDTO.setType(moderateur.getClass().getSimpleName());
        return moderateurDTO;
    }
    public Moderateur fromModerateurDTO(ModerateurDTO moderateurDTO) {
        Moderateur moderateur = new Moderateur();
        BeanUtils.copyProperties(moderateurDTO, moderateur);
        return moderateur;
    }
    public SpeakerDTO fromSpeaker(Speaker speaker) {
        SpeakerDTO speakerDTO = new SpeakerDTO();
        BeanUtils.copyProperties(speaker, speakerDTO);
        speakerDTO.setType(speaker.getClass().getSimpleName());
        return speakerDTO;
    }
    public Speaker fromSpeakerDTO(SpeakerDTO speakerDTO) {
        Speaker speaker = new Speaker();
        BeanUtils.copyProperties(speakerDTO, speaker);
        return speaker;
    }
    public SalleDTO fromSalle(Salle salle) {
        SalleDTO salleDTO = new SalleDTO();
        BeanUtils.copyProperties(salle, salleDTO);
        return salleDTO;
    }
    public Salle fromSalleDTO(SalleDTO salleDTO) {
        Salle salle = new Salle();
        BeanUtils.copyProperties(salleDTO, salle);
        return salle;
    }
    public SessionDTO fromSession(Session session) {
        SessionDTO sessionDTO = new SessionDTO();
        BeanUtils.copyProperties(session, sessionDTO);
        return sessionDTO;
    }
    public Session fromSessionDTO(SessionDTO sessionDTO) {
        Session session = new Session();
        BeanUtils.copyProperties(sessionDTO, session);
        return session;
    }
    public ParticipantDTO fromParticipant(Participant participant) {
        ParticipantDTO participantDTO = new ParticipantDTO();
        BeanUtils.copyProperties(participant, participantDTO);
        participantDTO.setType(participant.getClass().getSimpleName());
        return participantDTO;
    }
    public Participant fromParticipantDTO(ParticipantDTO participantDTO) {
        Participant participant = new Participant();
        BeanUtils.copyProperties(participantDTO, participant);
        return participant;
    }

}
