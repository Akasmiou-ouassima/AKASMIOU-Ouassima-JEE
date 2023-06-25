package org.sid.gestion_conference.dao.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@DiscriminatorValue("Invite")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invite extends Participant{
    private String affiliation;
    @OneToMany(mappedBy = "invite")
    private List<Inscription> inscription;
}
