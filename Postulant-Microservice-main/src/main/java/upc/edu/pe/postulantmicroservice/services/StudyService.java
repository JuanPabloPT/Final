package upc.edu.pe.postulantmicroservice.services;

import upc.edu.pe.postulantmicroservice.entity.Study;

import java.util.List;

public interface StudyService {
    public List<Study> findAllStudies();
    public Study getStudy(Long id);
    public Study updateStudy(Study study);
    public Study createStudy(Study study);
    public Study deleteStudy(Long id);
}
