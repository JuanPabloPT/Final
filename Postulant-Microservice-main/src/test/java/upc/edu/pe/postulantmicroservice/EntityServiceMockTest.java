package upc.edu.pe.postulantmicroservice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import upc.edu.pe.postulantmicroservice.entity.Postulant;
import upc.edu.pe.postulantmicroservice.repositories.PostulantRepository;
import upc.edu.pe.postulantmicroservice.services.PostulantService;
import upc.edu.pe.postulantmicroservice.services.PostulantServiceImpl;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
public class EntityServiceMockTest {
    @Mock
    private PostulantRepository postulantRepository;

    private PostulantService postulantService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        postulantService = new PostulantServiceImpl(postulantRepository);
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
        Mockito.when(postulantRepository.findById(1L))
                .thenReturn(Optional.of(postulant));
        Mockito.when(postulantRepository.save(postulant)).thenReturn(postulant);
    }

    @Test
    public void whenValidGetID_ThenReturnProduct(){
        Postulant foundPostulant = postulantService.getPostulant(1L);

        Assertions.assertThat(foundPostulant.getFirstName()).isEqualTo("Bryan");

    }
}
