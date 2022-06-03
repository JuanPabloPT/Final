package upc.edu.pe.postulantmicroservice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import upc.edu.pe.postulantmicroservice.entity.*;
import upc.edu.pe.postulantmicroservice.repositories.*;

import java.util.Date;

@DataJpaTest
public class EntityRepositoryMockTest {
    @Autowired
    private PostulantRepository postulantRepository;

    @Autowired
    private CVRepository cvRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private StudyRepository studyRepository;

    @Test
    public void postulantTest() {

        Postulant postulant = Postulant.builder()
                .firstName("Bryan")
                .lastName("Vela")
                .number("972179130")
                .email("bdvela@gmail.com")
                .password("holamundo123")
                .document("73734567")
                .civilStatus("soltero")
                .birthday(new Date())
                .build();
        postulantRepository.save(postulant);

        Postulant postulantTest = postulantRepository.getById(1L);
        Assertions.assertThat(postulantTest.getFirstName()).isEqualTo(postulant.getFirstName());
    }

    @Test
    public void cvTest(){
        CV cv = CV.builder()
                .ocupation("estudiante")
                .experience("sí")
                .video("https://youtube.com/akjdhaskjd")
                .build();
        cvRepository.save(cv);

        CV cvTest = cvRepository.getById(1L);
        Assertions.assertThat(cvTest.getOcupation()).isEqualTo(cv.getOcupation());
    }

    @Test
    public void languageTest(){
        Language language = Language.builder()
                .name("inglés")
                .level(12)
                .build();
        languageRepository.save(language);

        Language languageTest = languageRepository.getById(1L);
        Assertions.assertThat(languageTest.getName()).isEqualTo(language.getName());
    }

    @Test
    public void skillTest(){
        Skill skill = Skill.builder()
                .name("ofimática")
                .description("manejo de office avanzado")
                .build();
        skillRepository.save(skill);

        Skill skillTest = skillRepository.getById(1L);
        Assertions.assertThat(skillTest.getName()).isEqualTo(skill.getName());
    }

    @Test
    public void studyTest(){
        Study study = Study.builder()
                .name("ingeniera de software")
                .degree(7)
                .build();
        studyRepository.save(study);

        Study studyTest = studyRepository.getById(1L);
        Assertions.assertThat(studyTest.getName()).isEqualTo(study.getName());
    }
}
