package upc.edu.pe.joboffermicroservice.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.joboffermicroservice.entity.Contract;
import upc.edu.pe.joboffermicroservice.entity.JobOffer;
import upc.edu.pe.joboffermicroservice.repositories.ContractRepository;
import upc.edu.pe.joboffermicroservice.repositories.JobOfferRepository;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
@NoArgsConstructor
public class JobOfferServiceImpl implements JobOfferService{
    @Autowired
    private JobOfferRepository jobOfferRepository;

    @Override
    public List<JobOffer> findAllJobOffers(){
        return jobOfferRepository.findAll();
    }

    @Override
    public JobOffer getJobOffer(Long id){
        return jobOfferRepository.findById(id).orElse(null);
    }

    public JobOffer createJobOffer(JobOffer jobOffer){
        jobOfferRepository.save(jobOffer);
        return jobOffer;
    }
    public JobOffer updateJobOffer(JobOffer jobOffer){
        JobOffer jobOfferDB = jobOfferRepository.findById(jobOffer.getId()).orElse(null);
        if(jobOfferDB == null){
            return null;
        }
        jobOfferDB.setDescription(jobOffer.getDescription());
        jobOfferDB.setCreatedAt(jobOffer.getCreatedAt());
        jobOfferDB.setStatus(jobOffer.getStatus());
        jobOfferDB.setDate(jobOffer.getDate());
        jobOfferDB.setExperience(jobOffer.getExperience());
        jobOfferDB.setSalary(jobOffer.getSalary());
        jobOfferDB.setType(jobOffer.getType());

        return jobOfferRepository.save(jobOfferDB);
    }
    public JobOffer deleteJobOffer(Long id){
        JobOffer jobOfferDB = jobOfferRepository.findById(id).orElse(null);
        if(jobOfferDB == null){
            return null;
        }
        jobOfferRepository.delete(jobOfferDB);
        return jobOfferDB;
    }
}
