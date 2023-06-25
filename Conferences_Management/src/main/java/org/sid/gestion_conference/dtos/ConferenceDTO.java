package org.sid.gestion_conference.dtos;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.sid.gestion_conference.dao.entities.Commentaire;
import org.sid.gestion_conference.dao.entities.Session;
import org.sid.gestion_conference.dao.entities.Speaker;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class ConferenceDTO {
    private Long id;
    private String titre;
    private String description;
    private Date date;

    private String heureDebut;
    private String  heureFin;
    private SpeakerDTO speakerDTO;
    private SessionDTO sessionDTO;
}
