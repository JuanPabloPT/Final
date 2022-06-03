package upc.edu.pe.joboffermicroservice.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.joboffermicroservice.entity.Contract;
import upc.edu.pe.joboffermicroservice.repositories.ContractRepository;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
@NoArgsConstructor
public class ContractServiceImpl implements ContractService{
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<Contract> findAllContracts(){
        return contractRepository.findAll();
    }

    @Override
    public Contract getContract(Long id){
        return contractRepository.findById(id).orElse(null);
    }

    public Contract createContract(Contract contract){
        contractRepository.save(contract);
        return contract;
    }
    public Contract updateContract(Contract contract){
        Contract contractDB = contractRepository.findById(contract.getId()).orElse(null);
        if(contractDB == null){
            return null;
        }
        contractDB.setDescription(contract.getDescription());
        contractDB.setConfirmation(contract.getConfirmation());
        contractDB.setStatus(contract.getStatus());
        contractDB.setCreatedAt(contract.getCreatedAt());
        contractDB.setJobOffer(contract.getJobOffer());

        return contractRepository.save(contractDB);
    }
    public Contract deleteContract(Long id){
        Contract contractDB = contractRepository.findById(id).orElse(null);
        if(contractDB == null){
            return null;
        }
        contractRepository.delete(contractDB);
        return contractDB;
    }
}
