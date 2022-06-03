package upc.edu.pe.joboffermicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.joboffermicroservice.entity.Interview;

import java.util.List;

public interface InterviewRepository extends JpaRepository<Interview, Long> {
    public List<Interview> findByDate(String date);

}
