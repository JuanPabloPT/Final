package upc.edu.pe.postulantmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.postulantmicroservice.entity.Postulant;
import upc.edu.pe.postulantmicroservice.entity.Skill;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    public List<Skill> findByName(String name);
}
