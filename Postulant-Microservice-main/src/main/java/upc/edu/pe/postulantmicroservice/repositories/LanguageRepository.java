package upc.edu.pe.postulantmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.postulantmicroservice.entity.Language;
import upc.edu.pe.postulantmicroservice.entity.Postulant;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    public List<Language> findByName(String name);
}
