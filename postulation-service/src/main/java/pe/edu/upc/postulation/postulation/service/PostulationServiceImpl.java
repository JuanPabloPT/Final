package pe.edu.upc.postulation.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.postulation.client.JobOfferClient;
import pe.edu.upc.postulation.client.PostulantClient;
import pe.edu.upc.postulation.entity.PostulantsCV;
import pe.edu.upc.postulation.entity.Postulation;
import pe.edu.upc.postulation.model.CV;
import pe.edu.upc.postulation.model.JobOffer;
import pe.edu.upc.postulation.repository.PostulantsCVRepository;
import pe.edu.upc.postulation.repository.PostulationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PostulationServiceImpl implements PostulationService {

    @Autowired
    PostulantsCVRepository postulantsCVRepository;

    @Autowired
    PostulationRepository postulationRepository;

    @Autowired
    PostulantClient postulantClient;

    @Autowired
    JobOfferClient jobOfferClient;

    @Override
    public List<Postulation> findPostulationAll() {
        return postulationRepository.findAll();
    }

    @Override
    public Postulation createPostulation(Postulation postulation){
        Postulation postulationDB = postulationRepository.findByNumberPostulation(postulation.getNumberPostulation());
        if(postulationDB!=null){
            return postulationDB;
        }
        postulation.setState("CREATED");
        postulationDB = postulationRepository.save(postulation);
        return postulationDB;
    }

    @Override
    public Postulation deletePostulation(Postulation postulation){
        Postulation postulationDB = getPostulation(postulation.getId());
        if (postulationDB==null){
            return null;
        }
        postulationDB.setState("DELETED");
        return postulationRepository.save(postulationDB);
    }

    @Override
    public Postulation getPostulation(Long id){
        Postulation postulation = postulationRepository.findById(id).orElse(null);
        if (postulation != null){
            JobOffer jobOffer = jobOfferClient.getJobOffer(postulation.getJobOfferId()).getBody();
            postulation.setJobOffer(jobOffer);

            List<PostulantsCV> listpostulants =postulation.getList().stream().map(postulantsCV -> {
                CV cv = postulantClient.getCV(postulantsCV.getPostulantCVId()).getBody();
                postulantsCV.setCv(cv);
                return postulantsCV;
            }).collect(Collectors.toList());
            postulation.setList(listpostulants);
        }
        return postulation;
    }

}
