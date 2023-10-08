package org.sid.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Etudiant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
@Column(length = 50)
    private String email;
    @Temporal(TemporalType.DATE) //pour garder seulement la date et supprimer l´heure
    private Date dateNaissance;
    private int score;
}
