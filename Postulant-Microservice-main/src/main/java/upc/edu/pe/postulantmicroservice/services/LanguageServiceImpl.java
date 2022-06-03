package upc.edu.pe.postulantmicroservice.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.postulantmicroservice.entity.Language;
import upc.edu.pe.postulantmicroservice.repositories.LanguageRepository;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor @NoArgsConstructor
public class LanguageServiceImpl implements  LanguageService{
    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public List<Language> findAllLanguages(){
        return languageRepository.findAll();
    }

    @Override
    public Language getLanguage(Long id){
        return languageRepository.findById(id).orElse(null);
    }

    public Language createLanguage(Language language){
        //Language languageDB = languageRepository.findById(language.getId()).orElse(null);
        //if(languageDB != null){
        //    return languageDB;
        //}
        languageRepository.save(language);
        return language;
    }

    public Language updateLanguage(Language language){
        Language languageDB = languageRepository.findById(language.getId()).orElse(null);
        if(languageDB == null){
            return null;
        }
        languageDB.setName(language.getName());
        languageDB.setLevel(language.getLevel());
        languageDB.setCv(language.getCv());

        return languageRepository.save(languageDB);
    }

    public Language deleteLanguage(Long id){
        Language languageDB = languageRepository.findById(id).orElse(null);
        if(languageDB == null){
            return null;
        }
        languageRepository.delete(languageDB);
        return languageDB;
    }

}
