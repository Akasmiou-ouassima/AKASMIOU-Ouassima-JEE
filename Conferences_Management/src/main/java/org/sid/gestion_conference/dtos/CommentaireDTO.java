package org.sid.gestion_conference.dtos;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class CommentaireDTO {
    private Long id;
    private Date date;
    private String contenu;
    private int nbLike;
}
