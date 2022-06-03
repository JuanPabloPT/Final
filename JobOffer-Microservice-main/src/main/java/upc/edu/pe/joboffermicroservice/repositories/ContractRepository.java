package upc.edu.pe.joboffermicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.joboffermicroservice.entity.Contract;


public interface ContractRepository extends JpaRepository<Contract, Long> {
}
