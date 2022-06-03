package upc.edu.pe.postulantmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.postulantmicroservice.entity.CV;
import upc.edu.pe.postulantmicroservice.entity.Postulant;

import java.util.List;

public interface CVRepository extends JpaRepository<CV, Long> {
    public List<CV> findByPostulant(Postulant postulant);
}
