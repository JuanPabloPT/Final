package upc.edu.pe.postulantmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.postulantmicroservice.entity.Postulant;

import java.util.List;

public interface PostulantRepository extends JpaRepository<Postulant, Long> {
    public List<Postulant> findByFirstName(String firstName);
    public List<Postulant> findByLastName( String lastName);
}
