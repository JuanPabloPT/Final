package upc.edu.pe.postulantmicroservice.services;

import upc.edu.pe.postulantmicroservice.entity.CV;

import java.util.List;

public interface CVService {
    public List<CV> findAllCV();
    public CV getCV(Long id);
    public CV createCV(CV cv);
    public CV updateCV(CV cv);
    public CV deleteCV(Long id);
}
