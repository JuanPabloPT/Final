package upc.edu.pe.joboffermicroservice.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.joboffermicroservice.entity.Interview;
import upc.edu.pe.joboffermicroservice.repositories.InterviewRepository;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
@NoArgsConstructor
public class InterviewServiceImpl implements InterviewService{
    @Autowired
    private InterviewRepository interviewRepository;

    @Override
    public List<Interview> findAllInterviews(){
        return interviewRepository.findAll();
    }

    @Override
    public Interview getInterview(Long id){
        return interviewRepository.findById(id).orElse(null);
    }

    public Interview createInterview(Interview interview){
        interviewRepository.save(interview);
        return interview;
    }
    public Interview updateInterview(Interview interview){
        Interview interviewDB = interviewRepository.findById(interview.getId()).orElse(null);
        if(interviewDB == null){
            return null;
        }
        interviewDB.setDate(interview.getDate());
        interviewDB.setLink(interview.getLink());
        interviewDB.setPending(interview.getPending());
        interviewDB.setJobOffer(interview.getJobOffer());

        return interviewRepository.save(interviewDB);
    }
    public Interview deleteInterview(Long id){
        Interview interviewDB = interviewRepository.findById(id).orElse(null);
        if(interviewDB == null){
            return null;
        }
        interviewRepository.delete(interviewDB);
        return interviewDB;
    }
}
