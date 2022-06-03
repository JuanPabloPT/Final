package upc.edu.pe.postulantmicroservice.services;

import upc.edu.pe.postulantmicroservice.entity.Postulant;

import java.util.List;

public interface PostulantService {
    public List<Postulant> findAllPostulants();
    public Postulant getPostulant(Long id);
    public Postulant createPostulant(Postulant postulant);
    public Postulant updatePostulant(Postulant postulant);
    public Postulant deletePostulant(Long id);
}
