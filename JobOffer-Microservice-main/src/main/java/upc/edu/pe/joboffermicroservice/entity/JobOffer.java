package upc.edu.pe.joboffermicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "tbl_joboffers")
@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre no debe quedar vacío")
    private String name;

    @NotEmpty(message = "La descripción no debe quedar vacía")
    private String description;

    @NotNull
    @Column(name = "salary")
    private Double salary;

    @NotEmpty(message = "La modalidad no debe quedar vacía")
    private String type;

    @Temporal(TemporalType.DATE)
    private Date date;

    @NotEmpty(message = "La experiencia no debe quedar vacía")
    private String experience;

    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @NotEmpty(message = "El estado no debe quedar vacío")
    private String status;
}
