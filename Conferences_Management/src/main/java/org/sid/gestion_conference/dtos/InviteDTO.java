package org.sid.gestion_conference.dtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.sid.gestion_conference.dao.enums.Genre;

@Data
public class InviteDTO extends ParticipantDTO{
    private Long id;
    private String nom;
    private String email;
    private Genre genre;
    private String affiliation;
}
