package org.sid.gestion_conference.dtos;

import lombok.Data;

@Data
public class ModerateurDTO extends ParticipantDTO{
    private Long id;
    private String nom;
    private String email;
    private String specialite;
}
