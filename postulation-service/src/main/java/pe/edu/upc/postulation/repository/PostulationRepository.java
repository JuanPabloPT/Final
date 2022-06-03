package pe.edu.upc.postulation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.postulation.entity.Postulation;

import java.util.List;

public interface PostulationRepository extends JpaRepository<Postulation,Long> {
    public Postulation findByNumberPostulation(String numberPostulation);
    public Postulation findByJobOfferId(Long jobOfferId);
}
