package upc.edu.pe.postulantmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.postulantmicroservice.entity.Postulant;
import upc.edu.pe.postulantmicroservice.entity.Study;

import java.util.List;

public interface StudyRepository extends JpaRepository<Study, Long> {
    public List<Study> findByName(String name);
}
