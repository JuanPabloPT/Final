package upc.edu.pe.postulantmicroservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.postulantmicroservice.entity.Study;
import upc.edu.pe.postulantmicroservice.services.StudyService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value ="/study")
public class StudyController {
    @Autowired
    private StudyService studyService;

    @GetMapping
    public ResponseEntity<List<Study>> getAllStudies() {
        List<Study> studyList = studyService.findAllStudies();
        if(studyList == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(studyList);
    }
    @PostMapping
    public ResponseEntity<Study> createStudy(@RequestBody Study study) {
        if(study == null) return ResponseEntity.noContent().build();
        studyService.createStudy(study);
        return ResponseEntity.status(HttpStatus.CREATED).body(study);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Study> updateStudy(@PathVariable("id")Long id, @RequestBody Study study){
        if(id == null || study == null) return ResponseEntity.noContent().build();
        study.setId(id);
        studyService.updateStudy(study);
        return ResponseEntity.ok(study);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteStudy(@PathVariable Long id) {
        Study study = studyService.getStudy(id);
        if(study == null) return;
        studyService.deleteStudy(id);
    }
}


