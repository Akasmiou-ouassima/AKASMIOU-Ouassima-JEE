package org.sid.gestion_conference.dao.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@DiscriminatorValue("Moderateur")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Moderateur extends Participant{
    private String specialite;
    @OneToMany(mappedBy = "moderateur")
    private List<Session> sessions;
}
