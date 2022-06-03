package upc.edu.pe.postulantmicroservice.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.postulantmicroservice.entity.CV;
import upc.edu.pe.postulantmicroservice.entity.Study;
import upc.edu.pe.postulantmicroservice.repositories.StudyRepository;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
@NoArgsConstructor
public class StudyServiceImpl implements StudyService{
    @Autowired
    private StudyRepository studyRepository;
    @Override
    public List<Study> findAllStudies() {
        return studyRepository.findAll();
    }

    @Override
    public Study getStudy(Long id) {
        return studyRepository.findById(id).orElse(null);
    }

    @Override
    public Study createStudy(Study study) {
        //Study studyDB = studyRepository.findById(study.getId()).orElse(null);
        //if(studyDB != null){
        //    return studyDB;
        //}
        studyRepository.save(study);
        return study;
    }

    @Override
    public Study updateStudy(Study study) {
        Study studyDB = studyRepository.findById(study.getId()).orElse(null);
        if(studyDB == null){
            return null;
        }
        studyDB.setName(study.getName());
        studyDB.setDegree(study.getDegree());
        studyDB.setCv(study.getCv());

        return studyRepository.save(studyDB);
    }

    @Override
    public Study deleteStudy(Long id) {
        Study studyDB = studyRepository.findById(id).orElse(null);
        if(studyDB == null){
            return null;
        }
        studyRepository.delete(studyDB);
        return studyDB;
    }
}
