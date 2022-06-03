package pe.edu.upc.postulation.service;

import pe.edu.upc.postulation.entity.Postulation;

import java.util.List;

public interface PostulationService {
    public List<Postulation> findPostulationAll();

    public Postulation createPostulation(Postulation postulation);
    public Postulation deletePostulation(Postulation postulation);

    public Postulation getPostulation(Long id);
}
