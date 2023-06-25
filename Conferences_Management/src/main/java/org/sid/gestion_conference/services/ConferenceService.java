package org.sid.gestion_conference.services;

import org.sid.gestion_conference.dao.enums.Genre;
import org.sid.gestion_conference.dtos.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConferenceService {
    CommentaireDTO saveCommentaire(CommentaireDTO commentaireDTO);

    ConferenceDTO saveConference(ConferenceDTO conferenceDTO, Long speakerId, Long sessionId);
    ConferenceDTO saveConference(ConferenceDTO conferenceDTO);

    SalleDTO saveSalle(SalleDTO salleDTO);

    SessionDTO saveSession(SessionDTO sessionDTO);

    InscriptionDTO saveInscription(InscriptionDTO inscriptionDTO);

    InviteDTO saveInvite(String nom, String email, Genre genre, String affiliation);

    ModerateurDTO saveModerateur(String nom, String email, Genre genre, String specialite);

    SpeakerDTO saveSpeaker(String nom, String email, Genre genre, String urlProfile);

    List<CommentaireDTO> listCommentaires();

    List<ConferenceDTO> listConferences();

    List<SalleDTO> listSalles();

    List<SessionDTO> listSessions();

    List<InscriptionDTO> listInscriptions();

    ParticipantDTO getParticipant(Long participantId);

    List<ParticipantDTO> ParticipantList();

    CommentaireDTO getCommentaire(Long commentaireId);

    ConferenceDTO getConference(Long conferenceId);

    SalleDTO getSalle(Long salleId);

    SessionDTO getSession(Long sessionId);


    CommentaireDTO updateCommentaire(CommentaireDTO commentaireDTO);

    ConferenceDTO updateConference(ConferenceDTO conferenceDTO, Long speakerId, Long sessionId);

    ConferenceDTO updateConference(ConferenceDTO conferenceDTO);

    SalleDTO updateSalle(SalleDTO salleDTO);

    SessionDTO updateSession(SessionDTO sessionDTO);

    InscriptionDTO updateInscription(InscriptionDTO inscriptionDTO);

    ParticipantDTO updateParticipant(ParticipantDTO participantDTO);


    void deleteCommentaire(Long commentaireId);

    void deleteConference(Long conferenceId);

    void deleteSalle(Long salleId);

    void deleteSession(Long sessionId);

    void deleteInscription(Long inscriptionId);

    void deleteParticipant(Long participantId);

    SessionDTO addConferenceToSession(Long idSession, Long idConference);

    SessionDTO removeConferenceFromSession(Long idSession, Long idConference);

    SessionDTO addModerateurToSession(Long idSession, Long idModerateur);

    SessionDTO removeModerateurFromSession(Long idSession, Long idModerateur);

    SessionDTO addSalleToSession(Long idSession, Long idSalle);

    SessionDTO removeSalleFromSession(Long idSession, Long idSalle);

    SessionDTO addInscriptionToSession(Long idSession, Long idInscription);

    SessionDTO removeInscriptionFromSession(Long idSession, Long idInscription);


    InscriptionDTO getInscription(Long inscriptionId);
}
