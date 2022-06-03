package upc.edu.pe.joboffermicroservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.joboffermicroservice.entity.Interview;
import upc.edu.pe.joboffermicroservice.services.InterviewService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/interview")
public class InterviewController {
    @Autowired
    private InterviewService interviewService;

    @GetMapping
    public ResponseEntity<List<Interview>> getAllInterviews() {
        List<Interview> interviewList = interviewService.findAllInterviews();
        if(interviewList == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(interviewList);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Interview> getInterview(@PathVariable("id")Long id) {
        Interview interview = interviewService.getInterview(id);
        if(interview == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(interview);
    }
    @PostMapping
    public ResponseEntity<Interview> createInterview(@RequestBody Interview interview) {
        if(interview == null) return ResponseEntity.noContent().build();
        interviewService.createInterview(interview);
        return ResponseEntity.status(HttpStatus.CREATED).body(interview);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Interview> updateInterview(@PathVariable("id")Long id, @RequestBody Interview interview){
        if(id == null || interview == null) return ResponseEntity.noContent().build();
        interview.setId(id);
        interviewService.updateInterview(interview);
        return ResponseEntity.ok(interview);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteInterview(@PathVariable Long id) {
        Interview interview = interviewService.getInterview(id);
        if(interview == null) return;
        interviewService.deleteInterview(id);
    }
}
