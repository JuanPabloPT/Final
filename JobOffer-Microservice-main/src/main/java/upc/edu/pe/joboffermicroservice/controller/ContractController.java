package upc.edu.pe.joboffermicroservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.joboffermicroservice.entity.Contract;
import upc.edu.pe.joboffermicroservice.services.ContractService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @GetMapping
    public ResponseEntity<List<Contract>> getAllContracts() {
        List<Contract> contractList = contractService.findAllContracts();
        if(contractList == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(contractList);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Contract> getContract(@PathVariable("id")Long id) {
        Contract contract = contractService.getContract(id);
        if(contract == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(contract);
    }
    @PostMapping
    public ResponseEntity<Contract> createContract(@RequestBody Contract contract) {
        if(contract == null) return ResponseEntity.noContent().build();
        contractService.createContract(contract);
        return ResponseEntity.status(HttpStatus.CREATED).body(contract);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Contract> updateContract(@PathVariable("id")Long id, @RequestBody Contract contract){
        if(id == null || contract == null) return ResponseEntity.noContent().build();
        contract.setId(id);
        contractService.updateContract(contract);
        return ResponseEntity.ok(contract);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteContract(@PathVariable Long id) {
        Contract contract = contractService.getContract(id);
        if(contract == null) return;
        contractService.deleteContract(id);
    }
}
