package upc.edu.pe.joboffermicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.joboffermicroservice.entity.JobOffer;

import java.util.List;

public interface JobOfferRepository extends JpaRepository<JobOffer, Long> {
    public List<JobOffer> findByName(String name);
    public List<JobOffer> findByType( String type);
}
