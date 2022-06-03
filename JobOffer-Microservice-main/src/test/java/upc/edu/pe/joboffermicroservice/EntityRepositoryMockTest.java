package upc.edu.pe.joboffermicroservice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import upc.edu.pe.joboffermicroservice.entity.Contract;
import upc.edu.pe.joboffermicroservice.entity.Interview;
import upc.edu.pe.joboffermicroservice.entity.JobOffer;
import upc.edu.pe.joboffermicroservice.repositories.ContractRepository;
import upc.edu.pe.joboffermicroservice.repositories.InterviewRepository;
import upc.edu.pe.joboffermicroservice.repositories.JobOfferRepository;

import java.util.Date;

@DataJpaTest
public class EntityRepositoryMockTest {
    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private JobOfferRepository jobOfferRepository;

    @Test
    public void contractTest() {
        Contract contract = Contract.builder()
                .createdAt(new Date())
                .description("THIS IS A DESCRIPTION")
                .confirmation(true)
                .status("active")
                .build();
        contractRepository.save(contract);

        Contract contract1 = contractRepository.getById(1L);
        Assertions.assertThat(contract1.getConfirmation()).isEqualTo(contract1.getConfirmation());
    }

    @Test
    public void interviewTest(){
        Interview interview = Interview.builder()
                .date(new Date())
                .link("https//paginadeprueba.com/")
                .pending(true)
                .build();
        interviewRepository.save(interview);

        Interview interview1 = interviewRepository.getById(1L);
        Assertions.assertThat(interview1.getDate()).isEqualTo(interview.getDate());
    }

    @Test
    public void jobOfferTest(){
        JobOffer jobOffer = JobOffer.builder()
                .date(new Date())
                .description("DESCRIPTION")
                .createdAt(new Date())
                .experience("yes")
                .name("BACKEND")
                .salary(3000.0)
                .status("active")
                .type("virtual")
                .build();
        jobOfferRepository.save(jobOffer);

        JobOffer jobOffer1 = jobOfferRepository.getById(1L);
        Assertions.assertThat(jobOffer1.getName()).isEqualTo(jobOffer.getName());
    }
}
