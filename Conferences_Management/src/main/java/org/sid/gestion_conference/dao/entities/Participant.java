package org.sid.gestion_conference.dao.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.gestion_conference.dao.enums.Genre;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",  length = 20)
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String photo;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @OneToMany(mappedBy = "participant")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Commentaire> commentaires;
}
