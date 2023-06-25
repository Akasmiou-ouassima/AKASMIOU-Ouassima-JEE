package org.sid.gestion_conference.dao.repositories;

import org.sid.gestion_conference.dao.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
}
