package ma.enset.etudiants.repository;

import ma.enset.etudiants.entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Page<Etudiant> findByNomContains(String kw, Pageable pageable);
}
