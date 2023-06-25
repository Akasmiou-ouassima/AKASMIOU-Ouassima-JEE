package org.sid.gestion_conference.dtos;

import jakarta.persistence.*;
import lombok.Data;
import org.sid.gestion_conference.dao.entities.Invite;
import org.sid.gestion_conference.dao.entities.Session;
import org.sid.gestion_conference.dao.enums.Statut;

import java.util.Date;
@Data
public class InscriptionDTO {
    private Long id;
    private Date date;
    private float prix;
    private Statut statut;

}
