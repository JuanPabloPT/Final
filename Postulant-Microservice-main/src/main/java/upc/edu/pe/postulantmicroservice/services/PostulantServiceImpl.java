package upc.edu.pe.postulantmicroservice.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.postulantmicroservice.entity.Postulant;
import upc.edu.pe.postulantmicroservice.repositories.PostulantRepository;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor @NoArgsConstructor
public class PostulantServiceImpl implements PostulantService{
    @Autowired
    private PostulantRepository postulantRepository;

    @Override
    public List<Postulant> findAllPostulants(){
        return postulantRepository.findAll();
    }

    @Override
    public Postulant getPostulant(Long id){
        return postulantRepository.findById(id).orElse(null);
    }

    public Postulant createPostulant(Postulant postulant){
       //Postulant postulantDB = postulantRepository.findById(postulant.getId()).orElse(null);
        //if(postulantDB != null){
         //   return postulantDB;
       // }
       postulantRepository.save(postulant);
        return postulant;
    }
    public Postulant updatePostulant(Postulant postulant){
        Postulant postulantDB = postulantRepository.findById(postulant.getId()).orElse(null);
        if(postulantDB == null){
            return null;
        }
        postulantDB.setFirstName(postulant.getFirstName());
        postulantDB.setLastName(postulant.getLastName());
        postulantDB.setNumber(postulant.getNumber());
        postulantDB.setEmail(postulant.getEmail());
        postulantDB.setPassword(postulant.getPassword());
        postulantDB.setDocument(postulant.getDocument());
        postulantDB.setCivilStatus(postulant.getCivilStatus());
        postulantDB.setBirthday(postulant.getBirthday());

        return postulantRepository.save(postulantDB);
    }
    public Postulant deletePostulant(Long id){
        Postulant postulantDB = postulantRepository.findById(id).orElse(null);
        if(postulantDB == null){
            return null;
        }
        postulantRepository.delete(postulantDB);
        return postulantDB;
    }
}
