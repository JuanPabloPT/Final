package pe.edu.upc.postulation.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.upc.postulation.model.JobOffer;


@FeignClient(name = "JobOffer-Microservice-main")
@RequestMapping(value = "/joboffer")
public interface JobOfferClient {

    @GetMapping(value = "/{id}")
    public ResponseEntity<JobOffer> getJobOffer(@PathVariable("id")Long id);
}
