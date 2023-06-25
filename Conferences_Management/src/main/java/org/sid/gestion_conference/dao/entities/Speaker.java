package org.sid.gestion_conference.dao.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@DiscriminatorValue("Speaker")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Speaker extends Participant{
    private String urlProfile;
    @OneToMany(mappedBy = "speaker")
    private List<Conference> conferences;
}
