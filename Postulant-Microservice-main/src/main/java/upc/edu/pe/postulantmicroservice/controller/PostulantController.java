package upc.edu.pe.postulantmicroservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.postulantmicroservice.entity.Postulant;
import upc.edu.pe.postulantmicroservice.services.PostulantService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/postulant")
public class PostulantController {
    @Autowired
    private PostulantService postulantService;

    @GetMapping
    public ResponseEntity<List<Postulant>> getAllPostulant() {
        List<Postulant> postulantList = postulantService.findAllPostulants();
        if(postulantList == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(postulantList);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Postulant> getPostulant(@PathVariable("id")Long id) {
        Postulant postulant = postulantService.getPostulant(id);
        if(postulant == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(postulant);
    }
    @PostMapping
    public ResponseEntity<Postulant> createPostulant(@RequestBody Postulant postulant) {
        if(postulant == null) return ResponseEntity.noContent().build();
        postulantService.createPostulant(postulant);
        return ResponseEntity.status(HttpStatus.CREATED).body(postulant);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Postulant> updatePostulant(@PathVariable("id")Long id, @RequestBody Postulant postulant){
        if(id == null || postulant == null) return ResponseEntity.noContent().build();
        postulant.setId(id);
        postulantService.updatePostulant(postulant);
        return ResponseEntity.ok(postulant);
    }
    @DeleteMapping(value = "/{id}")
    public void deletePostulant(@PathVariable Long id) {
        Postulant postulant = postulantService.getPostulant(id);
        if(postulant == null) return;
        postulantService.deletePostulant(id);
    }
}