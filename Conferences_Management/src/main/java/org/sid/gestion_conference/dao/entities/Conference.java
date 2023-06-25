package org.sid.gestion_conference.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String heureDebut;
    private String  heureFin;
    @OneToMany(mappedBy = "conference")
    private List<Commentaire> commentaires;
    @ManyToOne(fetch = FetchType.LAZY)
    private Speaker speaker;
    @ManyToOne(fetch = FetchType.LAZY)
    private Session session;

}
