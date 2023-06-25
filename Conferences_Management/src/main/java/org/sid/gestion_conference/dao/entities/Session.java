package org.sid.gestion_conference.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Session {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @OneToMany(mappedBy = "session",fetch = FetchType.LAZY)
    private List<Conference> conferences;
    @ManyToOne(fetch = FetchType.LAZY)
    private Salle salle;
    @ManyToOne(fetch = FetchType.LAZY)
    private Moderateur moderateur;
    @OneToOne(mappedBy = "session")
    private Inscription inscription;
}
