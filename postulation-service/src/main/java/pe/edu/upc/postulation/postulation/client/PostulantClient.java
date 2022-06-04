package pe.edu.upc.postulation.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.upc.postulation.model.CV;

@FeignClient(name = "Postulant-Microservice-main")
@RequestMapping(value = "/cv")
public interface PostulantClient {

    @GetMapping(value = "/{id}")
    public ResponseEntity<CV> getCV(@PathVariable("id")Long id);
}
