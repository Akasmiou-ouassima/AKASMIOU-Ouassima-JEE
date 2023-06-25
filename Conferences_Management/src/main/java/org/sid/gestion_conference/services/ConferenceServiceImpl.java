package org.sid.gestion_conference.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.gestion_conference.dao.entities.*;
import org.sid.gestion_conference.dao.enums.Genre;
import org.sid.gestion_conference.dao.repositories.*;
import org.sid.gestion_conference.dtos.*;
import org.sid.gestion_conference.mappers.ConferenceMapperImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ConferenceServiceImpl implements ConferenceService {
    private CommentaireRepository commentaireRepository;
    private ConferenceRepository conferenceRepository;
    private SalleRepository salleRepository;

    private SessionRepository sessionRepository;

    private ParticipantRepository participantRepository;
    private InscriptionRepository inscriptionRepository;
    private ConferenceMapperImpl dtoMapper;

    @Override
    public CommentaireDTO saveCommentaire(CommentaireDTO commentaireDTO) {
        Commentaire commentaire = dtoMapper.fromCommentaireDTO(commentaireDTO);
        Commentaire savedCommentaire = commentaireRepository.save(commentaire);
        return dtoMapper.fromCommentaire(savedCommentaire);
    }

    @Override
    public ConferenceDTO saveConference(ConferenceDTO conferenceDTO, Long speakerId, Long sessionId) {
        Participant speaker = participantRepository.findById(speakerId).orElse(null);
        if (speaker == null)
            throw new RuntimeException("Speaker not found");
        Session session = sessionRepository.findById(sessionId).orElse(null);
        if (session == null)
            throw new RuntimeException("Session not found");
        Conference conference = dtoMapper.fromConferenceDTO(conferenceDTO);
        conference.setSpeaker((Speaker) speaker);
        conference.setSession(session);
        Conference savedConference = conferenceRepository.save(conference);
        return dtoMapper.fromConference(savedConference);
    }

    @Override
    public ConferenceDTO saveConference(ConferenceDTO conferenceDTO) {
       Conference conference=dtoMapper.fromConferenceDTO(conferenceDTO);
       Conference savedConference=conferenceRepository.save(conference);
       return dtoMapper.fromConference(savedConference);
    }

    @Override
    public SalleDTO saveSalle(SalleDTO salleDTO) {
        Salle salle = dtoMapper.fromSalleDTO(salleDTO);
        Salle savedSalle = salleRepository.save(salle);
        return dtoMapper.fromSalle(savedSalle);
    }

    @Override
    public SessionDTO saveSession(SessionDTO sessionDTO) {
        Session session = dtoMapper.fromSessionDTO(sessionDTO);
        Session savedSession = sessionRepository.save(session);
        return dtoMapper.fromSession(savedSession);
    }

    @Override
    public InscriptionDTO saveInscription(InscriptionDTO inscriptionDTO) {
        Inscription inscription = dtoMapper.fromInscriptionDTO(inscriptionDTO);
        Inscription savedInscription = inscriptionRepository.save(inscription);
        return dtoMapper.fromInscription(savedInscription);
    }

    @Override
    public InviteDTO saveInvite(String nom, String email, Genre genre, String affiliation) {
        Invite invite = new Invite();
        invite.setNom(nom);
        invite.setEmail(email);
        invite.setGenre(genre);
        invite.setAffiliation(affiliation);
        Invite savedInvite = participantRepository.save(invite);
        return dtoMapper.fromInvite(savedInvite);
    }

    @Override
    public ModerateurDTO saveModerateur(String nom, String email, Genre genre, String specialite) {
        Moderateur moderateur = new Moderateur();
        moderateur.setNom(nom);
        moderateur.setEmail(email);
        moderateur.setGenre(genre);
        moderateur.setSpecialite(specialite);
        Moderateur savedModerateur = participantRepository.save(moderateur);
        return dtoMapper.fromModerateur(savedModerateur);
    }

    @Override
    public SpeakerDTO saveSpeaker(String nom, String email, Genre genre, String urlProfile) {
        Speaker speaker = new Speaker();
        speaker.setNom(nom);
        speaker.setEmail(email);
        speaker.setGenre(genre);
        speaker.setUrlProfile(urlProfile);
        Speaker savedSpeaker = participantRepository.save(speaker);
        return dtoMapper.fromSpeaker(savedSpeaker);
    }

    @Override
    public List<CommentaireDTO> listCommentaires() {
        List<Commentaire> commentaires = commentaireRepository.findAll();
        List<CommentaireDTO> collect = commentaires.stream().map(commentaire -> dtoMapper.fromCommentaire(commentaire)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<ConferenceDTO> listConferences() {
        List<Conference> conferences = conferenceRepository.findAll();
        List<ConferenceDTO> collect = conferences.stream().map(conference -> dtoMapper.fromConference(conference)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<SalleDTO> listSalles() {
        List<Salle> salles = salleRepository.findAll();
        List<SalleDTO> collect = salles.stream().map(salle -> dtoMapper.fromSalle(salle)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<SessionDTO> listSessions() {
        List<Session> sessions = sessionRepository.findAll();
        List<SessionDTO> collect = sessions.stream().map(session -> dtoMapper.fromSession(session)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<InscriptionDTO> listInscriptions() {
        List<Inscription> inscriptions = inscriptionRepository.findAll();
        List<InscriptionDTO> collect = inscriptions.stream().map(inscription -> dtoMapper.fromInscription(inscription)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public ParticipantDTO getParticipant(Long participantId) {
        Participant participant = participantRepository.findById(participantId).orElse(null);
        if (participant == null)
            throw new RuntimeException("Participant not found");
        if (participant instanceof Invite)
            return dtoMapper.fromInvite((Invite) participant);
        else if (participant instanceof Moderateur) {
            return dtoMapper.fromModerateur((Moderateur) participant);
        } else if (participant instanceof Speaker)
            return dtoMapper.fromSpeaker((Speaker) participant);
        else
            return null;
    }

    @Override
    public List<ParticipantDTO> ParticipantList() {
        List<Participant> participants = participantRepository.findAll();
        List<ParticipantDTO> collect = participants.stream().map(participant -> {
            if (participant instanceof Invite)
                return dtoMapper.fromInvite((Invite) participant);
            else if (participant instanceof Moderateur) {
                return dtoMapper.fromModerateur((Moderateur) participant);
            } else if (participant instanceof Speaker)
                return dtoMapper.fromSpeaker((Speaker) participant);
            else
                return null;
        }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public CommentaireDTO getCommentaire(Long commentaireId) {
        Commentaire commentaire = commentaireRepository.findById(commentaireId).orElseThrow(() ->
                new RuntimeException("Commentaire not found"));
        return dtoMapper.fromCommentaire(commentaire);
    }

    @Override
    public ConferenceDTO getConference(Long conferenceId) {
        Conference conference = conferenceRepository.findById(conferenceId).orElse(null);
        if (conference == null)
            throw new RuntimeException("Conference not found");
        return dtoMapper.fromConference(conference);
    }

    @Override
    public SalleDTO getSalle(Long salleId) {
        Salle salle = salleRepository.findById(salleId).orElse(null);
        if (salle == null)
            throw new RuntimeException("Salle not found");
        return dtoMapper.fromSalle(salle);
    }

    @Override
    public SessionDTO getSession(Long sessionId) {
        Session session = sessionRepository.findById(sessionId).orElse(null);
        if (session == null)
            throw new RuntimeException("Session not found");
        return dtoMapper.fromSession(session);
    }

    @Override
    public CommentaireDTO updateCommentaire(CommentaireDTO commentaireDTO) {
        Commentaire commentaire = dtoMapper.fromCommentaireDTO(commentaireDTO);
        Commentaire savedCommentaire = commentaireRepository.save(commentaire);
        return dtoMapper.fromCommentaire(savedCommentaire);
    }

    @Override
    public ConferenceDTO updateConference(ConferenceDTO conferenceDTO, Long speakerId, Long sessionId) {
        Conference conference = dtoMapper.fromConferenceDTO(conferenceDTO);
        Speaker speaker = (Speaker) participantRepository.findById(speakerId).orElse(null);
        Session session = sessionRepository.findById(sessionId).orElse(null);
        conference.setSpeaker(speaker);
        conference.setSession(session);
        Conference savedConference = conferenceRepository.save(conference);
        return dtoMapper.fromConference(savedConference);
    }
    @Override
    public ConferenceDTO updateConference(ConferenceDTO conferenceDTO) {
        Conference conference = dtoMapper.fromConferenceDTO(conferenceDTO);
        Conference savedConference = conferenceRepository.save(conference);
        return dtoMapper.fromConference(savedConference);
    }

    @Override
    public SalleDTO updateSalle(SalleDTO salleDTO) {
        Salle salle = dtoMapper.fromSalleDTO(salleDTO);
        Salle savedSalle = salleRepository.save(salle);
        return dtoMapper.fromSalle(savedSalle);
    }

    @Override
    public SessionDTO updateSession(SessionDTO sessionDTO) {
        Session session = dtoMapper.fromSessionDTO(sessionDTO);
        Session savedSession = sessionRepository.save(session);
        return dtoMapper.fromSession(savedSession);
    }

    @Override
    public InscriptionDTO updateInscription(InscriptionDTO inscriptionDTO) {
        Inscription inscription = dtoMapper.fromInscriptionDTO(inscriptionDTO);
        Inscription savedInscription = inscriptionRepository.save(inscription);
        return dtoMapper.fromInscription(savedInscription);
    }

    @Override
    public ParticipantDTO updateParticipant(ParticipantDTO participantDTO) {
        Participant participant = dtoMapper.fromParticipantDTO(participantDTO);
        if (participant instanceof Invite) {
            Invite savedInvite = (Invite) participantRepository.save(participant);
            return dtoMapper.fromInvite(savedInvite);
        } else if (participant instanceof Moderateur) {
            Moderateur savedModerateur = (Moderateur) participantRepository.save(participant);
            return dtoMapper.fromModerateur(savedModerateur);
        } else if (participant instanceof Speaker) {
            Speaker savedSpeaker = (Speaker) participantRepository.save(participant);
            return dtoMapper.fromSpeaker(savedSpeaker);
        } else
            return null;
    }

    @Override
    public void deleteCommentaire(Long commentaireId) {
        commentaireRepository.deleteById(commentaireId);

    }

    @Override
    public void deleteConference(Long conferenceId) {
        conferenceRepository.deleteById(conferenceId);
    }

    @Override
    public void deleteSalle(Long salleId) {
        salleRepository.deleteById(salleId);
    }

    @Override
    public void deleteSession(Long sessionId) {
        sessionRepository.deleteById(sessionId);
    }

    @Override
    public void deleteInscription(Long inscriptionId) {
        inscriptionRepository.deleteById(inscriptionId);
    }

    @Override
    public void deleteParticipant(Long participantId) {
        participantRepository.deleteById(participantId);
    }

    @Override
    public SessionDTO addConferenceToSession(Long idSession, Long idConference) {
        Conference conference = conferenceRepository.findById(idConference).orElseThrow();
        Session session = sessionRepository.findById(idSession).orElseThrow();
        session.getConferences().add(conference);
        conference.setSession(session);
        return dtoMapper.fromSession(session);
    }

    @Override
    public SessionDTO removeConferenceFromSession(Long idSession, Long idConference) {

        return null;
    }

    @Override
    public SessionDTO addModerateurToSession(Long idSession, Long idModerateur) {
        Participant participant = participantRepository.findById(idModerateur).orElseThrow();
        Session session = sessionRepository.findById(idSession).orElseThrow();
        session.setModerateur((Moderateur) participant);
        ((Moderateur) participant).getSessions().add(session);
        return dtoMapper.fromSession(session);
    }

    @Override
    public SessionDTO removeModerateurFromSession(Long idSession, Long idModerateur) {
        return null;
    }

    @Override
    public SessionDTO addSalleToSession(Long idSession, Long idSalle) {
        return null;
    }

    @Override
    public SessionDTO removeSalleFromSession(Long idSession, Long idSalle) {
        return null;
    }

    @Override
    public SessionDTO addInscriptionToSession(Long idSession, Long idInscription) {
        return null;
    }

    @Override
    public SessionDTO removeInscriptionFromSession(Long idSession, Long idInscription) {
        return null;
    }

    @Override
    public InscriptionDTO getInscription(Long inscriptionId) {
        Inscription inscription = inscriptionRepository.findById(inscriptionId).orElseThrow(() ->
                new RuntimeException("Inscription not found"));
        return dtoMapper.fromInscription(inscription);
    }
}
