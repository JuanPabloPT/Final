package upc.edu.pe.postulantmicroservice.services;

import upc.edu.pe.postulantmicroservice.entity.CV;
import upc.edu.pe.postulantmicroservice.entity.Language;

import java.util.List;

public interface LanguageService {
    public List<Language> findAllLanguages();
    public Language getLanguage(Long id);
    public Language createLanguage(Language language);
    public Language updateLanguage(Language language);
    public Language deleteLanguage(Long id);
}
