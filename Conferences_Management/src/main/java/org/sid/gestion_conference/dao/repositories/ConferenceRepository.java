package org.sid.gestion_conference.dao.repositories;

import org.sid.gestion_conference.dao.entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {
}
