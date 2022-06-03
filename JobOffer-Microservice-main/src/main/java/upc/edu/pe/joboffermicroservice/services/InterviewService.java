package upc.edu.pe.joboffermicroservice.services;

import upc.edu.pe.joboffermicroservice.entity.Interview;

import java.util.List;

public interface InterviewService {
    public List<Interview> findAllInterviews();
    public Interview getInterview(Long id);
    public Interview createInterview(Interview interview);
    public Interview updateInterview(Interview interview);
    public Interview deleteInterview(Long id);
}
