package org.sid.gestion_conference.dao.repositories;

import org.sid.gestion_conference.dao.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
