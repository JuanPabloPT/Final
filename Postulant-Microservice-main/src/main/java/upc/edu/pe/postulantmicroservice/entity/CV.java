package upc.edu.pe.postulantmicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tbl_cv")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Tu ocupación no puede quedar vacío")
    private String ocupation;

    private String video;
    @NotEmpty(message = "La experiencia no puede quedar vacío")
    private String experience;

    @OneToOne
    @JoinColumn(name = "fk_postulant", updatable = false, nullable = false)
    private Postulant postulant;

}
