package org.sid.gestion_conference.dao.repositories;

import org.sid.gestion_conference.dao.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long>{
}
