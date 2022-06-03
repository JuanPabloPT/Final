package upc.edu.pe.joboffermicroservice.services;

import upc.edu.pe.joboffermicroservice.entity.JobOffer;

import java.util.List;

public interface JobOfferService {
    public List<JobOffer> findAllJobOffers();
    public JobOffer getJobOffer(Long id);
    public JobOffer createJobOffer(JobOffer jobOffer);
    public JobOffer updateJobOffer(JobOffer jobOffer);
    public JobOffer deleteJobOffer(Long id);
}
