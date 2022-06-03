package upc.edu.pe.joboffermicroservice.services;

import upc.edu.pe.joboffermicroservice.entity.Contract;

import java.util.List;

public interface ContractService {
    public List<Contract> findAllContracts();
    public Contract getContract(Long id);
    public Contract createContract(Contract contract);
    public Contract updateContract(Contract contract);
    public Contract deleteContract(Long id);
}
