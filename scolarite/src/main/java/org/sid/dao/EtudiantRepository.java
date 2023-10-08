package org.sid.dao;

import org.sid.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
 List<Etudiant> findByScore(int score);
}
