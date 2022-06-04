package pe.edu.upc.postulation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.postulation.entity.Postulation;
import pe.edu.upc.postulation.service.PostulationService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/postulation")
public class PostulationController {

    @Autowired
    PostulationService postulationService;

    @GetMapping
    public ResponseEntity<List<Postulation>> listAllPostulation() {
        List<Postulation> postulations = postulationService.findPostulationAll();
        if (postulations.isEmpty()) {
            return  ResponseEntity.noContent().build();
        }
        return  ResponseEntity.ok(postulations);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Postulation> getPostulation(@PathVariable("id") long id) {
        log.info("Fetching Postulation with id {}", id);
        Postulation postulation  = postulationService.getPostulation(id);
        if (null == postulation) {
            log.error("Postulation with id {} not found.", id);
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(postulation);
    }

    @PostMapping
    public ResponseEntity<Postulation> createPostulation(@Valid @RequestBody Postulation postulation, BindingResult result) {
        log.info("Creating Postulation : {}", postulation);
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        Postulation postulationDB = postulationService.createPostulation (postulation);

        return  ResponseEntity.status( HttpStatus.CREATED).body(postulationDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Postulation> deletePostulation(@PathVariable("id") long id) {
        log.info("Fetching & Deleting Postulation with id {}", id);

        Postulation postulation = postulationService.getPostulation(id);
        if (postulation == null) {
            log.error("Unable to delete. Postulation with id {} not found.", id);
            return  ResponseEntity.notFound().build();
        }
        postulation = postulationService.deletePostulation(postulation);
        return ResponseEntity.ok(postulation);
    }

    private String formatMessage( BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err ->{
                    Map<String,String> error =  new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;

                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString="";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
