package upc.edu.pe.joboffermicroservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.joboffermicroservice.entity.JobOffer;
import upc.edu.pe.joboffermicroservice.services.JobOfferService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/joboffer")
public class JobOfferController {
    @Autowired
    private JobOfferService jobOfferService;

    @GetMapping
    public ResponseEntity<List<JobOffer>> getAllJobOffers() {
        List<JobOffer> jobOfferList = jobOfferService.findAllJobOffers();
        if(jobOfferList == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(jobOfferList);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<JobOffer> getJobOffer(@PathVariable("id")Long id) {
        JobOffer jobOffer = jobOfferService.getJobOffer(id);
        if(jobOffer == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(jobOffer);
    }
    @PostMapping
    public ResponseEntity<JobOffer> createJobOffer(@RequestBody JobOffer jobOffer) {
        if(jobOffer == null) return ResponseEntity.noContent().build();
        jobOfferService.createJobOffer(jobOffer);
        return ResponseEntity.status(HttpStatus.CREATED).body(jobOffer);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<JobOffer> updateJobOffer(@PathVariable("id")Long id, @RequestBody JobOffer jobOffer){
        if(id == null || jobOffer == null) return ResponseEntity.noContent().build();
        jobOffer.setId(id);
        jobOfferService.updateJobOffer(jobOffer);
        return ResponseEntity.ok(jobOffer);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteJobOffer(@PathVariable Long id) {
        JobOffer jobOffer = jobOfferService.getJobOffer(id);
        if(jobOffer == null) return;
        jobOfferService.deleteJobOffer(id);
    }
}
