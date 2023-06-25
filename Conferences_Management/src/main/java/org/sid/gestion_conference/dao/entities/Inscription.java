package org.sid.gestion_conference.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.gestion_conference.dao.enums.Statut;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private float prix;
    @Enumerated(EnumType.STRING)
    private Statut statut;
    @OneToOne
    private Session session;
    @ManyToOne(fetch = FetchType.LAZY)
    private Invite invite;
}
