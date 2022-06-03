package upc.edu.pe.postulantmicroservice.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.postulantmicroservice.entity.CV;
import upc.edu.pe.postulantmicroservice.entity.Skill;
import upc.edu.pe.postulantmicroservice.repositories.SkillRepository;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
@NoArgsConstructor
public class SkillServiceImpl implements SkillService {
    @Autowired
    private SkillRepository skillRepository;
    @Override
    public List<Skill> findAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public Skill getSkill(Long id) {
        return skillRepository.findById(id).orElse(null);
    }

    @Override
    public Skill createSkill(Skill skill) {
        //Skill skillDB = skillRepository.findById(skill.getId()).orElse(null);
        //if(skillDB != null){
        //    return skillDB;
        //}
        skillRepository.save(skill);
        return skill;
    }

    @Override
    public Skill updateSkill(Skill skill) {
        Skill skillDB = skillRepository.findById(skill.getId()).orElse(null);
        if(skillDB == null){
            return null;
        }
        skillDB.setName(skill.getName());
        skillDB.setDescription(skill.getDescription());
        skillDB.setCv(skill.getCv());
        return skillRepository.save(skillDB);
    }

    @Override
    public Skill deleteSkill(Long id) {
        Skill skillDB = skillRepository.findById(id).orElse(null);
        if(skillDB == null){
            return null;
        }
        skillRepository.delete(skillDB);
        return skillDB;
    }
}
