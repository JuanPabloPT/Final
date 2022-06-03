package upc.edu.pe.joboffermicroservice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import upc.edu.pe.joboffermicroservice.entity.JobOffer;
import upc.edu.pe.joboffermicroservice.repositories.InterviewRepository;
import upc.edu.pe.joboffermicroservice.repositories.JobOfferRepository;
import upc.edu.pe.joboffermicroservice.services.InterviewService;
import upc.edu.pe.joboffermicroservice.services.InterviewServiceImpl;
import upc.edu.pe.joboffermicroservice.services.JobOfferService;
import upc.edu.pe.joboffermicroservice.services.JobOfferServiceImpl;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
public class EntityServiceMockTest {
    @Mock
    private JobOfferRepository jobOfferRepository;

    private JobOfferService jobOfferService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        jobOfferService = new JobOfferServiceImpl(jobOfferRepository);
        JobOffer jobOffer = JobOffer.builder()
                .date(new Date())
                .type("virtual")
                .name("BACKEND")
                .status("active")
                .experience("yes")
                .salary(3000.0)
                .createdAt(new Date())
                .description("DESCRIPTION")
                .build();
        Mockito.when(jobOfferRepository.findById(1L))
                .thenReturn(Optional.of(jobOffer));
        Mockito.when(jobOfferRepository.save(jobOffer)).thenReturn(jobOffer);
    }

    @Test
    public void whenValidGetID_ThenReturnProduct(){
        JobOffer foundJobOffer = jobOfferService.getJobOffer(1L);
        Assertions.assertThat(foundJobOffer.getName()).isEqualTo("BACKEND");
    }

}
