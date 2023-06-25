package org.sid.gestion_conference.dao.repositories;

import org.sid.gestion_conference.dao.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
}
