package upc.edu.pe.postulantmicroservice.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.postulantmicroservice.entity.Language;
import upc.edu.pe.postulantmicroservice.services.LanguageService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/language")
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    @GetMapping
    public ResponseEntity<List<Language>> getAllLanguage() {
        List<Language> languageList = languageService.findAllLanguages();
        if(languageList == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(languageList);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Language> getLanguage(@PathVariable("id")Long id) {
        Language language = languageService.getLanguage(id);
        if(language == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(language);
    }
    @PostMapping
    public ResponseEntity<Language> createLanguage(@RequestBody Language language) {
        if(language == null) return ResponseEntity.noContent().build();
        languageService.createLanguage(language);
        return ResponseEntity.status(HttpStatus.CREATED).body(language);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Language> updateLanguage(@PathVariable("id")Long id, @RequestBody Language language){
        if(id == null || language == null) return ResponseEntity.noContent().build();
        language.setId(id);
        languageService.updateLanguage(language);
        return ResponseEntity.ok(language);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteLanguage(@PathVariable Long id) {
        Language language = languageService.getLanguage(id);
        if(language == null) return;
        languageService.deleteLanguage(id);
    }
}
