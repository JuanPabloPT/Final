package upc.edu.pe.postulantmicroservice.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.postulantmicroservice.entity.CV;
import upc.edu.pe.postulantmicroservice.repositories.CVRepository;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor@NoArgsConstructor
public class CVServiceImpl implements CVService{
    @Autowired
    private CVRepository cvRepository;

    @Override
    public List<CV> findAllCV(){
        return cvRepository.findAll();
    }

    @Override
    public CV getCV(Long id){
        return cvRepository.findById(id).orElse(null);
    }

    public CV createCV(CV cv){
       // CV cvDB = cvRepository.findById(cv.getId()).orElse(null);
        //if(cvDB != null){
         //   return cvDB;
        //}
        cvRepository.save(cv);
        return cv;
    }

    public CV updateCV(CV cv){
        CV cvDB = cvRepository.findById(cv.getId()).orElse(null);
        if(cvDB == null){
            return null;
        }
        cvDB.setExperience(cv.getExperience());
        cvDB.setOcupation(cv.getOcupation());
        cvDB.setVideo(cv.getVideo());
        cvDB.setPostulant(cv.getPostulant());

        return cvRepository.save(cvDB);
    }

    public CV deleteCV(Long id){
        CV cvDB = cvRepository.findById(id).orElse(null);
        if(cvDB == null){
            return null;
        }
        cvRepository.delete(cvDB);
        return cvDB;
    }
}
