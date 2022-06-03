package upc.edu.pe.postulantmicroservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.postulantmicroservice.entity.Skill;
import upc.edu.pe.postulantmicroservice.services.SkillService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/skill")
public class SkillController {
    @Autowired
    private SkillService skillService;

    @GetMapping
    public ResponseEntity<List<Skill>> getAllStudies() {
        List<Skill>  skillList = skillService.findAllSkills();
        if(skillList == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(skillList);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Skill> getSkill(@PathVariable("id")Long id) {
        Skill skill = skillService.getSkill(id);
        if(skill == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(skill);
    }
    @PostMapping
    public ResponseEntity<Skill> createSkill(@RequestBody Skill skill) {
        if(skill == null) return ResponseEntity.noContent().build();
        skillService.createSkill(skill);
        return ResponseEntity.status(HttpStatus.CREATED).body(skill);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Skill> updateSkill(@PathVariable("id")Long id, @RequestBody Skill skill){
        if(id == null || skill == null) return ResponseEntity.noContent().build();
        skill.setId(id);
        skillService.updateSkill(skill);
        return ResponseEntity.ok(skill);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteSkill(@PathVariable Long id) {
        Skill skill = skillService.getSkill(id);
        if(skill == null) return;
        skillService.deleteSkill(id);
    }
}
